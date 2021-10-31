package ltcd_2;

import common.Common;

public class MaxIslandArea_695 {

    private int m;
    private int n;
    private boolean[][] isVisited;

    public int maxAreaOfIsland(int[][] grid) {

        m = grid.length;
        n = grid.length > 0 ? grid[0].length : 0;

        if (m == 0 || n == 0) return 0;

        isVisited = new boolean[m][n];

        int maxArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !isVisited[i][j]) continue;
                maxArea = Math.max(maxArea, helper(grid, i, j));
                // System.out.println(i + " | " + j + " | " + grid[i][j] + " | " + maxArea);
            }
        }

        return maxArea;
    }

    private int helper(int[][] mat, int i, int j) {

        if (isVisited[i][j]) return 0;

        isVisited[i][j] = true;
        int currArea = 1;

        // left, right, top, bottom
        int[] i2 = new int[] {0, 0, -1, 1};
        int[] j2 = new int[] {-1, 1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int ni = i + i2[k];
            int nj = j + j2[k];

            if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;
            if (mat[ni][nj] == 1)
                currArea = helper(mat, ni, nj) + currArea;
        }

        return currArea;
    }

    public static void main(String[] args) {

        MaxIslandArea_695 object = new MaxIslandArea_695();
        int[][] input;
        int output;
        int expected;

        input = new int[][] {{0,1,0}, {1,1,0}, {0,1,1}};
        expected = 5;
        output = object.maxAreaOfIsland(input);
        Common.printResult("Grid 1", output, expected);

        input = new int[][] {{1,1,0}, {1,1,0}, {0,0,0}};
        expected = 4;
        output = object.maxAreaOfIsland(input);
        Common.printResult("Grid 1", output, expected);

        input = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}};
        expected = 6;
        output = object.maxAreaOfIsland(input);
        Common.printResult("Grid 1", output, expected);

    }
}
