package ltcd_2;

import common.Common;

import java.util.Arrays;

public class NonOverlappingInterval_435 {

    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;

        int count = 0;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + ", " + intervals[i][1]);
        }

        int s = intervals[0][0];
        int e = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] <= e) {
                count++;
                s = Math.min(s, intervals[i][0]);
                e = Math.max(e, intervals[i][1]);
            } else {
                s = intervals[i][0];
                e = intervals[i][1];
            }
        }

        return intervals.length - count;
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
