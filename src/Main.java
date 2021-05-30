public class Main {
    public static void main(String[] args) {
        Simulation newSimulation = new Simulation();
        newSimulation.loadItems();
        newSimulation.loadU1(newSimulation.itemArrayList);
        newSimulation.loadU2(newSimulation.itemArrayList);
        newSimulation.runSimulation(newSimulation.u1ArrayList);
        newSimulation.runSimulation(newSimulation.u2ArrayList);



    }
}
