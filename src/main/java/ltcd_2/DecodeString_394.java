package ltcd_2;

import java.util.Stack;

public class DecodeString_394 {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<Integer>();
        Stack<String> stringStack = new Stack<String>();
        countStack.push(0);
        stringStack.push("");

        int ctr = 0;

        while (ctr < s.length()) {

            char c = s.charAt(ctr);

            if (Character.isDigit(c)) {
                int count = 0;
                while (Character.isDigit(c)) {
                    count = count*10 + Character.getNumericValue(c);
                    ctr++;
                    c = s.charAt(ctr);
                }
                countStack.push(count);
                ctr--;

            } else if (c == '[') {
                stringStack.push("");

            } else if (c >= 'a' && c <= 'z') { // is a char
                String currStr = stringStack.pop();
                currStr = currStr.concat(String.valueOf(c));
                stringStack.push(currStr);

            } else if (c == ']') {
                String currStr = stringStack.pop();
                StringBuilder repeated = new StringBuilder();
                int currCount = countStack.pop();
                for (int i = 0; i < currCount; i++)
                    repeated.append(currStr);
                stringStack.push(repeated.toString());
            }
            ctr++;
        }

        StringBuilder result = new StringBuilder();
        while (!stringStack.isEmpty()) result.insert(0, stringStack.pop());

        return result.toString();
    }

    public static void main(String[] args) {
        DecodeString_394 object = new DecodeString_394();
        String input = "";
        String output = "";
        String expected = "";

        // example 1
        /*input = "3[a]2[bc]";
        output = object.decodeString(input);
        expected = "aaabcbc";
        System.out.println("Input: " + input + " | Expected: " + expected + " | Actual: " + output +
                " | Equal: " + (output.equals(expected)));*/

        // example 2
        input = "3[a2[c]]";
        output = object.decodeString(input);
        expected = "accaccacc";
        System.out.println("Input: " + input + " | Expected: " + expected + " | Actual: " + output +
                " | Equal: " + (output.equals(expected)));

        // example 3
        /*input = "2[abc]3[cd]ef";
        output = object.decodeString(input);
        expected = "abcabccdcdcdef";
        System.out.println("Input: " + input + " | Expected: " + expected + " | Actual: " + output +
                " | Equal: " + (output.equals(expected)));

        // example 4
        input = "abc3[cd]xyz";
        output = object.decodeString(input);
        expected = "abccdcdcdxyz";
        System.out.println("Input: " + input + " | Expected: " + expected + " | Actual: " + output +
                " | Equal: " + (output.equals(expected)));*/
    }

}
