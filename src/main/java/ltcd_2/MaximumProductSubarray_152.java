package ltcd_2;

import common.Common;

public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {

        int finalMaxProd = Integer.MIN_VALUE;

        int maxProd = nums[0];
        int minProd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currMax = maxProd * nums[i];
            int currMin = minProd * nums[i];

            maxProd = Math.max( Math.max(currMax, currMin), nums[i]);
            minProd = Math.min( Math.min(currMax, currMin), nums[i]);

            finalMaxProd = Math.max(finalMaxProd, maxProd);
        }

        return finalMaxProd;
    }

    public static void main(String[] args) {

        MaximumProductSubarray_152 object = new MaximumProductSubarray_152();
        int[] input;
        int output;
        int expected;

        input = new int[] {2,3,-2,4};
        output = object.maxProduct(input);
        expected = 6;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {-2,2,3,4};
        output = object.maxProduct(input);
        expected = 24;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {-2,3,-4};
        output = object.maxProduct(input);
        expected = 24;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {1,-2,-3,4};
        output = object.maxProduct(input);
        expected = 24;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {-1,-2,-9,-6};
        output = object.maxProduct(input);
        expected = 108;
        Common.printResult(Common.arrayToString(input), output, expected);

    }
}
