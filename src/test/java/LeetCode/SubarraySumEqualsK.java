package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: monali on 5/9/2019
 */

public class SubarraySumEqualsK {

    @Test
    public void test01(){
        //Assert.assertEquals(2, subarraySum(new int[]{1,1,1}, 2));
        //Assert.assertEquals(2, subarraySum(new int[]{1,2,1,3,0,2,1,4}, 5));
        Assert.assertEquals(subarraySumTEST(new int[]{1,2,1,3,0,2,1,4}, 5), subarraySum(new int[]{1,2,1,3,0,2,1,4}, 5));
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

    public static int subarraySumTEST(int[] nums, int k) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            int j = i;
            while(j < nums.length && sum <= k){
                sum = sum + nums[j++];
            }
            if(sum == k) count++;
        }

        return count;
    }

}


/*
* Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
*
* Input:nums = [1,1,1], k = 2
* Output: 2
*
* */
