package ltcd_2;

import common.Common;

public class BuySellStocks_All {

    // 714. Best Time to Buy and Sell Stock with Transaction Fee
    public int maxProfit(int[] prices, int fee) {

        if (prices.length == 0) return 0;

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            int currProfit = prices[i] + buy[i-1] - fee;
            buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);
            sell[i] = Math.max(sell[i-1], currProfit);
        }

        System.out.println("Buy: " + Common.arrayToString(buy));
        System.out.println("Sell: " + Common.arrayToString(sell));

        return sell[prices.length - 1];
    }

    // 309. Best Time to Buy and Sell Stock with Cooldown
    public int maxProfit(int[] prices) {

        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] rest = new int[prices.length];

        for (int i=0; i<prices.length; i++) {

            if (i == 0) {

                // initialize as neg val so that later to
                // calculate profit we can just use val2 + this val
                buy[i] = -prices[i];

                // at the start we cannot sell as we haven't bought anything
                sell[i] = 0;

                // TBD
                rest[i] = Integer.MIN_VALUE;

            } else {

                // if we are buying at this index,
                // at the earlier index we could have either bought or rested
                // we couldn't have sold at index n-1 as it requires a mandatory resting period
                // and as rest array is keeping track of total profit
                // at this index if we are buying, we need to select
                // previous max buy value or total profit which is rest
                // buy[i] = Math.max(buy[i-1], rest[i-1]);
                buy[i] = Math.max(buy[i-1], sell[i-1] - prices[i]);

                // if we are selling at this index,
                // we need to decide if we should keep profit
                // at this index or from an earlier index,
                // whichever is more, because we are greedy
                //sell[i] = Math.max(sell[i-1], prices[i] + buy[i-1]);
                sell[i] = Math.max(sell[i-1], rest[i-1]);

                // if we are resting at this index, the profit
                // would be whatever we sold previously
                // rest[i] = Math.max(rest[i-1], Math.max(sell[i-1], buy[i-1]));
                rest[i] = buy[i-1] + prices[i];
            }
        }

        System.out.println("Buy: " + Common.arrayToString(buy));
        System.out.println("Sell: " + Common.arrayToString(sell));
        System.out.println("Rest: " + Common.arrayToString(rest));

        return Math.max(sell[prices.length - 1], rest[prices.length - 1]);

    }

    public static void main(String[] args) {

        BuySellStocks_All object = new BuySellStocks_All();
        int[] input;
        int fee;

        input = new int[] {1,3,2,8,4,9};
        fee = 2;
        System.out.println(Common.arrayToString(input));

        //System.out.println("With cool down period of 1 day: " + object.maxProfit(input));
        System.out.println("With transaction fee: " + object.maxProfit(input, fee));

    }
}
