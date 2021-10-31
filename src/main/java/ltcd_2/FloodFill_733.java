package ltcd_2;

import common.Common;

public class FloodFill_733 {

    private int m;
    private int n;
    private boolean[][] isVisited;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        m = image.length;
        n = image.length > 0 ? image[0].length : 0;

        if (m == 0 || n == 0) return null;

        isVisited = new boolean[m][n];
        helper(image, sr, sc, newColor);
        return image;
    }

    private void helper(int[][] mat, int i, int j, int newColor) {

        if (isVisited[i][j]) return;

        int oldColor = mat[i][j];
        mat[i][j] = newColor;
        isVisited[i][j] = true;

        // left, right, top, bottom
        int[] i2 = new int[] {0, 0, -1, 1};
        int[] j2 = new int[] {-1, 1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int ni = i + i2[k];
            int nj = j + j2[k];

            if (ni < 0 || ni >= m || nj < 0 || nj >= n)
                continue;
            if (mat[ni][nj] == oldColor)
                helper(mat, ni, nj, newColor);
        }

    }

    public static void main(String[] args) {

        FloodFill_733 object = new FloodFill_733();
        int[][] input;
        int[][] output;

        input = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        output = object.floodFill(input, 1, 1, 2);
        Common.print2DIntArray(output);

        input = new int[][] {{0,0,0},{0,0,0}};
        output = object.floodFill(input, 0, 0, 2);
        Common.print2DIntArray(output);
    }
}
