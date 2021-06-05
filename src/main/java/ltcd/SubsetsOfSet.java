package ltcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsOfSet {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{2,3,6}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<Integer>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}


/*
* Print all subsets of a set with distinct elements
* */
