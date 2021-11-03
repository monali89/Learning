package ltcd_2;

import common.Common;

public class BestSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;
        int firstMax = 0;
        int secMax = 0;
        int total = 0;

        for (int i = 0; i < n; i++) {

            if (i == 0) {
                firstMax = values[i];
                total = values[i] + i;
            } else if (i == n-1) {
                int jMinus = values[i] - i;
                if (jMinus > secMax) {
                    secMax = jMinus;
                }
                total = firstMax + secMax;
            } else {
                int iPlus = values[i] + i;
                int jMinus = values[i] - i;

                if (iPlus > firstMax) {
                    firstMax = iPlus;
                }
                if (jMinus > secMax) {
                    secMax = jMinus;
                }
                total = iPlus + secMax;
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
