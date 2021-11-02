package ltcd_2;

import common.Common;

public class MaxSubarrayLength_1567 {

    public int getMaxLen(int[] nums) {

        int posLength = 0;
        int negLength = 0;
        int maxLength = 0;

        for (int n: nums) {

            if (n > 0) {
                posLength++;
                negLength = negLength == 0 ? 0 : negLength + 1;
            } else if (n < 0) {
                int temp = posLength;
                posLength = negLength == 0 ? 0 : negLength + 1;
                negLength = temp + 1;
            } else {
                posLength = 0;
                negLength = 0;
            }
            maxLength = Math.max(maxLength, posLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {

        MaxSubarrayLength_1567 object = new MaxSubarrayLength_1567();
        int[] input;
        int output;
        int expected;

        input = new int[] {1,-2,-3,4};
        output = object.getMaxLen(input);
        expected = 4;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {0,1,-2,-3,-4};
        output = object.getMaxLen(input);
        expected = 3;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {-1,-2,-3,0,1};
        output = object.getMaxLen(input);
        expected = 2;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {1,2,3,5,-6,4,0,10};
        output = object.getMaxLen(input);
        expected = 4;
        Common.printResult(Common.arrayToString(input), output, expected);
    }
}
