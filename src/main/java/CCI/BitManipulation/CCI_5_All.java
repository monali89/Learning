package CCI.BitManipulation;

/**
 * @author Monali L on 4/26/2020
 */

public class CCI_5_All {

    public static void main(String[] args) {

        //mergeNM();
        printBinary();
        //check();
        //convertionCount();
        //swapOddEven();
    }

    /*
    * 5.1
    * You are given two 32-bit numbers, N and M, and two bit positions, i and j
    * Write a method to set all bits between i and j in N equal to M
    * (e g , M becomes a substring of N located at i and starting at j)
    * EXAMPLE: Input: N = 10000000000, M = 10101, i = 2, j = 6 Output: N = 10001010100
    *
    *  0000 0100 0000 0000
    *  0000 0000 0001 0101
    * */
    public static void mergeNM() {
        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10101", 2);
        int i = 2, j = 6;
        for (int k = 0; k < i; k++) {
            m = m << 1;
        }
        int rslt = n | m;
        System.out.println(Integer.toBinaryString(rslt));
        System.out.println();
    }


    /*
    * TODO: 5.2
    * Given a (decimal - e g  3.72) number that is passed in as a string, print the binary representation
    * If the number can not be represented accurately in binary, print “ERROR”
    * */
    public static void printBinary() {
        System.out.println("5.2: Convert float to binary");
        String s = "3.72";
        StringBuilder binStr = new StringBuilder();
        String[] a = s.split("\\.");
        int bf = Integer.parseInt(a[0]);
        double af = Double.parseDouble("0." + a[1]);
        while (bf != 0) {
            binStr.append(bf%2);
            bf = bf/2;
        }
        binStr.reverse();
        binStr.append(".");
        while (af != 1.0) {
            double t = af * 2;
            binStr.append((int) t);
            af = t < 1 ? t : t - (int) t;
            System.out.println("DEBUG: t - " + t + ", af - " + af);
            if (af == Double.parseDouble(a[1])) break;
            break;
        }
        System.out.println("Binary string converted - " + binStr);
        System.out.println();
    }


    /*
    * TODO: 5.3
    * Given an integer, print the next smallest and next largest number that
    * have the same number of 1 bits in their binary representation
    * */
    public static void printBitNeighbors() {}

    /*
    * TODO: 5.4
    * Explain what the following code does: ((n & (n-1)) == 0)
    * */
    public static void check() {
        System.out.println("5.4: Checking ((n & (n-1)) == 0)");
        int n = 3;
        int nMinus1 = n-1;
        int nAndNMinus1 = 3 & nMinus1;
        System.out.println("n - " + Integer.toBinaryString(n));
        System.out.println("n minus 1 - " + Integer.toBinaryString(nMinus1));
        System.out.println("n and n minus 1 - " + Integer.toBinaryString(nAndNMinus1));
        System.out.println();
    }

    /*
     * 5.5
     * Write a function to determine the number of bits required to convert integer A to integer B
     * Input: 31, 14, Output: 2
     * */
    public static void convertionCount() {
        System.out.println("5.5: Checking conversion of A to B");
        int A = 31;
        int B = 14;
        int R = A ^ B;
        System.out.println("A - " + Integer.toBinaryString(A));
        System.out.println("B - " + Integer.toBinaryString(B));
        System.out.println("R - " + Integer.toBinaryString(R));
        int c = 0;
        while (R > 0) {
            c = c + (R & 1);
            R = R >> 1;
        }
        System.out.println("Bit count - " + c);
        System.out.println();
    }

    /*
     * 5.6
     * Write a program to swap odd and even bits in an integer with as few instructions as possible
     * (e g , bit 0 and bit 1 are swapped, bit 2 and bit 3 are swapped, etc)
     * */
    public static void swapOddEven() {
        System.out.println("5.6: Swap odd even bits");
        int n = Integer.valueOf("01010101", 2);
        System.out.println("n before - " + Integer.toBinaryString(n));
        // Move all odd places to even by left shifting
        int odd = n << 1;
        int even = n >> 1;
        int r = odd | even;
        n = r;
        System.out.println("n after - " + Integer.toBinaryString(n));
        System.out.println();
    }

    /*
     * TODO: 5.7
     * An array A[1   n] contains all the integers from 0 to n except for one number which is missing
     * In this problem, we cannot access an entire integer in A with a single operation
     * The elements of A are represented in binary, and the only operation we can use to access them is
     * “fetch the jth bit of A[i]”, which takes constant time
     * Write code to find the missing integer
     * Can you do it in O(n) time?
     * */



}
