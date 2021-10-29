package ltcd_2;

import common.Common;

import java.util.*;

public class DeleteAndEarn_740 {

    public int deleteAndEarn(int[] nums) {

        int n = nums.length;

        if (n <= 1) return (n == 0) ? 0 : nums[0];

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if (map.size() == 1) return nums[0];

        int[] memo = new int[10004];
        int start = nums[0];
        int end = nums[n-1];

        for (int i = start; i <= end; i++) {

            if (i == 1) {
                memo[i] = i * map.getOrDefault(i, 0);
                continue;
            }

            int curr = i * map.getOrDefault(i, 0);
            memo[i] = Math.max(curr + memo[i-2], memo[i-1]);
        }

        return memo[end];
    }

    public static void main(String[] args) {

        DeleteAndEarn_740 object = new DeleteAndEarn_740();
        int[] input;
        int output;
        int expected;

        input = new int[] {3, 4, 2};
        output = object.deleteAndEarn(input);
        expected = 6;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {2,2,3,3,3,4};
        output = object.deleteAndEarn(input);
        expected = 9;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {3,1};
        output = object.deleteAndEarn(input);
        expected = 4;
        Common.printResult(Common.arrayToString(input), output, expected);
    }
}
