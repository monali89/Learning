package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 6/7/2019
 * @author: Monali
 */

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println("Expected - BANC, Actual - " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("Expected - AUCPBRC, Actual - " + minWindow("AXYBNQAUCPBRC", "ABC"));
    }

    public static String minWindow_2(String s, String t) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c: t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        int start = 0, end = 0, minLen = Integer.MAX_VALUE;

        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {

            }
        }

        return null;
    }

    // Copied from https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
    public static String minWindow(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }
        int counter = t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;

        while(end < s.length()){
            if(map[s.charAt(end++) - 'A'] > 0){
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while(counter == 0){
                if(end - begin < d){
                    head = begin;
                    d = end - head;
                }
                map[s.charAt(begin)]++;
                if(map[s.charAt(begin++) - 'A'] > 0){
                    counter++;
                }
                begin++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, d);
    }

}
