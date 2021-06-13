package ltcd_2;

public class MinimumEffortPath_1631 {

    private int minEffort;

    public int minimumEffortPath(int[][] heights) {

        minEffort = Integer.MAX_VALUE;
        
        dfs(heights, new boolean[heights.length][heights[0].length], 0, 0, 0);

        return minEffort;
    }

    public void dfs(int[][] heights, boolean[][] isVisited, int r, int c, int currEffort) {

        if (r == heights.length-1 && c == heights[0].length-1) {
            minEffort = Math.min(currEffort, minEffort);
            return;
        }

        isVisited[r][c] = true;

        int[] i = {-1, 1, 0, 0};
        int[] j = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            if (r+i[k] > -1 && r+i[k] < heights.length && c+j[k] > -1 && c+j[k] < heights[0].length) {
                if (isVisited[r + i[k]][c + j[k]]) continue;
                dfs(heights, isVisited, r + i[k], c + j[k], Math.abs(heights[r + i[k]][c + j[k]] - heights[r][c]));
                isVisited[r + i[k]][c + j[k]] = false;
            }
        }
    }

    public static void main(String[] args) {

        MinimumEffortPath_1631 object = new MinimumEffortPath_1631();
        int[][] input;

        // example 1
        /*input = new int[][] {{1,2,2},{3,8,2},{5,3,5}};
        System.out.println("Expected: 2" + ", Output: " + object.minimumEffortPath(input));

        // example 2
        input = new int[][] {{1,2,3},{3,8,4},{5,3,5}};
        System.out.println("Expected: 1" + ", Output: " + object.minimumEffortPath(input));

        // example 3
        input = new int[][] {{1,2,1,1,1},{1,2,1,2,1},{1,2,1,2,1},{1,2,1,2,1},{1,1,1,2,1}};
        System.out.println("Expected: 0" + ", Output: " + object.minimumEffortPath(input));*/

        // after submit test
        input = new int[][] {{1,10,6,7,9,10,4,9}};
        System.out.println("Expected: 9" + ", Output: " + object.minimumEffortPath(input));
    }
}
