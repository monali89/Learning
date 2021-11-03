package ltcd_2;

import common.Common;

public class BestSightseeingPair_1014 {

    public int maxScoreSightseeingPair(int[] values) {

        int n = values.length;

        int[] iPlus = new int[n];
        int[] jMinus = new int[n];

        for (int i = 0; i < n; i++) {
            iPlus[i] = values[i] + i;
        }

        for (int i = 0; i < n; i++) {
            jMinus[i] = values[i] - i;
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                max = Math.max(max,iPlus[i] + jMinus[j]);
            }
        }

        System.out.println(Common.arrayToString(iPlus));
        System.out.println(Common.arrayToString(jMinus));

        return max;
    }

    public static void main(String[] args) {
        BestSightseeingPair_1014 object = new BestSightseeingPair_1014();
        int[] input;

        input = new int[] {8,1,5,2,6};
        Common.printResult(Common.arrayToString(input), object.maxScoreSightseeingPair(input), 11);
    }
}
