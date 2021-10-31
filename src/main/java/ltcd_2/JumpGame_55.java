package ltcd_2;

import common.Common;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {

        int end = 0;

        for (int i = 0; i < nums.length-1; i++) {
            end = Math.max(end, i + nums[i]);
        }

        return end >= nums.length - 1;
    }

    public static void main(String[] args) {

        JumpGame_55 object = new JumpGame_55();
        int[] input;
        boolean output;
        boolean expected;

        input = new int[] {2, 3, 1, 1, 4};
        output = object.canJump(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {3, 2, 1, 0, 4};
        output = object.canJump(input);
        expected = false;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {2, 0};
        output = object.canJump(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);
    }
}
