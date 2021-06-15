package ltcd_2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GoodSplit_1525 {

    public int numSplits(String s) {

        Map<Character ,Integer> left = new HashMap<Character, Integer>();
        Map<Character ,Integer> right = new HashMap<Character, Integer>();

        // Initially put all the characters and their counts in the right map,
        // as we will be traversing the string from left to right

        for (int i = 0; i < s.length(); i++) {
            if (right.containsKey(s.charAt(i))) {
                int c = right.get(s.charAt(i));
                right.put(s.charAt(i), c+1);
            } else {
                right.put(s.charAt(i), 1);
            }
        }

        // Now traverse the string from left to right, pausing at
        // each index and checking if that char is present in the left.
        // If it is present in the left side, decrease it's count by 1
        // from right side and increment by 1 in left side.
        // If the count at right side goes below 1, delete this char.
        // After this, if the size of left == right,
        // then we found a good split for the string.

        int goodSplits = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (right.containsKey(c)) {
                int count = right.get(c);
                if (count - 1 <= 0) right.remove(c);
                else right.put(c, count-1);
            }
            if (left.containsKey(c)) {
                int count = left.get(c);
                left.put(c, count+1);
            } else {
                left.put(c, 1);
            }

            if (left.size() == right.size()) goodSplits++;
        }
        return goodSplits;
    }

    public static void main(String[] args) {

        GoodSplit_1525 object = new GoodSplit_1525();
        String input = "";
        int output;
        int expected;

        input = "aacaba";
        output = object.numSplits(input);
        expected = 2;
        System.out.printf("Input: %10s | Output: %s | Expected: %s | Result: %s", input, output, expected, (output == expected));
        System.out.println();

        input = "abcd";
        output = object.numSplits(input);
        expected = 1;
        System.out.printf("Input: %10s | Output: %s | Expected: %s | Result: %s", input, output, expected, (output == expected));
        System.out.println();

        input = "aaaaa";
        output = object.numSplits(input);
        expected = 4;
        System.out.printf("Input: %10s | Output: %s | Expected: %s | Result: %s", input, output, expected, (output == expected));
        System.out.println();

        input = "acbadbaada";
        output = object.numSplits(input);
        expected = 2;
        System.out.printf("Input: %10s | Output: %s | Expected: %s | Result: %s", input, output, expected, (output == expected));
        System.out.println();
    }
}
