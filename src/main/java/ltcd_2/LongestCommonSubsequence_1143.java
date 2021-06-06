package ltcd_2;

/**
 * @author Monali L on 6/6/2021
 */

public class LongestCommonSubsequence_1143 {

    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length()+1];
        dp[0][0] = 0;

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max( dp[i][j-1] , dp[i-1][j] );
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence_1143 object = new LongestCommonSubsequence_1143();

        String text1;
        String text2;

        text1 = "abcde";
        text2 = "ace";
        System.out.printf("%s | %s | %s", text1, text2, object.longestCommonSubsequence(text1, text2));
        System.out.println();

        text1 = "abc";
        text2 = "abc";
        System.out.printf("%s | %s | %s", text1, text2, object.longestCommonSubsequence(text1, text2));
        System.out.println();

        text1 = "abc";
        text2 = "def";
        System.out.printf("%s | %s | %s", text1, text2, object.longestCommonSubsequence(text1, text2));
        System.out.println();
    }
}
