package ltcd_2;

import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes_354 {

    public int maxEnvelopes(final int[][] envelopes) {

        if (envelopes.length <= 0) return 0;

        int maxEnvelopes = 1;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < envelopes.length; i++) {
            System.out.println(envelopes[i][0] + ", " + envelopes[i][1]);
        }

        int maxIdx = 0;
        int currIdx = 1;

        while (currIdx < envelopes.length) {
            if (envelopes[currIdx][0] > envelopes[maxIdx][0]
                    && envelopes[currIdx][1] > envelopes[maxIdx][1]) {
                maxEnvelopes++;
                maxIdx = currIdx;
            }
            currIdx++;
        }

        return maxEnvelopes;
    }

    public static void main(String[] args) {

        RussianDollEnvelopes_354 object = new RussianDollEnvelopes_354();
        int[][] input;
        int output;
        int expected;

        // example 1
        input = new int[][] {{5,4},{6,4},{6,7},{2,3}};
        output = object.maxEnvelopes(input);
        expected = 3;
        System.out.printf("Output: %s | Expected: %s | Result: %s\n\n", output, expected, (output == expected));

        // example 2
        input = new int[][] {{1,1},{1,1},{1,1}};
        output = object.maxEnvelopes(input);
        expected = 1;
        System.out.printf("Output: %s | Expected: %s | Result: %s\n\n", output, expected, (output == expected));

        // ML example 1
        input = new int[][] {{1,1}};
        output = object.maxEnvelopes(input);
        expected = 1;
        System.out.printf("Output: %s | Expected: %s | Result: %s\n\n", output, expected, (output == expected));

        // ML example 2
        input = new int[][] {{2, 10}, {8, 12}};
        output = object.maxEnvelopes(input);
        expected = 2;
        System.out.printf("Output: %s | Expected: %s | Result: %s\n\n", output, expected, (output == expected));

        // after submit example 1
        input = new int[][] {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
        output = object.maxEnvelopes(input);
        expected = 5;
        System.out.printf("Output: %s | Expected: %s | Result: %s\n\n", output, expected, (output == expected));
    }
}
