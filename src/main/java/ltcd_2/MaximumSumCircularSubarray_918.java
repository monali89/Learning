package ltcd_2;

import common.Common;

public class MaximumSumCircularSubarray_918 {

    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int maxSum = nums[0];
        int minSum = nums[0];
        int currMaxSum = nums[0];
        int currMinSum = nums[0];
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            total += nums[i];

            currMaxSum = Math.max(nums[i], currMaxSum + nums[i]);
            maxSum = Math.max(maxSum, currMaxSum);

            currMinSum = Math.min(nums[i], currMinSum + nums[i]);
            minSum = Math.min(minSum, currMinSum);
        }

        return Math.max(maxSum, total - minSum);
    }

    public static void main(String[] args) {

        MaximumSumCircularSubarray_918 object = new MaximumSumCircularSubarray_918();
        int[] input;
        int output;
        int expected;

        input = new int[] {1,-2,3,-2};
        output = object.maxSubarraySumCircular(input);
        expected = 3;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {-2,-3,-1};
        output = object.maxSubarraySumCircular(input);
        expected = -1;
        Common.printResult(Common.arrayToString(input), output, expected);


    }
}
