package ltcd_2;

import java.util.Arrays;

/**
 * @author Monali L on 6/5/2021
 */
public class MinimumFallingPathSumII_1289 {

    private int n;
    private int[][] memo;
    private boolean[][] isVisited;

    public int minFallingPathSum(int[][] matrix) {

        n = matrix.length;
        memo = new int[n][n];
        int minPath = Integer.MAX_VALUE;
        isVisited = new boolean[n][n];

        /*for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }*/

        for (int i = 0; i < n; i++) {
            minPath = Math.min(minPath, dfs(0, i, matrix));
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4s ", memo[i][j] == Integer.MAX_VALUE ? -1 : memo[i][j]);
            }
            System.out.println();
        }

        return minPath;
    }

    public int dfs(int i, int j, int[][] matrix) {

        if (i < 0 || j < 0 || i >=n || j>= n) return Integer.MAX_VALUE;

        if (memo[i][j] != 0) return memo[i][j];

        isVisited[i][j] = true;

        if (i + 1 == n) {
            memo[i][j] = matrix[i][j];
        } else {
            int minVal = Integer.MAX_VALUE;
            for (int k = -1; k <= 1; k++) {
                if (k == 0) continue; // skip the cell below current cell
                if (j+k < 0 || j+k >= n) continue; // if the column is out of range
                if (isVisited[i+1][j+k]) continue; // if the neighbor is already visited
                minVal = Math.min(minVal, matrix[i][j] + dfs(i+1, j+k, matrix));
                isVisited[i+1][j+k] = false;
            }
            memo[i][j] = minVal;
        }
        return memo[i][j];
    }

    public int[] helper(int rowNum, int[][] matrix) {
        if (rowNum == n-1) return matrix[n-1];

        int[] curr = matrix[rowNum];
        int[] prev = helper(rowNum+1, matrix);
        int[] result = new int[n];

        System.out.println("RowNum: " + rowNum);

        for (int i=0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            int temp = -1;
            for (int j = -1; j <= 1; j++) {
                if (j == 0 || i+j < 0 || i+j >= n) continue;
                // result[i] = Math.min(result[i], curr[i] + prev[i+j]);
                if (curr[i] + prev[i+j] < result[i]) {
                    result[i] = curr[i] + prev[i+j];
                    temp = i+j;
                }
            }
            System.out.println(result[i] + " | " + temp);
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        MinimumFallingPathSumII_1289 object = new MinimumFallingPathSumII_1289();
        int[][] matrix = {
                {-73,61,43,-48,-36},
                {3,30,27,57,10},
                {96,-76,84,59,-15},
                {5,-49,76,31,-7},
                {97,91,61,-46,67}};
        System.out.println(object.minFallingPathSum(matrix)); // -192
    }
}
