package ltcd_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {

        int[] arr = new int[52];
        int odd = 0;
        int even = 0;
        int oddCount = 0;

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c <= 'z' && c >= 'a') {
                arr[s.charAt(i) - 'a']++;
            } else {
                arr[s.charAt(i) - 'A' + 26]++;
            }
        }

        for (int i=0; i<52; i++) {

            if (arr[i] == 0) continue;
            if (arr[i] % 2 == 0) even = even + arr[i];
            else {
                odd = odd + arr[i];
                oddCount++;
            }

        }

        return even + (oddCount == 0 ? 0 : odd - oddCount);
    }

    public int longestPalindrome_bk(String s) {

        if (s.length() == 1) return 1;

        Set<Character> set = new HashSet<Character>();
        int count = 0;

        for (char c: s.toCharArray()) {

            if (set.contains(c)) {
                set.remove(c);
                count++;
            } else {
                set.add(c);
            }
        }

        if (set.isEmpty()) return count*2;
        else return count*2 + 1;
    }

    public static void main(String[] args) {

        LongestPalindrome_409 object = new LongestPalindrome_409();
        String input = "";
        int expected;

        // test
        input = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        expected = 983;
        System.out.println("Output: " + object.longestPalindrome(input) + " | Expected: " + expected);
    }
}
