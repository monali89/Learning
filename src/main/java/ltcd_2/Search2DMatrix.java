package ltcd_2;

/**
 * @author Monali L on 9/25/2021
 */

public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int topRow = 0;
        int bottomRow = m-1;
        int searchRow = -1;

        while (topRow <= bottomRow) {
            int midRow = (topRow + bottomRow) / 2;
            if (target >= matrix[midRow][0] && target <= matrix[midRow][n-1]) {
                searchRow = midRow;
                break;
            } else {
                if (target < matrix[midRow][0]) {
                    bottomRow = midRow - 1;
                } else if (target > matrix[midRow][n-1]) {
                    topRow = midRow + 1;
                }
            }
        }

        if (searchRow == -1) {
            return false;
        } else {
            int l = 0;
            int r = n-1;
            while (l <= r) {
                int mid = (l + r)/2;
                if (target > matrix[searchRow][mid]) {
                    l = mid+1;
                } else if (target < matrix[searchRow][mid]) {
                    r = mid-1;
                } else if (target == matrix[searchRow][mid]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix obj = new Search2DMatrix();
        int[][] inputMatrix;
        int inputTarget;

        /*// test 1
        inputMatrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        inputTarget = 3;
        System.out.println("Expected: true | Output: " + obj.searchMatrix(inputMatrix, inputTarget));

        // test 2
        inputMatrix = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        inputTarget = 13;
        System.out.println("Expected: false | Output: " + obj.searchMatrix(inputMatrix, inputTarget));*/

        // test 3
        inputMatrix = new int[][] {{1},{3}};
        inputTarget = 2;
        System.out.println("Expected: false | Output: " + obj.searchMatrix(inputMatrix, inputTarget));
    }
}
