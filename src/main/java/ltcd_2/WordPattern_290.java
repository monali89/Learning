package ltcd_2;

import common.Common;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split(" ");

        if (arr.length != pattern.length()) return false;

        Map<Character, String> mapCharToString = new HashMap<Character, String>();
        Map<String, Character> mapStringToChar = new HashMap<String, Character>();

        for (int i=0; i<arr.length; i++) {
            char c = pattern.charAt(i);

            if (mapCharToString.containsKey(c)) {
                if (!mapStringToChar.containsKey(arr[i])) return false;
                if (!mapCharToString.get(c).equals(arr[i]) || mapStringToChar.get(arr[i]) != c) return false;
            } else {
                mapCharToString.put(c, arr[i]);
                mapStringToChar.put(arr[i], c);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        WordPattern_290 object = new WordPattern_290();
        String s = "";
        String pattern = "";
        boolean expected;

        // test 1
        pattern = "abba"; s = "dog cat cat dog";
        expected = true;
        Common.printResult("Pattern: " + pattern + " | String: " + s, object.wordPattern(pattern, s), expected);

        // test 2
        pattern = "abba"; s = "dog dog dog dog";
        expected = false;
        Common.printResult("Pattern: " + pattern + " | String: " + s, object.wordPattern(pattern, s), expected);

        // test 3
        pattern = "abba"; s = "dog cat cat fish";
        expected = false;
        Common.printResult("Pattern: " + pattern + " | String: " + s, object.wordPattern(pattern, s), expected);
    }
}
