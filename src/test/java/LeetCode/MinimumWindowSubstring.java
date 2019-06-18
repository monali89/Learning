package LeetCode;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 6/7/2019
 * @author: Copied from https://leetcode.com/problems/minimum-window-substring/discuss/26808/Here-is-a-10-line-template-that-can-solve-most-'substring'-problems
 */

public class MinimumWindowSubstring {

    @Test
    public void test01(){
        Assert.assertEquals("BANC", minWindow("ADOBECODEBANC", "ABC"));
    }

    //@Test
    public void test02(){
        Assert.assertEquals("AUCPBRC", minWindow("AXYBNQAUCPBRC", "ABC"));
    }


    public String minWindow(String s, String t) {
        int[] map = new int[26];
        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i) - 'A']++;
        }
        int counter = t.length(), begin=0, end=0, d=Integer.MAX_VALUE, head=0;

        while(end < s.length()){
            if(map[s.charAt(end++) - 'A'] > 0){
                counter--;
            }
            while(counter == 0){
                if(end - begin < d){
                    head = begin;
                    d = end - head;
                }
                if(map[s.charAt(begin++) - 'A'] == 0){
                    counter++;
                }
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, d);
    }

}
