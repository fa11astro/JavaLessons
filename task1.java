package lab1;
import java.util.Scanner;

public class task1 {
    private static int sumOfDigits(int number) {
        int sum = 0;

        while(number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        while(true) {
            System.out.println("Give me an integer number: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Incorrect input! Give me an integer number: ");
                scanner.next();
            }
        }

        while (number >= 10) {
            number = sumOfDigits(number);
        }

        System.out.println("Result: " + number);
        scanner.close();
    }
}
