package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {

        List<List<Integer>> ll = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            if (ll.isEmpty()) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(nums[i]);
                ll.add(l);
            } else {

                boolean added = false;

                for (List<Integer> l: ll) {
                    if (l.get(l.size() - 1) < nums[i]) {
                        l.add(nums[i]);
                        added = true;
                        if (l.size() == 3) return true;
                    }
                }

                if (!added) {
                    List<Integer> newl = new ArrayList<Integer>();
                    newl.add(nums[i]);
                    ll.add(newl);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        IncreasingTripletSubsequence_334 obj = new IncreasingTripletSubsequence_334();
        int[] input;
        boolean expected;
        boolean output;

        // test 1
        input = new int[] {1,2,3,4,5};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

        // test 1
        input = new int[] {5,4,3,2,1};
        output = obj.increasingTriplet(input);
        expected = false;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

        // test 1
        input = new int[] {2,1,5,0,4,6};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

        input = new int[] {1, 1, 1};
        output = obj.increasingTriplet(input);
        expected = false;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

        input = new int[] {20,100,10,12,5,13};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

        input = new int[] {1,5,0,4,1,3};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);
        //System.out.println("Input: " + Common.arrayToString(input) + " | Output: " + output + " | Expected: " + expected);

    }
}
