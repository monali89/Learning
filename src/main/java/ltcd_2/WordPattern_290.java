package ltcd_2;

import common.Common;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    public boolean wordPattern(String pattern, String s) {

        Map<Character, String> map = new HashMap<Character, String>();
        String[] arr = s.split(" ");

        if (arr.length != pattern.length()) return false;

        for (int i=0; i<arr.length; i++) {

            char c = pattern.charAt(i);

            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) return false;
            } else {
                map.put(c, arr[i]);
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
        Common.printResult("", object.wordPattern(pattern, s), expected);

        // test 2
        pattern = "abba"; s = "dog dog dog dog";
        expected = false;
        Common.printResult("", object.wordPattern(pattern, s), expected);
    }
}
