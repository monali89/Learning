package ltcd;

/**
 * @author: monali on 5/9/2019
 * Problem: Given an array of integers and an integer k,
 * you need to find the total number of continuous subarrays whose sum equals to k.
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 */

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        int[] input = {1,2,1,3,0,2,1,4};
        System.out.println(subarraySum(input, 5));
        System.out.println();
        input = new int[]{1,1,1};
        System.out.println(subarraySum(input, 2));
    }

    public static int subarraySum(int[] nums, int k) {

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
