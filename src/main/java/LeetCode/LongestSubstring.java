package LeetCode;

import org.junit.Assert;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        //Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("eceba"), 3);
        //Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("aa"), 2);
        Assert.assertEquals(lengthOfLongestSubstringTwoDistinct("abbcefffddacbbef"), 5);
    }

    public static int lengthOfLongestSubstringTwoDistinct(String s) {

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
    }
}
