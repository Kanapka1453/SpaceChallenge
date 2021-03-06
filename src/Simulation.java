import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    int entirePayloadWeight;
    int totalCost = 0;
    ArrayList<Item> itemArrayList = new ArrayList<>();
    ArrayList<Rocket> u1ArrayList = new ArrayList<>();
    ArrayList<Rocket> u2ArrayList = new ArrayList<>();


    public ArrayList<Item> loadItems() {
        File phaseOneItems = new File("phase-1.txt");
        try {
            Scanner scanner = new Scanner(phaseOneItems);
            while (scanner.hasNextLine()) {
                String itemDesc;
                String itemName;
                int itemWeight;
                // parsuje zawartosc pliku tekstowego. nazwa i waga przedmiotu sa rozdzielone znakiem "="

                itemDesc = scanner.nextLine();
                int nameWeightSeparator = itemDesc.indexOf("=");
                itemName = itemDesc.substring(0, nameWeightSeparator);
                //nameWeightSeparator + 1 po to, aby uciac tez znak "=" z wagi przedmiotu
                itemWeight = Integer.parseInt(itemDesc.substring(nameWeightSeparator + 1));
                itemArrayList.add(new Item(itemName, itemWeight));
                //System.out.println("DEBUG: "itemName + "+" + itemWeight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        entirePayloadWeight=sumPayloadWeight(itemArrayList);
        return itemArrayList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsToTakeArrayList) {
        int payloadWeightLeftForU1 = entirePayloadWeight;

        //wylicza wage wszystkich przedmiotow do zaladowania
        u1ArrayList.add(0, new U1());
        //gdy aktualna waga danej rakiety U1 jest <= maksymalnemu udzwigowi i waga pozostałych do załadowania przedmiotów !=0
        int i = 0; // while loop rocket counter
        int j = 0; // while loop items counter
        while ((u1ArrayList.get(i).rocketCurrentWeight <= u1ArrayList.get(i).rocketMaxWeightWithCargo) && payloadWeightLeftForU1 != 0) {
            if (u1ArrayList.get(i).rocketCurrentWeight + itemsToTakeArrayList.get(j).getWeight() <= u1ArrayList.get(0).rocketMaxWeightWithCargo) {
                u1ArrayList.get(i).rocketCurrentWeight += itemsToTakeArrayList.get(j).getWeight();
                payloadWeightLeftForU1 = payloadWeightLeftForU1 - itemsToTakeArrayList.get(j).getWeight();
                j++;
                //System.out.println("DEBUG:waga rakiety " + i + " wynosi " + u1ArrayList.get(i).rocketCurrentWeight);
            } else {
                u1ArrayList.add(new U1());
                i++;
                System.out.println("DEBUG:stworzono rakietę: " + (i+1));
            }
        }

        return u1ArrayList;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsToTakeArrayList) {
        int payloadWeightLeftForU2 = entirePayloadWeight;
        //wylicza wage wszystkich przedmiotow do zaladowania
        u2ArrayList.add(0, new U2());
        //gdy aktualna waga danej rakiety U1 jest <= maksymalnemu udzwigowi i waga pozostałych do załadowania przedmiotów !=0
        int i = 0; // while loop rocket counter
        int j = 0; // while loop items counter
        while ((u2ArrayList.get(i).rocketCurrentWeight <= u2ArrayList.get(i).rocketMaxWeightWithCargo) && payloadWeightLeftForU2 != 0) {
            if (u2ArrayList.get(i).rocketCurrentWeight + itemsToTakeArrayList.get(j).getWeight() <= u2ArrayList.get(0).rocketMaxWeightWithCargo) {
                u2ArrayList.get(i).rocketCurrentWeight += itemsToTakeArrayList.get(j).getWeight();
                payloadWeightLeftForU2 = payloadWeightLeftForU2 - itemsToTakeArrayList.get(j).getWeight();
                j++;
                //System.out.println("DEBUG:waga rakiety " + i + " wynosi " + u2ArrayList.get(i).rocketCurrentWeight);
            } else {
                u2ArrayList.add(new U2());
                i++;
                System.out.println("DEBUG:stworzono rakietę: " + (i+1));

            }
        }

        return u2ArrayList;
    }


    private int sumPayloadWeight(ArrayList<Item> itemsToTakeArrayList) {
         /*for (int i = 0; i < itemsToTakeArrayList.size(); i++) {
            entirePayloadWeight += itemsToTakeArrayList.get(i).getWeight();
        }*/
        //enhaced for - for each loop
        for (Item item : itemsToTakeArrayList) {
            entirePayloadWeight += item.getWeight();
        }
        return entirePayloadWeight;
    }

    public int runSimulation(ArrayList<Rocket> rocketArrayList) {
        int rocketsSuccessfullySent = 0; //liczba rakiet ktore pretrwaly land i launch
        int i = 0; // inedeks arraylist dla ktorej rakiety wywolywanie jest sprawdzenie land i launch
        int j = 1; // ilosc wyslanych rakiet

        while (rocketsSuccessfullySent < rocketArrayList.size()) {

            boolean successfulLaunch = rocketArrayList.get(i).launch();
            boolean successfulLanding = rocketArrayList.get(i).land();
            if (successfulLaunch && successfulLanding) {
                totalCost += rocketArrayList.get(i).rocketCost;
                i++;
                rocketsSuccessfullySent++;
                System.out.println("Rocket " + j + " survived the launch and landing!");
                System.out.println(rocketsSuccessfullySent + " of the " + rocketArrayList.size() + " rockets rockets successfully took off and landed!");
            }
            if (!successfulLaunch) {
                totalCost += rocketArrayList.get(i).rocketCost;

                System.out.println("Rocket " + j + " rocket crashed during take-off!");
            }
            if (!successfulLanding) {
                totalCost += rocketArrayList.get(i).rocketCost;
                System.out.println("Rocket " + j + " rocket crashed during landing!");
            }
            j++;
        }
        System.out.println("total cost: " + totalCost);
        //to do: tracking kosztow, sprawdzanie czy rakieta sie rozbila


        return totalCost;
    }


}
