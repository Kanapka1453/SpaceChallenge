public class U1 extends Rocket {
    int currentPayloadWeightU1;

    @Override
    // dlaczego tutaj nie moze byc np private, sprawdzic czy mozna zredukowac widocznosc przy override
    public boolean launch() {
        //TO DO: SPROBOWAC OBLICZAC TO POZA METODA
        currentPayloadWeightU1 = rocketCurrentWeight - rocketWeight;
        double crashLaunchChanceU1 = 5 * ((double) currentPayloadWeightU1 / rocketCargoLimit);
        /*
        if (Math.random()*100 < crashChanceU1) {
            return false;
        } else {
            return true;
        }
        */

        //simplified version
        //System.out.println((double) currentPayloadWeightU1+"/"+(double) rocketCargoLimit);
        //System.out.println(Math.random() * 100+"<"+crashLaunchChanceU1);
        return !(Math.random() * 100 < crashLaunchChanceU1);
    }

    @Override
    public boolean land() {
        currentPayloadWeightU1 = rocketCurrentWeight - rocketWeight;
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
