package ltcd;

import common.Common;
import org.junit.Assert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (char c: s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            s2Arr[s2.charAt(i) - 'a']++;
            if (i >= s1.length()) s2Arr[s2.charAt(i - s1.length()) - 'a']--;
            if (Arrays.equals(s1Arr, s2Arr)) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        PermutationInString_567 object = new PermutationInString_567();
        String inputS1;
        String inputS2;
        boolean output;
        boolean expected;

        inputS1 = "ab";
        inputS2 = "eidbaooo";
        output = object.checkInclusion(inputS1, inputS2);
        expected = true;
        Common.printResult(inputS1 + ", " + inputS2, output, expected);

        inputS1 = "ab";
        inputS2 = "eidboaoo";
        output = object.checkInclusion(inputS1, inputS2);
        expected = false;
        Common.printResult(inputS1 + ", " + inputS2, output, expected);

        inputS1 = "xy";
        inputS2 = "eidboaoo";
        output = object.checkInclusion(inputS1, inputS2);
        expected = false;
        Common.printResult(inputS1 + ", " + inputS2, output, expected);

        inputS1 = "adc";
        inputS2 = "dcda";
        output = object.checkInclusion(inputS1, inputS2);
        expected = true;
        Common.printResult(inputS1 + ", " + inputS2, output, expected);

        inputS1 = "abc";
        inputS2 = "cccccbabbbaaaa";
        output = object.checkInclusion(inputS1, inputS2);
        expected = true;
        Common.printResult(inputS1 + ", " + inputS2, output, expected);

    }
}
