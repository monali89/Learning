package ltcd_2;

import common.Common;

public class UniqueBST_96 {

    public int numTrees(int n) {

        int total = 0;

        for (int i = 1; i <= n; i++) {
            total = total + helper(1, n, i);
            System.out.println(i + " : " + total);
        }

        return total;
    }

    private int helper(int s, int e, int idx) {

        if (idx < s || idx > e) return 0;
        if (s == e) return 1;
        //if (e - s == 1) return 2;
        int total = 0;

        for (int i = s; i <= e; i++) {
            if (i == idx) continue;
            int leftSide = helper(s, i-1, i);
            int rightSide = helper(i+1, e, i);
            total = total + leftSide + rightSide + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        UniqueBST_96 object = new UniqueBST_96();
        int input;
        int output;
        int expected;

        input = 3;
        output = object.numTrees(input);
        expected = 5;
        Common.printResult(input, output, expected);
    }
}
