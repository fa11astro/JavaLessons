package amusementPark;

public class ChooseAttraction {
    public int[] chooser(String name, int sum, int level) {
        switch (name) {
            case ("Американская горка"):
                AmericanGorka attraction1 = new AmericanGorka();
                attraction1.pay(sum);
                attraction1.levelOfHappiness(level);
                attraction1.areGlasses();
                return new int[] {sum, level};
            case ("Карусель"):
                Carousel attraction2 = new Carousel();
                attraction2.pay(sum);
                attraction2.levelOfHappiness(level);
                attraction2.isMad(sum);
                return new int[] {sum, level};
            case ("Колесо обозрения"):
                FerrisWheel attraction3 = new FerrisWheel();
                attraction3.pay(sum);
                attraction3.levelOfHappiness(level);
                attraction3.isLoser(sum);
                return new int[] {sum, level};
            case ("Катапульта"):
                Catapult attraction4 = new Catapult();
                attraction4.pay(sum);
                attraction4.levelOfHappiness(level);
                attraction4.isFlying(level);
                return new int[] {sum, level};
        }
        return new int[] {0, 0};
    }
}