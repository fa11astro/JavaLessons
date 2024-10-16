package amusementPark;

public class FerrisWheel implements Attraction {
    public int pay(int sum) {
        return sum - 10;
    }

    public int levelOfHappiness(int level) {
        System.out.println("WOWWW, you realy liked it!!");
        return level + 5;
    }

    public int isLoser(int sum) {
        if (sum > 25) {
            System.out.println("DAMN, your 5$ flew out of your pocket when you were on top");
            return sum - 5;
        }
        else {
            return sum;
        }
    }
}
