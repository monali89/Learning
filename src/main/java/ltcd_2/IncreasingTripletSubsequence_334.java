package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.List;

public class IncreasingTripletSubsequence_334 {

    public boolean increasingTriplet(int[] nums) {

        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for (int num : nums) {

            if (num < firstMin) firstMin = num;
            else if (num < secMin) secMin = num;
            else if (num > secMin) return true;

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

        input = new int[] {5,4,3,2,1};
        output = obj.increasingTriplet(input);
        expected = false;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {2,1,5,0,4,6};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {1, 1, 1};
        output = obj.increasingTriplet(input);
        expected = false;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {20,100,10,12,5,13};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);

        input = new int[] {1,5,0,4,1,3};
        output = obj.increasingTriplet(input);
        expected = true;
        Common.printResult(Common.arrayToString(input), output, expected);

    }
}
