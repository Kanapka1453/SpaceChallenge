public class U1 extends Rocket {

    @Override
    // dlaczego tutaj nie moze byc np private, sprawdzic czy mozna zredukowac widocznosc przy override
    public boolean land() {
        int currentPayloadWeightU1 = rocketCurrentWeight - rocketWeight;
        //cast do double niezbedny zeby nie ucielo wartosci po przecinku
        double crashChanceU1 = 5 * ((double) currentPayloadWeightU1 / rocketCargoLimit);
        /*
        if (Math.random()*100 < crashChanceU1) {
            return false;
        } else {
            return true;
        }
        */

        //simplified version
        return !(Math.random() * 100 < crashChanceU1);
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
