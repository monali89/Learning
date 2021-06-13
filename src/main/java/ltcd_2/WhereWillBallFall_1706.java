package ltcd_2;

public class WhereWillBallFall_1706 {

    public int[] findBall(int[][] grid) {

        int m = grid.length; // rows
        int n = grid[0].length; // cols

        int[] answer = new int[n];

        for (int i = 0; i< n; i++) { // drop ball from each col
            int r = 0;
            int c = i;
            while (r < m && c > -1 && c < n) {
                if (grid[r][c] == 1) {
                    if ((c+1) < n && grid[r][c+1] == 1) {
                        r = r+1;
                        c = c+1;
                    } else {
                        answer[i] = -1;
                        break;
                    }
                } else if (grid[r][c] == -1) {
                    if ((c-1) > -1 && grid[r][c-1] == -1) {
                        r = r + 1;
                        c = c - 1;
                    } else {
                        answer[i] = -1;
                        break;
                    }
                }
                answer[i] = c;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        WhereWillBallFall_1706 object = new WhereWillBallFall_1706();
        int[][] input;
        int[] output;

        // example 1
        /*input = new int[][] {
                {1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}
        };
        output = object.findBall(input);
        System.out.println("Expected: [1,-1,-1,-1,-1]");
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();

        // example 2
        input = new int[][] {
                {-1}
        };
        output = object.findBall(input);
        System.out.println("Expected: [-1]");
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();

        // example 3
        input = new int[][] {
                {1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}
        };
        output = object.findBall(input);
        System.out.println("Expected: [0,1,2,3,4,-1]");
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();
*/
        // after submit test
        input = new int[][] {
                {-1,1,-1,-1,-1,-1,-1,-1,1,-1,-1,-1,-1,1,1,-1,-1,-1,1,1,1,-1,-1,1,1,-1,-1,1,-1,-1,-1,-1,-1,-1,-1,-1,-1,1,-1,1,-1,-1,-1,-1,-1,-1,-1,1,-1,-1,1,-1,1,-1,-1,1,1,-1,1,-1,-1,-1,-1,1,1,1,1,1,1,-1,1,1,1,-1,1,1,1,-1,-1,-1,1,-1,1,-1,-1,1,1,-1,-1,1,-1,1,-1,1,1,1,-1,-1,-1,-1}
        };
        output = object.findBall(input);
        System.out.println("Expected: TBD");
        for (int value : output) {
            System.out.print(value + " ");
        }
        System.out.println();

    }
}
