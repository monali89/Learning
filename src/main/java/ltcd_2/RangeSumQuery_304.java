package ltcd_2;

import common.Common;

public class RangeSumQuery_304 {

    private int m;
    private int n;
    private int[][] rangeSum;
    private int[][] mat;

    public RangeSumQuery_304(int[][] matrix) {

        mat = matrix;
        m = mat.length;
        n = mat[0].length;
        rangeSum = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangeSum[i+1][j+1] = rangeSum[i][j+1] + rangeSum[i+1][j] - rangeSum[i][j] + mat[i][j];
            }
        }

        Common.print2DIntArray(rangeSum);
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        int area = rangeSum[row2+1][col2+1]
                - rangeSum[row1][col2+1] - rangeSum[row2+1][col1]
                + rangeSum[row1][col1];
        return area;
    }

    public static void main(String[] args) {
        RangeSumQuery_304 object;
        int[][] input;
        int output;
        int expected;

        input = new int[][] {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        object = new RangeSumQuery_304(input);

        output = object.sumRegion(2, 1, 4, 3);
        expected = 8;
        Common.printResult("Input 1", output, expected);

        output = object.sumRegion(1, 1, 2, 2);
        expected = 11;
        Common.printResult("Input 2", output, expected);

        output = object.sumRegion(1, 2, 2, 4);
        expected = 12;
        Common.printResult("Input 3", output, expected);

        input = new int[][] {{2, 2, 2}, {2, 2, 2}, {2, 2, 2}};
        object = new RangeSumQuery_304(input);

        output = object.sumRegion(1, 1, 2, 2);
        expected = 8;
        Common.printResult("Input 1", output, expected);

        input = new int[][] {{-1}};
        object = new RangeSumQuery_304(input);

        output = object.sumRegion(0, 0, 0, 0);
        expected = -1;
        Common.printResult("Input 1", output, expected);


    }
}
