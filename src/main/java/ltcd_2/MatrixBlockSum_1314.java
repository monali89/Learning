package ltcd_2;

import common.Common;

public class MatrixBlockSum_1314 {

    public int[][] matrixBlockSum(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        int[][] answer = new int[m][n];
        int[][] rangeSum = new int[m+1][n+1];

        // calculate range sum first
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rangeSum[i+1][j+1] = rangeSum[i][j+1] + rangeSum[i+1][j] - rangeSum[i][j] + mat[i][j];
            }
        }

        // calculate sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // getting sum of area from (r1, c1) to (r2, c2)
                // area = A(r2, c2) - ( A(r1, c2) + A(r2, c1) + A(r1, c1) )
                // all start at (0,0)
                int r1 = Math.max(i - k, 0);
                int r2 = Math.min(i + k + 1, m);
                int c1 = Math.max(j - k, 0);
                int c2 = Math.min(j + k + 1, n);
                answer[i][j] = rangeSum[r2][c2] - rangeSum[r1][c2] - rangeSum[r2][c1] + rangeSum[r1][c1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        MatrixBlockSum_1314 object = new MatrixBlockSum_1314();
        int[][] input;
        int[][] output;
        int k;

        input = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        k = 1;
        output = object.matrixBlockSum(input, k);
        Common.print2DIntArray(output);

        input = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        k = 2;
        output = object.matrixBlockSum(input, k);
        Common.print2DIntArray(output);
    }
}


/*
* Related to this
* Prefix sum: In computer science, the prefix sum, cumulative sum,
* inclusive scan, or simply scan of a sequence of numbers x0, x1, x2, ...
* is a second sequence of numbers y0, y1, y2, ...,
* the sums of prefixes (running totals) of the input sequence:
* y0 = x0
* y1 = x0 + x1
* y2 = x0 + x1+ x2
*
* Check this:
* https://computersciencesource.wordpress.com/2010/09/03/computer-vision-the-integral-image/
*
* Think of this as a big rectangle, starting from (0,0) to (m,n)
* We are trying to get area of a sub-rectangle starting
* from (r1,c1) to (r2,c2) which is inside this big rect.
* So we get the area from (0,0) to (r2,c2) and subtract the
* three sub-rectangles from it, the 3 sub-rectangles will be
*   from (0,0) to (r1, c1)
*   from (0,0) to (r1, c2)
*   from (0,0) to (r2, c1)
*
* */