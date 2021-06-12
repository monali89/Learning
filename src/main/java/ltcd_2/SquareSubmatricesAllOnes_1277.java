package ltcd_2;

/**
 * @author Monali L on 6/12/2021
 */

public class SquareSubmatricesAllOnes_1277 {

    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) continue;

                if(i == 0 || j == 0) {
                    count = count + 1;
                } else {
                    int[] r = {0, -1, -1};
                    int[] c = {-1, -1, 0};
                    int min = Integer.MAX_VALUE;

                    for (int k = 0; k < r.length; k++) {
                        if (j + c[k] >= n) continue;
                        min = Math.min(min, dp[i + r[k]][j + c[k]]);
                    }

                    dp[i][j] = dp[i][j] + min;
                    count = count + dp[i][j];
                }
            }
        }

        /*for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();*/

        return count;
    }

    public static void main(String[] args) {
        SquareSubmatricesAllOnes_1277 object = new SquareSubmatricesAllOnes_1277();
        int[][] input;

        input = new int[][]{
                {0,1,1,1},
                {1,1,1,1},
                {0,1,1,1}
            };
        System.out.println(object.countSquares(input));

        input = new int[][]{
                {1,0,1},{1,1,0},{1,1,0}
        };
        System.out.println(object.countSquares(input));
    }

}
