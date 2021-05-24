import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {

    public ArrayList<Item> loadItems() {
        ArrayList<Item> itemArrayList = new ArrayList<>();
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
        System.out.println("test");
        System.out.println(itemArrayList.get(0).getName() + itemArrayList.get(0).getWeight());
        return itemArrayList;
    }

}
