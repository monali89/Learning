package ltcd_2;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation_784 {

    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        helper(result, new StringBuilder(), s,0);
        return result;
    }

    private void helper(List<String> list, StringBuilder temp, String s, int index) {

        if (temp.length() == s.length()) {
            list.add(temp.toString());
        } else {
            char c = s.charAt(index);
            helper(list, temp.append(c), s, index+1);
            temp.deleteCharAt(temp.length() - 1);
            if (c >= 'a' && c <= 'z') {
                helper(list, temp.append(Character.toUpperCase(c)), s, index+1);
                temp.deleteCharAt(temp.length() - 1);
            } else if (c >= 'A' && c <= 'Z') {
                helper(list, temp.append(Character.toLowerCase(c)), s, index+1);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        LetterCasePermutation_784 object = new LetterCasePermutation_784();

        System.out.println(object.letterCasePermutation("a1b2"));
        System.out.println(object.letterCasePermutation("3z4"));
        System.out.println(object.letterCasePermutation("12345"));
        System.out.println(object.letterCasePermutation("0"));
        System.out.println(object.letterCasePermutation("c"));
    }
}
