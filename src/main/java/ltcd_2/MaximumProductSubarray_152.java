package ltcd_2;

import common.Common;

public class MaximumProductSubarray_152 {

    public int maxProduct(int[] nums) {

        int maxProd = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            int currProd = 1;
            for(int j=i; j<nums.length; j++){
                currProd = currProd * nums[j];
                System.out.println(j + " | " + nums[j] + " | " + currProd);
                maxProd = Math.max(maxProd, currProd);
            }
            System.out.println("****** " + i + " | " + nums[i] + " | " + maxProd);
        }
        return maxProd;
    }

    public static void main(String[] args) {

        MaximumProductSubarray_152 object = new MaximumProductSubarray_152();
        int[] input;
        int output;
        int expected;

        /*input = new int[] {2,3,-2,4};
        output = object.maxProduct(input);
        expected = 6;
        Common.printResult(Common.arrayToString(input), output, expected);*/

        input = new int[] {-2,2,3,4};
        output = object.maxProduct(input);
        expected = 6;
        Common.printResult(Common.arrayToString(input), output, expected);

    }
}
