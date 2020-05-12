package hk;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 4/27/2020
 */

public class CoinChange {

    private static long total;
    private static int ways;

    public static void main(String[] args) {
        List<Long> c = new ArrayList<Long>();
        c.add((long) 1);
        c.add((long) 2);
        c.add((long) 3);
        int n = 4;
        total = 0;
        System.out.println(getWays(n, c));
    }

    private static int[] dp;

    public static long getWays(int n, List<Long> c) {

        for (Long coin: c) {
            helper((long) 0, n, coin, c);
        }

        return ways;
    }

    public static void helper(Long rem, int n, Long start, List<Long> c) {
        if (rem == n) {
            ways++;
            return;
        }
        for (Long coin: c) {
            helper((rem - start), n, coin, c);
        }
    }
}
