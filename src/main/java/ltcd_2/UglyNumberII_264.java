package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.List;

public class UglyNumberII_264 {

    public int nthUglyNumber(int n) {

        if (n == 1) return 1;
        List<Integer> dp = new ArrayList<>(n);
        dp.add(1);

        int i = 2;
        while (dp.size() != n) {
            if (isUgly(i)) {
                dp.add(i);
            }
            System.out.println(i + " - " + (isUgly(i) ? "Ugly" : "NU"));
            i++;
        }

        // System.out.println(dp);

        return dp.get(dp.size() - 1);
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
