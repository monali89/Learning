package ltcd_2;

/**
 * @author Monali L on 10/6/2021
 */

public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int ctr = 1;
        int i = 0, j = 0;
        int l = 0, r = n-1, t = 0, b = n-1;

        while (ctr <= n*n) {

            // left to right
            while (j < r) {
                result[i][j] = ctr++;
                j++;
            }
            j = r;
            r--;

            // top to bottom
            while (i < b) {
                result[i][j] = ctr++;
                i++;
            }
            i = b;
            b--;

            // right to left
            while (j >= 0) {
                j--;
                result[i][j] = ctr++;
            }


            if (j < r) {
                j++;
            }

            // top to bottom
            if (j == r) {

            }

            // top-right
            if (j < r) {
                j++;
            } else {
                i++;
            }

            // bottom-right

            // bottom-left

            // top-left

        }

        return result;

    }

    public static void main(String[] args) {
        SpiralMatrixII_59 object = new SpiralMatrixII_59();
        int input;

        // test 1
        input = 3;
    }

    private void print2DArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
