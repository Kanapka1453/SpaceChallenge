public class Rocket implements SpaceShip {
    int rocketCost;
    int rocketWeight;
    int rocketMaxWeightWithCargo;
    int rocketCurrentWeight = rocketWeight;
    double launchExplosionChance;
    double landingCrashChance;


    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        //zwraca true/false zaleznie od wyniku wyrazenia
        //wywoluje metode carry, ktora aktualizuje wage statku jesli przedmiot sie zmiescil
        if (item.getWeight() <= (rocketMaxWeightWithCargo - rocketCurrentWeight)) {
            carry(item);
            return true;
        } else {
            return false;
        }

    }

    @Override
    //dlaczego nie moze byc void?
    public int carry(Item item) {
        rocketCurrentWeight = rocketCurrentWeight + item.getWeight();
        return rocketCurrentWeight;
    }
}
