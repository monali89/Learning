package ltcd;

/**
 * @author Monali L on 5/3/2020
 * Problem: Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 */

public class ProductArrayExceptSelf {

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        productExceptSelf(input);
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        // left
        int left_total = 1;
        left[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            left[i] = left[i-1] * nums[i];
        }

        System.out.println("LEFT");
        for (int i=0; i<nums.length; i++) {
            System.out.print(left[i] + " ");
        }
        System.out.println();

        // right
        int right_total = 1;
        right[nums.length-1] = nums[nums.length-1];
        for (int i=nums.length-2; i>=0; i--) {
            right[i] = right[i+1] * nums[i];
        }

        System.out.println("RIGHT");
        for (int i=0; i<nums.length; i++) {
            System.out.print(right[i] + " ");
        }
        System.out.println();

        int[] rslt = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int l = (i-1 >= 0) ? left[i - 1] : 1;
            int r = (i+1 < nums.length) ? right[i+1] : 1;
            rslt[i] = l * r;
        }

        System.out.println("RESULT");
        for (int i=0; i<nums.length; i++) {
            System.out.print(rslt[i] + " ");
        }
        System.out.println();

        return null;
    }

}
