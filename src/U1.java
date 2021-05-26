public class U1 extends Rocket {

    @Override
    // dlaczego tutaj nie moze byc np private, sprawdzic czy mozna zredukowac widocznosc przy override
    public boolean land(){
        //double crashChance=0.05*(r)

        return true;
    }



    //constructor
    public U1() {
        rocketCost = 100000000;
        rocketWeight = 10000;
        rocketMaxWeightWithCargo = 18000;
        rocketCurrentWeight=rocketWeight;
    }
}
