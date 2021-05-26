public class U2 extends Rocket {

    @Override
    public boolean land() {
        int currentPayloadWeightU2 = rocketCurrentWeight - rocketWeight;
        double crashChanceU2 = 4 * ((double) currentPayloadWeightU2 / rocketCargoLimit);
        return !(Math.random() * 100 < crashChanceU2);
    }


    //constructor
    public U2() {
        rocketCost = 120000000;
        rocketWeight = 18000;
        rocketMaxWeightWithCargo = 29000;
        rocketCargoLimit = rocketMaxWeightWithCargo - rocketWeight;
        rocketCurrentWeight = rocketWeight;
    }

}
