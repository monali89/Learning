package LeetCode;

import org.junit.Assert;
import org.junit.Test;

public class SlidingWindow {

    @Test
    public void test01(){
        Assert.assertEquals(minWindow("ADOBECODEBANC", "ABC"), "BANC");
    }

    @Test
    public void test02(){
        Assert.assertEquals(minWindow("axbycabc", "abc"), "abc");
    }

    public static String minWindow(String s, String t) {
        int[] arr = new int[26];
        for (int i = 0; i < t.length(); i++)
            arr[t.charAt(i) - 'a']++;

        int counter = t.length(), left = 0, right = 0, window = Integer.MAX_VALUE, head = -1;
        while (right < s.length()) {
            char rc = s.charAt(right++);
            if (arr[rc - 'a'] > 0) counter--;
            arr[rc - 'a']--;

            while (counter == 0) {
                if (right - left < window)
                    window = right - (head = left);

                char lc = s.charAt(left++);
                if (arr[lc - 'a'] == 0) counter++;
                arr[lc - 'a']++;
            }
        }
        return head == -1 ? "" : s.substring(head, head + window);
    }

}
