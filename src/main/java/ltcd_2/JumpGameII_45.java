package ltcd_2;

import common.Common;

import java.util.Arrays;

public class JumpGameII_45 {

    public int jump(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1001);
        return helper(nums, dp, 0);
    }

    private int helper(int[] nums, int[] dp, int pos) {

        if (pos >= nums.length - 1) return 0;
        System.out.println(pos + " | " + dp[pos]);
        if (dp[pos] != 1001) return dp[pos];

        for (int i = 1; i <= nums[pos]; i++) {
            dp[pos] = Math.min(dp[pos], 1 + helper(nums, dp, pos+i));
        }
        System.out.println(pos + " | " + dp[pos]);
        return dp[pos];
    }

    public static void main(String[] args) {

        JumpGameII_45 object = new JumpGameII_45();
        int[] input;
        int output;
        int expected;

        input = new int[]{2, 3, 1, 1, 4};
        output = object.jump(input);
        expected = 2;
        Common.printResult(Common.arrayToString(input), output, expected);

        /*input = new int[] {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        output = object.jump(input);
        expected = 2;
        Common.printResult(Common.arrayToString(input), output, expected);*/
    }
}
