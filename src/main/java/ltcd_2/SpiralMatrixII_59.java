package ltcd_2;

/**
 * @author Monali L on 10/6/2021
 */

public class SpiralMatrixII_59 {

    public int[][] generateMatrix(int n) {

        int[][] result = new int[n][n];

        int top = 0, bottom = n-1;
        int left = 0, right = n-1;
        int ctr = 1;

        while (top <= bottom && left <= right & ctr <= n*n) {

            // left to right
            for (int i = left; i <= right; i++) {
                result[top][i] = ctr++;
            }
            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++) {
                result[i][right] = ctr++;
            }
            right--;

            // right to left
            for (int i = right; i >= left ; i--) {
                result[bottom][i] = ctr++;
            }
            bottom--;

            // bottom to top
            for (int i = bottom; i >= top; i--) {
                result[i][left] = ctr++;
            }
            left++;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixII_59 object = new SpiralMatrixII_59();
        int input;
        int[][] output;

        // test 1
        input = 3;
        output = object.generateMatrix(input);
        object.print2DArray(output);

        // test 2
        input = 1;
        output = object.generateMatrix(input);
        object.print2DArray(output);

        // test 2
        input = 2;
        output = object.generateMatrix(input);
        object.print2DArray(output);

        // test 3
        input = 5;
        output = object.generateMatrix(input);
        object.print2DArray(output);
    }

    private void print2DArray(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
