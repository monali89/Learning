package ltcd_2;

import common.Common;

public class CoinChange {

    // 518. Coin Change 2
    public int change(int amount, int[] coins) {

    }

    // 322. Coin Change
    public int coinChange(int[] coins, int amount) {
        if (amount < 1) return 0;
        return helper(coins, amount, new int[amount]);

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

        coins = new int[] {1,2,5};
        amount = 11;
        output = object.coinChange(coins, amount);
        expected = 3;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);

        /*coins = new int[] {2,5,10,1};
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
    }
}
