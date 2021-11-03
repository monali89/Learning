package ltcd_2;

import common.Common;

public class Matrix_542 {

    private int m;
    private int n;
    private int[][] dp;
    private boolean[][] isVisited;

    public int[][] updateMatrix(int[][] mat) {

        m = mat.length;
        if (m == 0) return null;
        n = mat[0].length;
        dp = new int[m][n];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0)
                    isVisited[i][j] = true;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0 && !isVisited[i][j])
                    helper(mat, i, j);
            }
        }
        return dp;
    }

    private int helper(int[][] mat, int r, int c) {

        //System.out.println(r + ", " + c);
        if (isVisited[r][c]) return dp[r][c];

        // left, right, top, bottom
        int[] allr = new int[] {0,0,1,-1};
        int[] allc = new int[] {-1,1,0,0};

        int minDist = 1;

        for (int i = 0; i < 4; i++) {
            int neighr = r + allr[i];
            int neighc = c + allc[i];
            if (neighr >= 0 && neighr < m && neighc >= 0 && neighc < n) {
                if (mat[neighr][neighc] == 0) break;
                minDist = Math.min(minDist, 1 + helper(mat, neighr, neighc));
            }
        }

        dp[r][c] = minDist;
        isVisited[r][c] = true;
        return dp[r][c];
    }

    public static void main(String[] args) {
        Matrix_542 object = new Matrix_542();
        int[][] input;
        int[][] output;

        input = new int[][] {{0,0,0},{0,1,0},{1,1,1}};
        output = object.updateMatrix(input);
        Common.print2DIntArray(output);
    }
}
