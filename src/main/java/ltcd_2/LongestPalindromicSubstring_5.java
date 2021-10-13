package ltcd_2;

import common.Common;

public class LongestPalindromicSubstring_5 {

    private int maxLength;
    private int left;
    private int right;

    public String longestPalindrome(String s) {

        maxLength = 0;
        left = 0;
        right = s.length();

        for (int i = 0; i < s.length()-1; i++) {
            helper(s, i, i);
            helper(s, i, i+1);
        }

        return s.substring(left, right);
    }

    private void helper(String s, int l, int r) {

        while (l > -1 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        if (maxLength < (r - l + 1)) {
            maxLength = r - l + 1;
            left = l+1;
            right = r;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring_5 object = new LongestPalindromicSubstring_5();
        String input;
        String expected;

        // test 1
        input = "babad";
        expected = "bab";
        Common.printResult(input, object.longestPalindrome(input), expected);
    }

}

/*
* Start with any index, then expand the left/right window
* as per palindrome condition (left char == right char)
*
* To cover both odd/even length string
* consider left = right = same index (odd)
* left = right + 1 (even)
*
* this is basically checking for palindrome condition on each index
* */
