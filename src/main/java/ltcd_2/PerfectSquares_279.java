package ltcd_2;

import java.util.Arrays;

public class PerfectSquares_279 {

    public int numSquares(int n) {

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares_279 object = new PerfectSquares_279();
        System.out.println(object.numSquares(12));
    }
}

/*
* f(n) = Min { f(n - i*i) + 1 }
* where i*i <= n and i >= 1
*
* */
