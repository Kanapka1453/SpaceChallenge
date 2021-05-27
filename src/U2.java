public class U2 extends Rocket {
    int currentPayloadWeightU2 = rocketCurrentWeight - rocketWeight;

    @Override
    public boolean launch() {
        double crashLaunchChanceU2 = 4 * ((double) currentPayloadWeightU2 / rocketCargoLimit);
        return !(Math.random() * 100 < crashLaunchChanceU2);
    }

    @Override
    public boolean land() {
        double crashLandingChanceU2 = 8 * ((double) currentPayloadWeightU2 / rocketCargoLimit);
        return !(Math.random() * 100 < crashLandingChanceU2);
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
