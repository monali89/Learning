package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {

        if (n == 1) return 1;
        int[] dp = new int[n];
        dp[0] = 1;

        int index2 = 1, index3 = 1, index5 = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min( Math.min(factor2, factor3), factor5);
            dp[i] = min;

            if (min == factor2) {
                factor2 = 2 * dp[index2++];
            }
            if (min == factor3) {
                factor3 = 3 * dp[index3++];
            }
            if (min == factor5) {
                factor5 = 5 * dp[index5++];
            }
        }

        return dp[n-1];
    }

    private boolean isUgly(int n) {

        if (n == 1) return true;

        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        UglyNumberII_264 object = new UglyNumberII_264();
        int input;
        int output;
        int expected;

        input = 10;
        output = object.nthUglyNumber(input);
        expected = 12;
        Common.printResult(input, output, expected);

        input = 20;
        output = object.nthUglyNumber(input);
        expected = 36;
        Common.printResult(input, output, expected);
    }
}
