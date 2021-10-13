package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequences_187 {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<String>();
        Set<String> set = new HashSet<String>();

        for (int i=0; i+9<s.length(); i++) {
            String t = s.substring(i, i+10);

            if (!set.contains(t)) {
                set.add(t);
            } else {
                if (!list.contains(t)) list.add(t);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        RepeatedDNASequences_187 object = new RepeatedDNASequences_187();
        String input;
        String expected;

        // test 1
        input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        expected = "[AAAAACCCCC, CCCCCAAAAA]";
        Common.printResult(input, object.findRepeatedDnaSequences(input).toString(), expected);

        // test 2
        input = "AAAAAAAAAAAAA";
        expected = "[AAAAAAAAAA]";
        Common.printResult(input, object.findRepeatedDnaSequences(input).toString(), expected);

        // test 3
        input = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        expected = "[AAAAACCCCC, CCCCCAAAAA]";
        Common.printResult(input, object.findRepeatedDnaSequences(input).toString(), expected);
    }
}


