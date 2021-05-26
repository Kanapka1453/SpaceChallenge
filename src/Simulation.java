import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    int entirePayloadWeight;
    ArrayList<Item> itemArrayList = new ArrayList<>();

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
                System.out.println(itemName + "+" + itemWeight);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemArrayList;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemsToTakeArrayList) {
        ArrayList<U1> u1ArrayList = new ArrayList<>();
        int payloadWeightLeft;
        //wylicza wage wszystkich przedmiotow do zaladowania
        payloadWeightLeft = sumPayloadWeight(itemsToTakeArrayList);
        System.out.println("Total weight:" + payloadWeightLeft);
        u1ArrayList.add(0,new U1());
        //gdy aktualna waga danej rakiety U1 jest <= maksymalnemu udzwigowi i waga pozostałych do załadowania przedmiotów !=0
        int i=0; // while loop rocket counter
        int j=0; // while loop items counter
        while ((u1ArrayList.get(i).rocketCurrentWeight<=u1ArrayList.get(i).rocketMaxWeightWithCargo)&&payloadWeightLeft!=0) {
            if(u1ArrayList.get(i).rocketCurrentWeight+itemsToTakeArrayList.get(j).getWeight()<=u1ArrayList.get(0).rocketMaxWeightWithCargo){
                u1ArrayList.get(i).rocketCurrentWeight+=itemsToTakeArrayList.get(j).getWeight();
                payloadWeightLeft=payloadWeightLeft-itemsToTakeArrayList.get(j).getWeight();
                j++;
                System.out.println("DEBUG:waga rakiety "+i+" wynosi "+u1ArrayList.get(i).rocketCurrentWeight);
            }else {
                u1ArrayList.add(new U1());
                i++;
                System.out.println("DEBUG:stworzono rakietę: "+i);
            }
            System.out.println("DEBUG:payload left: "+payloadWeightLeft);
            System.out.println("DEBUG:załadowana została rakieta: "+i);
        }

        return u1ArrayList;
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


}
