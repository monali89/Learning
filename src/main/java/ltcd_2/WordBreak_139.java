package ltcd_2;

import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 6/6/2021
 */
public class WordBreak_139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        int st = 0;
        int ed = 0;
        while (ed <= s.length()) {
            System.out.printf("%s | %s | %s", st, ed, s.substring(st, ed));
            System.out.println();
            if (wordDict.contains(s.substring(st, ed))) {
                st = ed;
                ed++;
            } else {
                ed++;
            }
        }
        return st == s.length() && ed == s.length()+1;
    }

    public static void main(String[] args) {

        WordBreak_139 object = new WordBreak_139();
        String string;
        List<String> wordList;

        /*string = "leetcode";
        wordList = Arrays.asList("leet","code");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));

        string = "applepenapple";
        wordList = Arrays.asList("apple","pen");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));

        string = "catsandog";
        wordList = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));*/

        string = "aaaaaaa";
        wordList = Arrays.asList("aaaa","aaa");
        System.out.println(string + " | " + wordList + " | " + object.wordBreak(string, wordList));
    }

}
