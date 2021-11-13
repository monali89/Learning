package ltcd_2;

import common.Common;

public class UniqueBST_96 {

    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    private int helper(int s, int e) {

        if (s > e) return 0;
        if (s == e) return 1;
        int total = 0;

        for (int i = s; i <= e; i++) {
            int leftTrees = helper(s, i-1);
            int rightTrees = helper(i+1, e);
            int thisTotal = leftTrees + rightTrees;
            total = total + thisTotal;
            System.out.println(i + " | " + leftTrees + " | " + rightTrees + " | " + thisTotal);
        }
        return total;
    }

    private int helper(int s, int e, int idx) {

        if (idx < s || idx > e) return 0;
        if (s == e) return 1;
        int total = 1;

        for (int i = s; i <= e; i++) {
            //if (i == idx) continue;
            int leftSide = helper(s, i-1, i);
            int rightSide = helper(i+1, e, i);
            total = total + leftSide + rightSide + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        UniqueBST_96 object = new UniqueBST_96();
        int input;
        int output;
        int expected;

        for (int i = 1; i <= 7; i++) {
            System.out.println(i + " | " + object.numTrees(i));
        }
    }
}

/*
* Catalan numbers:
* Cn = 1 / (n+1) (2n n)
*    = (2n)! / (n+1)! * n!
* */
