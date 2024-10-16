import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    static void psum() {
        TaxCalculator calc = new TaxCalculator();
        try
        {
            System.out.println(calc.calculateTax("Физ", 10000.0)); // 13%
            System.out.println(calc.calculateTax("Ип", 100000.0)); // 15%
            System.out.println(calc.calculateTax("Сам", 1.0)); // 6%
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        psum();
    }
}