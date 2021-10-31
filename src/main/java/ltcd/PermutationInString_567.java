package ltcd;

import common.Common;
import org.junit.Assert;

public class PermutationInString_567 {

    public boolean checkInclusion(String s1, String s2) {

        int[] s1Arr = new int[26];

        for (char c: s1.toCharArray()) {
            s1Arr[c - 'a']++;
        }

        int i = 0;
        boolean flag = false;

        while (i < s2.length()) {
            char c = s2.charAt(i);

            if (s1Arr[c - 'a'] > 0) {

                int[] s2Arr = new int[26];

                while (i < s2.length() && s1Arr[s2.charAt(i) - 'a'] > 0) {
                    // found a char which is in s1
                    s2Arr[s2.charAt(i) - 'a']++;
                    i++;
                }

                int j = 0;
                while (j < 26 && s1Arr[j] == s2Arr[j]) j++;
                if (j == 26) flag = true;

            } else {
                i++;
            }
        }

        return flag;
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

    }
}
