package ltcd;

import java.util.Arrays;

/**
 * @author Monali L on 5/3/2020
 * Problem: Given an array nums of n integers and an integer target,
 * find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers.
 * You may assume that each input would have exactly one solution.
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */

public class ThreeSumClosest {

    public static void main(String[] args) {

        int[] input = {-1,2,1,-4};
        System.out.println(findClosest(input, 1));
        System.out.println();

        input = new int[]{3,3,3,3};
        //System.out.println(findClosest(input, 2));

    }

    public static int findClosest(int[] a, int target) {

        Arrays.sort(a);
        int s = 0, e = a.length-1;
        int total = Integer.MAX_VALUE; // tbd - initial value

        while(s < e) {
            int curr_total = Integer.MAX_VALUE;
            for (int i = s+1; i < e; i++) {
                curr_total = a[s] + a[i] + a[e];
                System.out.println("DEBUG (before): s-" + s + " | e-" + e + " | i-" + i + " | total-" + total + " | curr_total-" + curr_total);
                if ( Math.abs(target-total) < Math.abs(target-curr_total) )
                    curr_total = total;
            }
            if (curr_total > target) e--;
            else s++;
            System.out.println("DEBUG (after): s-" + s + " | e-" + e + " | total-" + total + " | curr_total-" + curr_total);
        }
        return total;
    }

    public static int findClosest_bk(int[] a, int target) {

        Arrays.sort(a);
        int s = 0, e = a.length-1;
        int total = Integer.MAX_VALUE; // tbd - initial value

        while(s < e) {
            int curr_total = Integer.MAX_VALUE;
            for (int i = s+1; i < e; i++) {
                int temp_total = a[s] + a[i] + a[e];
                System.out.println("DEBUG (before): s-" + s + " | e-" + e + " | i-" + i + " | total-" + total + " | curr_total-" + curr_total + " | temp_total-" + temp_total);
                if ( Math.abs(target-temp_total) < Math.abs(target-curr_total) )
                    curr_total = temp_total;
            }
            if (curr_total > target) e--;
            else s++;
            //if (target == total) continue;
            if ((target-curr_total) < (target-total)) {
                total = curr_total;
            }
            //total = Math.min(total, curr_total);
            System.out.println("DEBUG (after): s-" + s + " | e-" + e + " | total-" + total + " | curr_total-" + curr_total);
        }
        return total;
    }


}
