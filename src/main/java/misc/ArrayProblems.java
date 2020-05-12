package misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Monali L on 4/19/2020
 */

public class ArrayProblems {

    // Reverse an array of chars without affecting special characters
    // Example: 't','h','i','s',',',
    public char[] reverseArray(char[] a) {
        int s = 0, e = a.length-1;
        while (s <= e) {
            if (!Character.isLetterOrDigit(a[s])) {
                s++;
                continue;
            }
            if (!Character.isLetterOrDigit(a[e])) {
                e--;
                continue;
            }
            char temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
        return a;
    }

    // Count triplets with value less/more/equal than given value
    // array has distinct integer values, this is for less
    public int getTripletCount(int[] a, int val) {

        int triplets = 0;
        Arrays.sort(a);

        for (int i = 0; i < a.length-1; i++) {
            int s = i+1, e = a.length-1;
            while (s < e) {
                int sum = a[i] + a[s] + a[e];
                System.out.println("DEBUG: " + i + " | " + s + " | " + e);
                System.out.println("DEBUG: " + a[i] + " | " + a[s] + " | " + a[e] + " | " + sum);
                if (sum < val) {
                    triplets++;
                    s++;
                } else e--;
            }
        }
        return triplets;
    }

    // TODO: Convert array into Zig-Zag fashion

    // TODO: Length of the largest subarray with contiguous elements

    // TODO: Smallest sub array with sum greater than a given value

}
