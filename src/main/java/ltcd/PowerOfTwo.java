package ltcd;

/**
 * @author Monali L on 4/28/2020
 */
public class PowerOfTwo {

    public static boolean isPowerOfTwo(int n) {
        System.out.println("DEBUG: n - " + Integer.toBinaryString(n));
        // Number of bits are always one
        int c = 0;
        while (n > 0) {
            c = c + (n & 1);
            n = n >> 1;
        }
        return c == 1;
    }

    public static void main(String[] args) {
        System.out.println("16 - " + isPowerOfTwo(16));
        System.out.println("32 - " + isPowerOfTwo(32));
        System.out.println("218 - " + isPowerOfTwo(218));
    }
}
