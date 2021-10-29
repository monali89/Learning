package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PartitionLabels_763 {

    public List<Integer> partitionLabels(String s) {

        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, map.get(s.charAt(i)));
            if (end == i) {
                result.add(end - start + 1);
                start = end + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        PartitionLabels_763 object = new PartitionLabels_763();
        String input = "";
        String expected = "";
        String output = "";

        input = "ababcbacadefegdehijhklij";
        expected = "[9, 7, 8]";
        output = object.partitionLabels(input).toString();
        Common.printResult(input, output, expected);

        input = "eccbbbbdec";
        expected = "[10]";
        output = object.partitionLabels(input).toString();
        Common.printResult(input, output, expected);
    }
}
