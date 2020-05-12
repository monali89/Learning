package misc;

import java.util.Stack;

/**
 * @author Monali L on 4/20/2020
 */
public class BitManipulation {

    // NOT: 1 -> 0, 0 -> 1
    // AND: 1 and 1 -> 1, 1 and 0 || 0 and 0 -> 0
    // OR: 1 or 1 || 1 or 0 -> 1, 0 or 0 -> 0
    // XOR: 1 xor 0 || 0 xor 1 -> 1, 1 xor 1 || 0 xor 0 -> 0

    // Arithmetic shift: Bits that are shifted out of either end are discarded
    // Logical shift: TBD

    // Java specific: It performs arithmetic shift
    // Left shift (<<): MSB bit (right) is shifted to end (left)
    // Signed right shift (>>): LSB bit (left) is shifted to start (right)
    // Unsigned right shift (>>>)

    // TODO: find the maximum XOR sub-array value in given array.
    // Expected time complexity O(n).
    public int getXorSubArray(int[] a) {

        // Sort the array, within for loop use a while loop for all remaining elements
        // OR: Using trie data structure

        int rslt = Integer.MAX_VALUE;

        return rslt;
    }

    // TODO: find nth magic number
    // A magic number is defined as a number which can be
    // expressed as a power of 5 or sum of unique powers of 5.
    // First few magic numbers are 5, 25, 30(5 + 25), 125, 130(125 + 5)
    public int getNthMagicNumber() {
        return -1;
    }

    // TODO: Given an integer array of n integers, find sum of bit
    // differences in all pairs that can be formed from array elements.
    // Bit difference of a pair (x, y) is count of different bits
    // at same positions in binary representations of x and y.
    public int getBitDifferences(int[] a) {

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                int val = a[i]^a[j];
                System.out.print("DEBUG: For " + a[i] + " & " + a[j] + ", val - " + val + " ");
                int c = 0;
                while (val > 0) {
                    val = val >>> 1;
                    System.out.print(val + " ");
                    c = c + (1 & val);
                }
                System.out.println();
                System.out.println("DEBUG: c - " + c);
                count = count + c;
            }
        }
        return count;
    }

    // TODO: Swap all odd and even bits

    // Problem: Given an array where every element occurs three times,
    // except one element which occurs only once. Find the element that occurs once.
    // Expected time complexity is O(n) and O(1) extra space. COPIED
    // Check comment here: https://www.careercup.com/question?id=7902674
    public int getUniqueNumber(int[] a) {

        int unique = -1;
        int    ones = 0 ;
        int    twos = 0 ;
        int not_threes;
        for(int i=0; i< 10; i++ ) {
            twos = twos | (ones & a[i]);
            ones = ones ^ a[i];
            not_threes = ~(ones & twos) ;
            ones = ones & not_threes ;
            twos = twos & not_threes ;
            System.out.println("DEBUG: a[i]-" + a[i] + ", ones-" + ones + ", twos-" + twos + ", not threes-" + not_threes);
            System.out.println("DEBUG: ones-" + Integer.toBinaryString(ones) + ", twos-" + Integer.toBinaryString(twos));
        }
        unique = ones;

        return unique;
    }

    // Along the same lines as above
    public int getUniqueNumber2(int[] a) {
        int unique = 0;
        for (int i = 0; i < a.length; i++) {
            unique = unique ^ a[i];
        }
        return unique;
    }

    // Problem: Write a program to print Binary representation of a given number.
    public String getBinaryString(int n) {
        String binStr = "";
        int div = n;
        int rem = 0;
        Stack<Integer> stack = new Stack<Integer>();
        while(div > 0) {
            rem = div%2;
            div = div/2;
            stack.push(rem);
        }
        while(!stack.isEmpty()) binStr = binStr.concat(Integer.toString(stack.pop()));
        return binStr;
    }

    // TODO: Rotate bits left or right

    // Problem: Count number of bits to be flipped to convert A to B
    public int getFlipCount(int A, int B) {
        int val = A ^ B;
        int count = 0;
        while(val > 0) {
            count = count + (val & 1);
            val = val >> 1;
        }
        return count;
    }

    // Misc
    public static String convertIntToBinary (int n) {
        StringBuilder binStr = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        while (n != 1) {
            stack.push(n%2);
            n = n/2;
        }
        stack.push(n);
        while (!stack.isEmpty()) binStr.append(stack.pop());
        return binStr.toString();
    }

    public static String convertFloatToBinary (float n) {
        String[] s = Float.toString(n).split(".");

        // Get the int part
        StringBuilder binStr = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int b = (int) n;
        while (b != 1) {
            stack.push(b%2);
            b = b/2;
        }
        stack.push(b);
        while (!stack.isEmpty()) binStr.append(stack.pop());



        return binStr.toString();
    }

    public static int convertBinaryToInt(String binStr) {
        return -1;
    }

    public static int convertBinaryToFloat(String binStr) {
        return -1;
    }
}
