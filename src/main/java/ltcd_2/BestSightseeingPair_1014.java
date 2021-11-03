package ltcd_2;

import common.Common;

public class BestSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;

        int firstMax = 0;
        int total = 0;

        for (int k = 0; k < n; k++) {

            int iPlus = values[k] + k;
            int jMinus = values[k] - k;

            if (k == 0) {
                firstMax = values[k];
            } else if (k == n-1) {
                total = Math.max(total, firstMax + jMinus);
            } else {
                total = Math.max(total, firstMax + jMinus);
                firstMax = Math.max(firstMax, iPlus);
            }
        }

        return total;
    }

    public static void main(String[] args) {
        BestSightseeingPair_1014 object = new BestSightseeingPair_1014();
        int[] input;

        input = new int[] {8,1,5,2,6};
        Common.printResult(Common.arrayToString(input), object.maxScoreSightseeingPair(input), 11);
    }
}
