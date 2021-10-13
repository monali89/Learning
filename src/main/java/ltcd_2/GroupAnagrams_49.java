package ltcd_2;

import java.util.*;

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for (String s: strs) {

            char[] a = s.toCharArray();
            Arrays.sort(a);
            String sorted = charArrayToString(a);

            List<String> l;
            if (map.containsKey(sorted)) {
                l = map.get(sorted);
                l.add(s);
                map.put(sorted, l);
            } else {
                l = new ArrayList<String>();
                l.add(s);
                map.put(sorted, l);
            }
        }

        for (String s: map.keySet()) {
            result.add(map.get(s));
        }

        return result;
    }

    private String charArrayToString(char[] a) {
        StringBuilder str = new StringBuilder();
        for (char c: a) {
            str.append(c);
        }
        return str.toString();
    }

    private boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        GroupAnagrams_49 object = new GroupAnagrams_49();
        String[] input;

        // test 1
        input = new String[] {"eat","tea","tan","ate","nat","bat"};
        System.out.println(object.groupAnagrams(input));
    }
}
