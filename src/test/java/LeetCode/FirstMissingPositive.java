package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 5/11/2019
 * @author: Monali
 */

public class FirstMissingPositive {

    @Test
    public void test01(){
        Assert.assertEquals(3, firstMissingPositive(new int[]{1,2,0}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(2, firstMissingPositive(new int[]{3,4,-1,1}));
    }

    @Test
    public void test03(){
        Assert.assertEquals(1, firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    @Test
    public void test04(){
        Assert.assertEquals(1, firstMissingPositive(new int[]{-23,-6,-8,-32,-90}));
    }

    @Test
    public void test05(){
        Assert.assertEquals(6, firstMissingPositive(new int[]{1,2,3,4,5}));
    }

    public static int firstMissingPositive(int[] nums) {

        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int min = 1;
        while(min <= set.size()){
            if(set.contains(min)) min++;
            else return min;
        }

        return min;
    }
}


/*
* Given an unsorted integer array, find the smallest missing positive integer.
* Algorithm should run in O(n) time and uses constant extra space.
* */