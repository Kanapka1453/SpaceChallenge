public class U1 extends Rocket {
    int currentPayloadWeightU1 = rocketCurrentWeight - rocketWeight;

    @Override
    // dlaczego tutaj nie moze byc np private, sprawdzic czy mozna zredukowac widocznosc przy override
    public boolean launch() {
        //cast do double niezbedny zeby nie ucielo wartosci po przecinku
        double crashLaunchChanceU1 = 5 * ((double) currentPayloadWeightU1 / rocketCargoLimit);
        /*
        if (Math.random()*100 < crashChanceU1) {
            return false;
        } else {
            return true;
        }
        */

        //simplified version
        return !(Math.random() * 100 < crashLaunchChanceU1);
    }

    @Override
    public boolean land() {
        double crashLandingChanceU1 = 1 * ((double) currentPayloadWeightU1 / rocketCargoLimit);
        return !(Math.random() * 100 < crashLandingChanceU1);
    }


    //constructor
    public U1() {
        rocketCost = 100000000;
        rocketWeight = 10000;
        rocketMaxWeightWithCargo = 18000;
        rocketCargoLimit = rocketMaxWeightWithCargo - rocketWeight;
        rocketCurrentWeight = rocketWeight;

    }
}
