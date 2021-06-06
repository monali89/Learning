package ltcd_2;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 6/6/2021
 */
public class NumberofPathswithMaxScore_1301 {

    private int pathCount;
    private int[][] pathSum;
    private int n;
    private boolean[][] isVisited;


    public int[] pathsWithMaxScore(List<String> board) {

        n = board.size();
        pathCount = 0;
        pathSum = new int[n][n];
        isVisited = new boolean[n][n];

        pathSum[n-1][n-1] = 0;
        dfs(n-1, n-1, board, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pathSum[i][j] + " ");
            }
            System.out.println();
        }

        return new int[] {pathSum[0][0], pathCount};
    }

    public int dfs(int r, int c, List<String> board, int count) {
        if (r < 0 || r >= n || c < 0 || c>= n) return 0;

        else if (board.get(r).charAt(c) == 'E') {
            pathSum[r][c] = count;
            pathCount++;
            return pathSum[r][c];

        } else if(pathSum[r][c] != 0) {
            return pathSum[r][c];

        } else {

            isVisited[r][c] = true;

            int[] idx1 = {-1, 0, -1};
            int[] idx2 = {0, -1, -1};
            int maxVal = Integer.MIN_VALUE;

            for (int i=0; i<3; i++) {

                int nr = r + idx1[i];
                int nc = c + idx2[i];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if (!isVisited[nr][nc] && board.get(nr).charAt(nc) != 'X') {
                    maxVal = Math.max(maxVal, dfs(r+idx1[i], c+idx2[i], board,
                            count + Character.getNumericValue(board.get(nr).charAt(nc))));
                    isVisited[r+idx1[i]][c+idx2[i]] = false;
                }
            }
            pathSum[r][c] = Character.getNumericValue(board.get(r).charAt(c)) + maxVal;
            return pathSum[r][c];
        }

    }

    public static void main(String[] args) {
        NumberofPathswithMaxScore_1301 object = new NumberofPathswithMaxScore_1301();
        List<String> input = Arrays.asList("E12","1X1","21S");
        // Arrays.asList("E23", "2X2", "12S");
        int[] output = object.pathsWithMaxScore(input);
        System.out.println("Maximum sum: " + output[0]);
        System.out.println("Total Paths: " + output[1]);
    }
}
