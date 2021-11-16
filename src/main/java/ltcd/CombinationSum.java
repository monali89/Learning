package ltcd;

import common.Common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {

        CombinationSum object = new CombinationSum();

        // System.out.println(object.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(object.combinationSum4(new int[] {1,2,3}, 4));

    }

    // 377. Combination Sum IV: Given an array of distinct
    // integers nums and a target integer target, return the
    // number of possible combinations that add up to target.

    private int noOfComb;
    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        noOfComb = 0;
        dp = new int[target+1];
        Arrays.fill(dp, -1);
        combinationSum4_helper(nums, target);
        System.out.println(Common.arrayToString(dp));
        return noOfComb;
    }

    private void combinationSum4_helper(int[] nums, int rem) {

        if (rem == 0) noOfComb++;
        if (rem < 0) return;
        if (dp[rem] != 1) return;

        for (int i = 0; i < nums.length; i++) {
            combinationSum4_helper(nums, rem - nums[i]);
        }

        System.out.println("rem:" + rem + ", combos: " + noOfComb);
        dp[rem] = noOfComb;
    }


    /*
     * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
     * find all unique combinations in candidates where the candidate numbers sums to target.
     * The same repeated number may be chosen from candidates unlimited number of times.
     *
     * All numbers (including target) will be positive integers.
     * The solution set must not contain duplicate combinations.
     *
     * Input: candidates = [2,3,6,7], target = 7,
     * A solution set is:
     * [
     *   [7],
     *   [2,2,3]
     * ]
     *
     * */

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> final_list, List<Integer> this_list, int[] nums, int remaining, int start){
        if(remaining == 0){
            final_list.add(new ArrayList<Integer>(this_list));
        }else if(remaining < 0){
            return;
        }else{
            for(int i = start; i < nums.length; i++){
                this_list.add(nums[i]);
                backtrack(final_list, this_list, nums, remaining - nums[i], i);
                this_list.remove(this_list.size() - 1);
            }
        }
    }

}
