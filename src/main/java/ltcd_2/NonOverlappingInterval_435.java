package ltcd_2;

import java.util.Arrays;
import java.util.Stack;

public class NonOverlappingInterval_435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length <= 1) return 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;

        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // is overlapping
            if (prevEnd > curr[0]) {
                count++;
                prevEnd = Math.min(prevEnd, curr[1]);
            } else {
                prevEnd = curr[1];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        NonOverlappingInterval_435 object = new NonOverlappingInterval_435();
        int[][] input;
        int output;

        // test 1
        input = new int[][] {{1,2},{2,3},{3,4},{1,3}};
        output = object.eraseOverlapIntervals(input);
        System.out.println(output);
        System.out.println();

        // test 2
        input = new int[][] {{1,2},{1,2},{1,2}};
        output = object.eraseOverlapIntervals(input);
        System.out.println(output);
        System.out.println();
    }
}

/*
* Concept is same max intervals which can be merged
* So, first sort the intervals by end time
* Then find the number of intervals which can be merged
* This minus total number of intervals should give the answer
*
* Why sort by end time?
*
* */
