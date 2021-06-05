package ltcd;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    public static void backtrack(List<List<Integer>> final_list, List<Integer> this_list, int[] nums, int remaining, int start){
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
