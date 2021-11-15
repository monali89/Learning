package ltcd;

import common.Common;

public class EditDistance {

    int[][] dp;

    public int minDistance(String word1, String word2) {

        dp = new int[word1.length()][word2.length()];

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return match(word1, word2, 0, 0);
    }

    public int match(String s1, String s2, int i, int j){
        if(i == s1.length()) return s2.length() - j;
        if(j == s2.length()) return s1.length() - i;

        if (dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = match(s1, s2, i+1, j+1);
        }else{
            int insert = match(s1, s2, i+1, j);
            int delete = match(s1, s2, i, j+1);
            int replace = match(s1, s2, i+1, j+1);
            dp[i][j] = Math.min(replace, Math.min(insert, delete)) + 1;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {

        EditDistance object = new EditDistance();
        String word1;
        String word2;
        int output;
        int expected;

        word1 = "horse";
        word2 = "ros";
        output = object.minDistance(word1, word2);
        expected = 3;
        Common.printResult("Word1: " + word1 + ", Word2: " + word2, output, expected);

        word1 = "dinitrophenylhydrazine";
        word2 = "acetylphenylhydrazine";
        output = object.minDistance(word1, word2);
        expected = 3;
        Common.printResult("Word1: " + word1 + ", Word2: " + word2, output, expected);
    }
}


// 72. Edit Distance