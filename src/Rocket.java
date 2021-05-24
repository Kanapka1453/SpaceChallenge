public class Rocket implements SpaceShip {
int rocketCost;
int rocketWeight;
int rocketMaxWeight;
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
        return false;
    }

    @Override
    public int carry(Item item) {
        return 0;
    }
}
