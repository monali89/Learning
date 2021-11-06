package ltcd_2;

import common.Common;

public class Matrix_542 {

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        if (m == 0) return null;
        int n = mat[0].length;

        // top to down, check for top up and left side neighbors only
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) continue;
                int top = (i - 1 < 0) ? 10001 : mat[i-1][j];
                int left = (j - 1 < 0) ? 10001 : mat[i][j-1];
                mat[i][j] = 1 + Math.min(top, left);
            }
        }

        // down to top, check for right side and bottom neighbors only
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (mat[i][j] == 0) continue;
                int right = (j + 1 >= n) ? 10001 : mat[i][j+1];
                int bottom = (i + 1 >= m) ? 10001 : mat[i+1][j];
                mat[i][j] = Math.min(mat[i][j], Math.min(right, bottom) + 1);
            }
        }

        return mat;
    }

    public static void main(String[] args) {
        Matrix_542 object = new Matrix_542();
        int[][] input;
        int[][] output;

        /*input = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        output = object.updateMatrix(input);
        Common.print2DIntArray(output);*/

        input = new int[][] {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        Common.print2DIntArray(input);
        output = object.updateMatrix(input);
        Common.print2DIntArray(output);


    }
}
