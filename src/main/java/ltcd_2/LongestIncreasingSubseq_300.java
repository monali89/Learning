package ltcd_2;

import common.Common;

import java.util.Arrays;

public class LongestIncreasingSubseq_300 {

    public int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            int currMax = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    currMax = Math.max(dp[i] + dp[j], currMax);
            }
            dp[i] = currMax;
            max = Math.max(currMax, max);
        }

        System.out.println(Common.arrayToString(dp));

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubseq_300 object = new LongestIncreasingSubseq_300();
        System.out.println(object.lengthOfLIS(new int[] {-1,-2,-3,-4,-5,-6}));
    }
}
