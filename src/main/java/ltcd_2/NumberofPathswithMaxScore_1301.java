package ltcd_2;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 6/6/2021
 */
public class NumberofPathswithMaxScore_1301 {


    public int[] pathsWithMaxScore(List<String> board) {

        int n = board.size();
        int[][] pathSum = new int[n][n];
        int[][] pathCount = new int[n][n];
        int[][] neigh = {
                {-1, 0},
                {0, -1},
                {-1, -1}
        };

        pathSum[n-1][n-1] = 0;
        pathCount[n-1][n-1] = 1;

        for (int r = n-1; r >= 0; r--) {
            for (int c = n-1; c >= 0; c--) {
                if (r == 0 && c == 0 || board.get(r).charAt(c) == 'X' || pathCount[r][c] == 0) continue;
                int prev = pathSum[r][c];
                for (int i = 0; i < 3; i++) {

                    int nr = r + neigh[i][0];
                    int nc = c + neigh[i][1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                    char ch = board.get(nr).charAt(nc);

                    if (ch != 'X') {
                        int total = (ch == 'E') ? prev : prev + Character.getNumericValue(ch);
                        if (total > pathSum[nr][nc]) {
                            pathSum[nr][nc] = total;
                            pathCount[nr][nc] = pathCount[r][c];
                        } else if (total == pathSum[nr][nc]) {
                            pathCount[nr][nc] = pathCount[r][c] + pathCount[nr][nc];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(pathSum[i][j] + " ");
            }
            System.out.println();
        }

        return new int[] {pathSum[0][0], pathCount[0][0]};
    }

    public static void main(String[] args) {
        NumberofPathswithMaxScore_1301 object = new NumberofPathswithMaxScore_1301();

        List<String> input;
        int[] output;

        input = Arrays.asList("E12","1X1","21S");
        output = object.pathsWithMaxScore(input);
        System.out.println("Input: " + input);
        System.out.println("Maximum sum: " + output[0]);
        System.out.println("Total Paths: " + output[1]);
        System.out.println();

        input = Arrays.asList("E23", "2X2", "12S");
        output = object.pathsWithMaxScore(input);
        System.out.println("Input: " + input);
        System.out.println("Maximum sum: " + output[0]);
        System.out.println("Total Paths: " + output[1]);
        System.out.println();

        input = Arrays.asList("E11","XXX","11S");
        output = object.pathsWithMaxScore(input);
        System.out.println("Input: " + input);
        System.out.println("Maximum sum: " + output[0]);
        System.out.println("Total Paths: " + output[1]);
        System.out.println();
    }
}
