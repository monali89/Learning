package ltcd;

/**
 * @author Monali L on 4/28/2020
 */

public class PowerOfFour {

    public static boolean isPowerOfFour(int num) {
        System.out.println("DEBUG: n - " + Integer.toBinaryString(num));

        int c = 0;
        while (num > 0) {
            c = c + (num & 1);
            num = num >> 2;
        }
        return c == 1;
    }

    public static void main(String[] args) {
        System.out.println("16 - " + isPowerOfFour(16));
        System.out.println("5 - " + isPowerOfFour(5));
        System.out.println("1 - " + isPowerOfFour(1));
        System.out.println("2 - " + isPowerOfFour(2));
        System.out.println("8 - " + isPowerOfFour(8));
    }

}
