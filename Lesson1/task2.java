package lab1;
import java.util.Scanner;

public class task2 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] nums = {4, 1, 2, 1, 2};
            int singleNumber = findSingleNumber(nums);
            System.out.println("Элемент, который не встречается дважды: " + singleNumber);
        }

        public static int findSingleNumber(int[] nums) {
            int result = 0;
            for (int num : nums) {
                result ^= num; // через XOR
            }
            return result; //остаток от XOR
        }
}
