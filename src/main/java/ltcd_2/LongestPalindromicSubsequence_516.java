package ltcd_2;

/**
 * @author Monali L on 6/6/2021
 */
public class LongestPalindromicSubsequence_516 {

    public void longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        for (int ed = n-1; ed >= 0; ed--) {
            dp[ed][ed] = 1;
            for (int st = ed+1; st < n; st++) {
                if (s.charAt(ed) == s.charAt(st)) {
                    dp[ed][st] = dp[ed+1][st-1] + 2;
                } else {
                    dp[ed][st] = Math.max(dp[ed-1][st], dp[ed][st+1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence_516 object = new LongestPalindromicSubsequence_516();
        String input = "";

        input = "cbbd";
        object.longestPalindromeSubseq(input);
    }
}
