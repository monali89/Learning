package ltcd_2;

/**
 * @author Monali L on 10/7/2021
 */

public class Search2DMatrixII_240 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int l = 0, r = n-1;
        int t = 0, b = m-1;

        while (l <= r && t <= b) {

            int mRow = (t + b) / 2;
            int mCol = (l + r) / 2;

            if (target == matrix[mRow][mCol]) return true;
            else if (target < matrix[mRow][mCol]) {
                r = mCol - 1;
                b = mRow - 1;
            } else {
                l = mCol + 1;
                t = mRow + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Search2DMatrixII_240 object = new Search2DMatrixII_240();
        int[][] input;
        int target;

        // test 1
        /*input = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        target = 5;
        System.out.println(object.searchMatrix(input, target) + " | Expected: true");

        // test 2
        input = new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        target = 20;
        System.out.println(object.searchMatrix(input, target) + " | Expected: false");

        // test 3
        input = new int[][] {{-1, 3}};
        target = -1;
        System.out.println(object.searchMatrix(input, target) + " | Expected: true");*/

        // test 4
        input = new int[][] {{-1, 3}};
        target = 3;
        System.out.println(object.searchMatrix(input, target) + " | Expected: true");
    }
}
