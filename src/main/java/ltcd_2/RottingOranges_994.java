package ltcd_2;

import common.Common;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges_994 {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int time = 0;
        int fresh = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while (!queue.isEmpty()) {
            time++;

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.remove();
                int[] r = new int[] {0,0,-1,1};
                int[] c = new int[] {-1,1,0,0};

                for (int k = 0; k < 4; k++) {
                    int neighr = curr[0] + r[k];
                    int neighc = curr[1] + c[k];
                    if (neighr < 0 || neighr >= m || neighc < 0 || neighc >= n)
                        continue;
                    if (grid[neighr][neighc] == 1) {
                        grid[neighr][neighc] = 2;
                        queue.add(new int[] {neighr, neighc});
                        fresh--;
                    }
                }
            }
        }

        return fresh == 0 ? time - 1 : -1;
    }

    public static void main(String[] args) {

        RottingOranges_994 object = new RottingOranges_994();
        int[][] input;

        input = new int[][] {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println("Output: " + object.orangesRotting(input) + ", Expected: 4");

        input = new int[][] {{2,1,1},{0,1,1},{1,0,1}};
        System.out.println("Output: " + object.orangesRotting(input) + ", Expected: -1");

        input = new int[][] {{2,1,1},{1,1,1},{0,1,2}};
        System.out.println("Output: " + object.orangesRotting(input) + ", Expected: 2");
    }
}


