package amusementPark;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String userType = null;
        int sum = 0;
        int level = 0;
        String str = "";

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-v")) {
                userType = "virtual";
                sum = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-u")) {
                userType = "real";
            }

            if (userType == null) {
                System.err.println("No user type specified");
                System.exit(1);
            }

            System.out.println("User type: " + userType);
            while (sum > 0) {
                if (userType == "virtual") {
                    Random random = new Random();
                    String[] types = {"Американская горка", "Карусель", "Колесо обозрения", "Катапульта"};
                    String flag = types[random.nextInt(types.length)];

                }
            }
        }
    }
}