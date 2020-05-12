package DP;

/**
 * @author Monali L on 4/25/2020
 */
public class DynamicProg {

    public static void main(String[] args) {

        System.out.println("1: Longest Common Subsequence");
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        longestCommonSubsequence(str1.toCharArray(), str2.toCharArray());
        printLCS(str1.toCharArray(), str1.length()-1, str2.length()-1);
        System.out.println();

        System.out.println("5. Ways to Cover a Distance");
        coverDistance();
        System.out.println();

        System.out.println("6. Longest Path In Matrix");
        matrixLongestPath();
        System.out.println();
    }

    // Longest Common Subsequence
    // Problem: Given two sequences, find the length of longest subsequence present in both of them.
    private static int[][] c;
    private static char[][] b;
    public static void longestCommonSubsequence(char[] c1, char[] c2) {
        int m = c1.length;
        int n = c2.length;
        c = new int[m][n];
        b = new char[m][n];
        for(int i=0; i<m; i++){
            c[i][0] = 0;
        }
        for(int j=0; j<n; j++){
            c[0][j] = 0;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                if(c1[i] == c2[j]){
                    c[i][j] = c[i][j] + 1;
                    b[i][j] = 'D';
                }else{
                    if(c[i-1][j]>=c[i][j-1]){
                        c[i][j] = c[i-1][j];
                        b[i][j] = 'U';
                    }else{
                        c[i][j] = c[i][j-1];
                        b[i][j] = 'L';
                    }
                }
            }
        }
    }
    public static void printLCS(char[] x, int i, int j){
        if(i==0 || j==0){
            return;
        }else{
            if(b[i][j] == 'D'){
                printLCS(x, i-1, j-1);
                System.out.print(x[i] + " ");
            }else{
                if(b[i][j] == 'U'){
                    printLCS(x, i-1, j);
                }else{
                    printLCS(x, i, j-1);
                }
            }
        }
    }

    // TODO: Longest Increasing Subsequence
    // Problem:

    // TODO: Edit Distance
    // Problem: Given two strings str1 and str2 and below operations that can performed on str1.
    // Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
    // Insert, Remove, Replace - All of these operations are of equal cost.
    private static int[][] dp_mcd;
    public static void minConversionDist(String s1, String s2) {
        dp_mcd = new int[s1.length()+1][s2.length()+1];


    }
    public static void mcd_helper(String s1, String s2) {

    }

    // TODO: Minimum Partition
    // Problem: Given a set of integers, the task is to divide it into two sets S1 and S2
    // such that the absolute difference between their sums is minimum.
    public static void getMinSubsetDiff() {

    }

    // TODO: Ways to Cover a Distance
    // Problem: Given a distance ‘dist, count total number of ways to cover the distance with 1, 2 and 3 steps
    // Improve on performance
    private static int[] dp;
    public static void coverDistance() {
        int n = 3;
        dp = new int[n+1];
        int total = cd_helper(n-1) + cd_helper(n-2) + cd_helper(n-3);
        System.out.println("Total number of steps - " + total);
    }

    public static int cd_helper(int rem) {
        if (rem < 0) return 0;
        if (rem == 0) return 1;
        return cd_helper(rem-1) + cd_helper(rem-2) + cd_helper(rem-3);
    }

    // TODO: Longest Path In Matrix (fix stack error)
    // Problem: Given a n*n matrix where all numbers are distinct,
    // find the maximum length path (starting from any cell)
    // such that all cells along the path are in increasing order with a difference of 1.
    private static int[][] dp_mlp;
    public static void matrixLongestPath() {
        int[][] mat = {{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7}};
        dp_mlp = new int[mat.length][mat.length];
        int maxPath = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                if (dp_mlp[i][j] == 0) {
                    dp_mlp[i][j] = mlp_helper(mat, i, j);
                }
                maxPath = Math.max(maxPath, dp_mlp[i][j]);
            }
        }
        System.out.println(maxPath);
    }

    public static int mlp_helper(int[][] m, int r, int c) {
        if (r < 0 || c < 0 || r >= m.length || c >= m.length) return 0;
        return m[r][c] + Math.max(Math.max(mlp_helper(m, r-1, c), mlp_helper(m, r+1, c)),
                Math.max(mlp_helper(m, r, c-1), mlp_helper(m, r, c+1)));
    }

    // TODO: Subset Sum Problem
    // Problem: Given a set of non-negative integers, and a value sum, determine
    // if there is a subset of the given set with sum equal to given sum.
    public static void subsetSum() {

    }

    // TODO: Optimal Strategy for a Game


    // TODO: 0-1 Knapsack Problem


    // TODO: Boolean Parenthesization Problem



}
