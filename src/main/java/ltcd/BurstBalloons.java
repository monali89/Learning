package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: monali on 5/8/2019
 */

public class BurstBalloons {

    @Test
    public void test01(){
        Assert.assertEquals(108813, maxCoins(new int[]{57,52,36}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(1924, maxCoins(new int[]{52,36}));
    }

    @Test
    public void test03(){
        Assert.assertEquals(986649, maxCoins(new int[]{57,52,36,8,80,79,18,21,30}));
    }

    @Test
    public void test04(){
        Assert.assertEquals(1654, maxCoins(new int[]{7,9,8,0,7,1,3,5,5,2,3}));
    }

    public static int maxCoins(int[] nums) {
        int maxVal = 0;
        for(int i=0; i<nums.length; i++){
            boolean[] deleted = new boolean[nums.length];
            maxVal = Math.max(maxVal, helper(i, deleted, nums));
        }
        return maxVal;
    }

    public static int helper(int i, boolean[] deleted, int[] nums){

        if(deleted[i] == true) return 0;

        int left = 1;
        int l = i-1;
        while(l>-1 && deleted[l]==true) l--;
        if(l>-1) left = nums[l];

        int right = 1;
        int r = i+1;
        while(r<nums.length && deleted[r]==true) r++;
        if(r<nums.length) right = nums[r];

        int val = left * nums[i] * right;
        deleted[i] = true;
        int maxVal = 0;

        for(int j=0; j<nums.length; j++){
            if(j == i) continue;
            maxVal = Math.max(maxVal, helper(j, deleted, nums));
        }
        deleted[i] = false;
        return val + maxVal;
    }

}


/*
* Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
* You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
* Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
* Find the maximum coins you can collect by bursting the balloons wisely.
*
* Input: [3,1,5,8]
* Output: 167
* Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
*             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
* */