package ltcd_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 10/4/2021
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 */

public class ThreeSum_15 {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> store = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            store.add(nums[i]);
        }

        Arrays.sort(nums);

        int l = 0, r = nums.length-1;

        while (l < r) {
            int twoSum = nums[l] + nums[r];
            boolean found = false;

            for (int i = l+1; i < r; i++) {
                if (nums[i] == (-twoSum)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                List<Integer> group = new ArrayList<Integer>();
                group.add(nums[l]);
                group.add(-twoSum);
                group.add(nums[r]);
                result.add(group);
                l++;
                r--;

            } else if (twoSum < 0) {
                l++;
            } else if (twoSum > 0) {
                r--;
            } else {
                l++;
                r--;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        ThreeSum_15 object = new ThreeSum_15();
        int[] input;

        // test 1
        /*input = new int[] {-1,0,1,2,-1,-4};
        System.out.println(object.threeSum(input));

        // test 2
        input = new int[] {};
        System.out.println(object.threeSum(input));

        // test 3
        input = new int[] {0};
        System.out.println(object.threeSum(input));*/

        // test 4
        input = new int[] {0, 0, 0, 0};
        System.out.println(object.threeSum(input));
    }
}
