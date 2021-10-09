package ltcd_2;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome_409 {

    public int longestPalindrome(String s) {

        if (s.length() == 1) return 1;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("DEBUG: Length - " + s.length());
        System.out.println("DEBUG: Map - " + map);

        int length = 0;
        int maxOdd = 0;

        for (Character c: map.keySet()) {
            System.out.println("DEBUG: c - " + c + ", count - " + map.get(c));
            if (map.get(c) % 2 == 0) {
                System.out.println("DEBUG: Adding");
                length = length + map.get(c);
            } else {
                maxOdd = Math.max(maxOdd, map.get(c));
            }
        }

        System.out.println("DEBUG: maxOdd - " + maxOdd);

        length = length + maxOdd;
        return length;
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
