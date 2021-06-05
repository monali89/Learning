package ltcd;

import org.junit.Assert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubstringNRep {

    public static void main(String[] args) {
        Assert.assertEquals(4, lengthOfLongestSubstring1("pwwkewm"));
        //Assert.assertEquals(4, lengthOfLongestSubstring2("pwwkewm"));
    }

    public static int lengthOfLongestSubstring1(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<Character>();

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++)); // emptying the set even if one repeating character found
            }
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

}

/*
* Given a string, find the length of the longest substring without repeating characters.
*
* Input: "abcabcbb"
* Output: 3
* Explanation: The answer is "abc", with the length of 3.
*
* Input: "bbbbb"
* Output: 1
* Explanation: The answer is "b", with the length of 1.
*
* Input: "pwwkew"
* Output: 3
* Explanation: The answer is "wke", with the length of 3.
* Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
*
* */
