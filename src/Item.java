public class Item {
    private String name;
    private int weight;


    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return this.name;
    }

    public int getWeight() {
        return this.weight;
    }


    public Item(String itemName, int itemWeight) {
        setName(itemName);
        setWeight(itemWeight);

    }

}
