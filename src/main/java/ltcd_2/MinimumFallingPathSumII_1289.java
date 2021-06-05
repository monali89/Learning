package ltcd_2;

/**
 * @author Monali L on 6/5/2021
 */
public class MinimumFallingPathSumII_1289 {

    private int n;

    public int minFallingPathSum(int[][] matrix) {
        n = matrix.length;
        int minPath = Integer.MAX_VALUE;
        int[] result = helper(0, matrix);
        for (int i=0; i < n; i++) minPath = Math.min(minPath, result[i]);
        return minPath;
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
