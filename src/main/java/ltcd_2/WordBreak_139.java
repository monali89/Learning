package ltcd_2;

import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 6/6/2021
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int ed = 1; ed <= s.length(); ed++) {
            for (int st = 0; st < ed; st++) {
                if (dp[st] && wordDict.contains(s.substring(st, ed))) {
                    dp[ed] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {

        WordBreak_139 object = new WordBreak_139();
        String string;
        List<String> wordList;

        string = "leetcode";
        wordList = Arrays.asList("leet","code");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));

        string = "applepenapple";
        wordList = Arrays.asList("apple","pen");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));

        string = "catsandog";
        wordList = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));

        string = "aaaaaaa";
        wordList = Arrays.asList("aaaa","aaa");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));
    }

}
