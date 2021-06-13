package ltcd_2;

public class MinimumEffortPath_1631 {

    private int[][] h;
    private int[][] memo;

    public int minimumEffortPath(int[][] heights) {

        int minEffort = 0;
        this.h = heights;
        this.memo = new int[h.length][h[0].length];
        memo[0][0] = 0;
        dfs(0, 0, new boolean[h.length][h[0].length], 0);

        return minEffort;
    }

    private void dfs(int i, int j, boolean[][] isVisited, int prev) {
        memo[i][j] = Math.min(memo[i][j], Math.abs(prev - memo[i][j]));
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
