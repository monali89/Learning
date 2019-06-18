package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsOfSet {

    public static void main(String[] args) {
        System.out.println(permutations(new int[]{2,3,6}));
    }

    public static List<List<Integer>> permutations(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<Integer>(tempList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}

/*
 * Print all permutations of a set with distinct elements
 * */

