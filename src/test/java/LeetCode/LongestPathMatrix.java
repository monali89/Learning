package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: monali on 5/7/2019
 */

public class LongestPathMatrix {

    @Test
    public void testPathLength(){
        /*Assert.assertEquals(3, longestIncreasingPath(new int[][]{{4,3},{2,1}}));
        Assert.assertEquals(4, longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
        Assert.assertEquals(4, longestIncreasingPath(new int[][]{{3,4,5},{3,2,6},{2,2,1}}));
        Assert.assertEquals(1, longestIncreasingPath(new int[][]{{1}}));
        Assert.assertEquals(3, longestIncreasingPath(new int[][]{{0},{1},{5},{5}}));
        Assert.assertEquals(3, longestIncreasingPath(new int[][]{{1,2,3,-2}}));
        Assert.assertEquals(3, longestIncreasingPath(new int[][]{{3,3,14,2,17,12,5}}));
        Assert.assertEquals(0, longestIncreasingPath(new int[][]{}));*/
        Assert.assertEquals(3, longestIncreasingPath(new int[][]{{1,2},{2,3}}));
    }

    static int[][] m;
    static int[][] dp;

    public static int longestIncreasingPath(int[][] matrix) {

        if(matrix.length == 0) return 0;

        m = matrix;
        dp = new int[m.length][m[0].length];
        int max = 0;

        for(int i=0; i<m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[0].length; j++){
                max = Math.max(max, helper(i, j));
            }
        }
        return max;
    }

    public static int helper(int i, int j){

        if(i < 0 || j < 0 || i >= m.length || j >= m[0].length) return 0;

        int[] counts = new int[4];
        for (int k = 0; k < 4; k++) counts[k] = 1;

        if(i > 0 && m[i-1][j] > m[i][j]){  // UP
           if(dp[i-1][j] == -1){
               dp[i-1][j] = helper(i-1, j);
           }
           counts[0] = counts[0] + dp[i-1][j];
        }

        if(i < m.length-1 && m[i+1][j] > m[i][j]){ // DOWN
            if(dp[i+1][j] == -1)
                dp[i+1][j] = helper(i+1, j);
            counts[1] = counts[1] + dp[i+1][j];
        }

        if(j > 0 && m[i][j-1] > m[i][j]){  // LEFT
            if(dp[i][j-1] == -1)
                dp[i][j-1] = helper(i, j-1);
            counts[2] = counts[2] + dp[i][j-1];
        }

        if(j < m[0].length-1 && m[i][j+1] > m[i][j]){ // RIGHT
            if(dp[i][j+1] == -1)
                dp[i][j+1] = helper(i, j+1);
            counts[3] = counts[3] + dp[i][j+1];
        }

        Arrays.sort(counts);
        return Math.max(counts[2], counts[3]);
    }
}

/*
* Given an integer matrix, find the length of the longest increasing path.
* From each cell, you can either move to four directions: left, right, up or down.
* You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
*
* Input: nums =
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
]
Output: 4
Explanation: The longest increasing path is [1, 2, 6, 9].

* */
