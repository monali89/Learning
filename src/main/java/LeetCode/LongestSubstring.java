package LeetCode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        Assert.assertEquals(3, lengthOfLongestSubstringTwoDistinct("abcabcbb"));
        //Assert.assertEquals(4, lengthOfLongestSubstringTwoDistinct("eceba"));
        //Assert.assertEquals(1, lengthOfLongestSubstringTwoDistinct("aa"));
        //Assert.assertEquals(4, lengthOfLongestSubstringTwoDistinct("abbcefffddacbbef"));
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int start = 0, end = 0;

        while (end < s.length()) {
            char c = s.charAt(end);
            System.out.println("DEBUG: c - " + c);
            System.out.println("DEBUG: start - " + start + ", end - " + end);
            if (map.containsKey(c)) { // Repeated character
                System.out.println("DEBUG: Repeated char, reset start");
                start = map.get(c) + 1;
                int i = 0;
                while (i < start) map.remove(s.charAt(i++));
                //map.put(c, end);
            }
            map.put(c, end);
            len = Math.max(len, end - start + 1);
            System.out.println("DEBUG: start - " + start + ", end - " + end + ", len - " + len);
            end++;
            System.out.println("DEBUG: map - " + map);
            System.out.println();
        }
        System.out.println("DEBUG: string - " + s + ", len - " + len);
        return len;
    }

    /*public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int maxLength = Integer.MIN_VALUE;

        for(int i=0; i<s.length(); i++){
            Set<Character> set = new HashSet<Character>();
            int next = i;
            while(set.size()<=2 && next<s.length()){
                set.add(s.charAt(next++));
            }
            if(set.size() > 2) next--;
            maxLength = Math.max(maxLength, s.substring(i,next).length());

            System.out.println("For char[" + i + "] " + s.charAt(i) + ", Longest: " + s.substring(i,next));

        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }*/
}
