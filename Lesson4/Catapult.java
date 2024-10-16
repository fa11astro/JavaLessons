package amusementPark;

import java.util.Random;

public class Catapult implements Attraction {
    public int pay(int sum) {
        return sum - 20;
    }

    public int levelOfHappiness(int level) {
        System.out.println("WOWWW, you realy liked it!!");
        return level;
    }

    public int isFlying(int level) {
        Random random = new Random();
        boolean flag = random.nextBoolean();
        if (flag) {
            System.out.println("You are out( That was the end of your fun.");
            level = -1000;
            return level;
        }
        else {
            System.out.println("It was the best attraction, you are beside yourself with happiness ^_^");
            level += 1000;
            return level;
        }
    }

}
