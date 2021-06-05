package ltcd_2;

/**
 * @author Monali L on 6/5/2021
 */
public class MinimumFallingPathSum_931 {
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

        for (int i=0; i < n; i++) {
            result[i] = Integer.MAX_VALUE;
            for (int j = -1; j <= 1; j++) {
                if (i+j < 0 || i+j >= n) continue;
                result[i] = Math.min(result[i], curr[i] + prev[i+j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum_931 object = new MinimumFallingPathSum_931();
        int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(object.minFallingPathSum(matrix));
    }
}
