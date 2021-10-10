package ltcd;

import common.Common;

/**
 * @author: monali on 5/9/2019
 * Problem: Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */

public class SubarraySumEqualsK {

    public static void main(String[] args) {

        SubarraySumEqualsK object = new SubarraySumEqualsK();
        int[] input;
        int expected;
        int output;
        int k;

        // test 1
        input = new int[] {1,2,1,3,0,2,1,4};
        k = 5;
        expected = 2;
        output = object.subarraySum(input, k);
        System.out.println("Input: " + Common.arrayToString(input) +
                " | Output: " + output + " | Expected: " + expected);

        // test 2
        input = new int[] {1,1,1};
        k = 2;
        expected = 2;
        output = object.subarraySum(input, k);
        System.out.println("Input: " + Common.arrayToString(input) +
                " | Output: " + output + " | Expected: " + expected);

        // test 3
        input = new int[] {1};
        k = 1;
        expected = 1;
        output = object.subarraySum(input, k);
        System.out.println("Input: " + Common.arrayToString(input) +
                " | Output: " + output + " | Expected: " + expected);

        // test 4
        input = new int[] {-1,-1,1};
        k = 1;
        expected = 1;
        output = object.subarraySum(input, k);
        System.out.println("Input: " + Common.arrayToString(input) +
                " | Output: " + output + " | Expected: " + expected);
    }

    public int subarraySum(int[] nums, int k) {

        if (nums.length < 1) return 0;
        if (nums.length == 1) {
            return nums[0] == k ? 1 : 0;
        }

        int count = 0;
        int sum = 0;
        int s=0, n=0;

        while(s < nums.length-1) {
            if(sum < k && n < nums.length) {
                sum = sum + nums[n++];
            }else if(sum == k){
                count++;
                sum = sum - nums[s++];
            }else if(sum > k){
                sum = sum - nums[s++];
            }
        }
        if(sum == k) count++;
        return count;
    }

}
