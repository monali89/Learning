package ltcd_2;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class RangeModule_715 {

    TreeMap<Integer, Integer> map;

    public RangeModule_715() {
        map = new TreeMap<Integer, Integer>();
    }

    public void addRange(int left, int right) { // o(n)

        // loop through existing sets to see if the new one overlaps if anyone
        // if yes, create two disjoint sets or add wherever this fits


        for (Integer a: map.keySet()) {
            /*if (isOverlapping(a, new int[] {left, right})) {
                // merge these two sets
            } else {*/
                // add new range maintaining original ascending order
                map.subMap(left, right);
            //}
        }
    }

    public boolean queryRange(int left, int right) {
        return false;
    }

    public void removeRange(int left, int right) { // o(n)

    }

    private boolean isOverlapping(Integer[] a1, int[] a2) {
        return false;
    }

    public static void main(String[] args) {

    }
}
