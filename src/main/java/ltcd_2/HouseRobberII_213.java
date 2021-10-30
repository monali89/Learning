package ltcd_2;

import common.Common;

/**
 * @author Monali L on 6/5/2021
 */
public class HouseRobberII_213 {

    public int rob(int[] nums) {

        int len = nums.length;

        if (len <= 0 || len == 2) return 0;
        if (len == 1) return nums[0];

        int[] dpIncludeFirst = new int[len + 1];
        int[] dpExcludeFirst = new int[len + 1];

        dpIncludeFirst[0] = nums[0];
        dpIncludeFirst[1] = nums[1];

        for (int i=2; i<len-1; i++) {
            int max = nums[i];
            for (int j=i-2; j>=0; j--) {
                max = Math.max(max, nums[i] + dpIncludeFirst[j]);
            }
            dpIncludeFirst[i] = max;
        }

        dpIncludeFirst[len] = Math.max(dpIncludeFirst[len-2], dpIncludeFirst[len-3]);

        dpExcludeFirst[0] = 0;
        dpExcludeFirst[1] = nums[1];

        for (int i=2; i<len; i++) {
            int max = nums[i];
            for (int j=i-2; j>0; j--) {
                max = Math.max(max, nums[i] + dpExcludeFirst[j]);
            }
            dpExcludeFirst[i] = max;
        }

        dpExcludeFirst[len] = Math.max(dpExcludeFirst[len-1], dpExcludeFirst[len-2]);

        System.out.println("dpIncludeFirst: " + Common.arrayToString(dpIncludeFirst));
        System.out.println("dpExcludeFirst: " + Common.arrayToString(dpExcludeFirst));

        return Math.max(dpIncludeFirst[len], dpExcludeFirst[len]);
    }

    public static void main(String[] args) {

        HouseRobberII_213 object = new HouseRobberII_213();
        int[] input;
        int output;
        int expected;

        input = new int[]{2,3,2};
        output = object.rob(input);
        expected = 3;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[]{1,2,3,1};
        output = object.rob(input);
        expected = 4;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[]{1,2,3};
        output = object.rob(input);
        expected = 3;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[]{1,3,1,3,100};
        output = object.rob(input);
        expected = 103;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {200,3,140,20,10};
        output = object.rob(input);
        expected = 340;
        Common.printResult(Common.arrayToString(input), output, expected);
    }
}
