package amusementPark;

import java.util.Random;

public class Carousel implements Attraction {
    public int pay(int sum) {
        return sum - 5;
    }

    public int levelOfHappiness(int level) {
        System.out.println("WOWWW, you realy liked it!!");
        return level - 10;
    }

    public int isMad(int sum) {
        Random random = new Random();
        int flag = random.nextInt(4) + 1;
        System.out.println("You were fooled, you ride " + flag + " and paid for each 5$");
        return sum - flag * 5;
    }



}
