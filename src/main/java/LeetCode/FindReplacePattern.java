package LeetCode;

import java.util.*;

public class FindReplacePattern {

    public static void main(String[] args) {
        System.out.println(findAndReplacePattern(new String[]{"mee", "ccc"}, "abb"));
        System.out.println(findAndReplacePattern(new String[]{"meem", "xyyd"}, "abba"));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> rslt = new ArrayList<String>();

        for(String word: words){
            Map<Character, Character> map = new HashMap<Character, Character>();
            int i = 0;
            while(i < word.length()) {
                if (map.containsKey(pattern.charAt(i))) {
                    if (map.get(pattern.charAt(i)) != word.charAt(i)) break;
                } else {
                    if(map.values().contains(word.charAt(i))) break;
                    map.put(pattern.charAt(i), word.charAt(i));
                }
                i++;
            }
            if(i == word.length()) rslt.add(word);
        }

        return rslt;
    }

}
