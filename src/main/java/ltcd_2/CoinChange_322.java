package ltcd_2;

import common.Common;
import hk.CoinChange;

import java.util.Arrays;

public class CoinChange_322 {

    public int coinChange(int[] coins, int amount) {

        Arrays.sort(coins);

        int total = 0;
        int rem = amount;
        int i = coins.length - 1;

        while (rem != 0 && i >= 0) {
            if (coins[i] <= rem) {
                total = total + rem / coins[i];
                rem = rem % coins[i];
            }
            i--;
        }

        if (rem != 0) return -1;

        return total;
    }

    public int coinChange_2(int[] coins, int amount) {

        if (amount == 0) return 0;

        int[] memo = new int[amount+1];
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<coins.length; i++) {
            if (coins[i] <= amount) {
                ans = Math.min(ans, helper(i, coins, amount, 0));
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int helper(int index, int[] coins, int rem, int ans) {
        if (rem == 0) return ans;

        if (index < 0 || index >= coins.length) return ans;

        else if (rem < 0) {
            return helper(index-1, coins, rem + coins[index], ans-1);
        } else {
            return helper(index, coins, rem - coins[index], ans+1);
        }
    }

    public static void main(String[] args) {
        CoinChange_322 object = new CoinChange_322();
        int[] coins;
        int amount;
        int output;
        int expected;

        coins = new int[] {1,2,5};
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
        expected = -1;
        Common.printResult(Common.arrayToString(coins) + " | " + amount, output, expected);
    }
}
