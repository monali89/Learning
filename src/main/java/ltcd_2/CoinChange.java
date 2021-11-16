package ltcd_2;

import common.Common;

import java.util.Arrays;

public class CoinChange {

    // 518. Coin Change 2

    private int[][] dp;

    public int change(int amount, int[] coins) {

        dp = new int[coins.length][amount+1];

        return change(amount, 0, coins);
    }
    private int change(int remaining, int index, int[] coins) {

        if (remaining == 0) return 1;
        if (remaining < 0 || index == coins.length) return 0;
        if (dp[index][remaining] != 0) return dp[index][remaining];

        int sum1 = change(remaining - coins[index], index, coins);
        int sum2 = change(remaining, index + 1, coins);

        dp[index][remaining] = sum1 + sum2;

        return dp[index][remaining];
    }

    // 322. Coin Change
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);

    }

    private int[] coinChangeRecursiveDP;
    public int coinChange_Recursive(int[] coins, int amount) {
        coinChangeRecursiveDP = new int[amount + 1];
        return coinChange_Recursive_Helper(coins, amount);
    }

    public int coinChange_Recursive_Helper(int[] coins, int amount) {
        if (amount < 0) return -1;

        if (coinChangeRecursiveDP[amount] != -1)
            return coinChangeRecursiveDP[amount];

        if (amount == 0) return 0;
        int v = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int currCoins = 1 + coinChange_Recursive_Helper(coins, amount - coins[i]);
            v = Math.min(currCoins, v);
        }

        coinChangeRecursiveDP[amount] = v == Integer.MAX_VALUE ? -1 : v;

        return v;
    }

    private int helper(int[] coins, int rem, int[] count) {

        if (rem < 0) return -1;
        if (rem == 0) return 0;

        if (count[rem-1] != 0) return count[rem-1];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < coins.length; i++) {
            int res = helper(coins, rem - coins[i], count);
            if (res >= 0 && res < min) {
                min = 1 + res;
            }
        }

        count[rem-1] = min != Integer.MAX_VALUE ? min : -1;
        return count[rem-1];
    }

    public static void main(String[] args) {
        CoinChange object = new CoinChange();
        int[] coins;
        int amount;
        int output;
        int expected;

        /*coins = new int[] {1,2,5};
        amount = 11;
        output = object.coinChange(coins, amount);
        expected = 3;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);

        coins = new int[] {2,5,10,1};
        amount = 27;
        output = object.coinChange(coins, amount);
        expected = 4;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);

        coins = new int[] {2};
        amount = 3;
        output = object.coinChange(coins, amount);
        expected = -1;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);

        coins = new int[] {186,419,83,408};
        amount = 6249;
        output = object.coinChange(coins, amount);
        expected = 20;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);*/

        coins = new int[] {1,2,5};
        amount = 5;
        output = object.change(5, coins);
        expected = 4;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);

        // test coin change recursive
        // System.out.println(object.coinChange_Recursive(new int[] {1,2,5}, 7));
    }
}
