package ltcd_2;

public class WhereWillBallFall_1706 {
    
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] answer = new int[n];

        String pos = null;

        for (int k = 0; k < n; k++) {

            int i = 0;
            int j = k;
            boolean[][] isVisited = new boolean[m][n];

            while (i < m) {

                if (isVisited[i][j]) {
                    answer[k] = -1;
                    break;
                }
                isVisited[i][j] = true;

                if (grid[i][j] == 1) {

                    // when current position is top right
                    if (pos == null || pos.equals("bl") || pos.equals("br") || pos.equals("tl")) {
                        pos = "tr";
                        j++;
                    } else if (pos.equals("tr")) {
                        pos = "bl";
                        if (i == m-1) {
                            answer[k] = j;
                            break;
                        }
                        i++;
                    }
                } else if (grid[i][j] == -1) {

                    if (pos == null || pos.equals("bl") || pos.equals("br") || pos.equals("tr")) {
                        pos = "tl";
                        j--;
                    } else if (pos.equals("tl")) {
                        pos = "br";
                        if (i == m-1) {
                            answer[k] = j;
                            break;
                        }
                        i++;
                    }
                }
                if (j < 0 || j >= n) {
                    answer[k] = -1;
                    break;
                }
            }
        }
        return answer;
    }
}
