package ltcd_2;

import common.Common;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Monali L on 10/5/2021
 */

public class MergeIntervals_56 {

    public int[][] merge(int[][] intervals) {

        Stack<int[]> stack = new Stack<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        int idx = 0;

        while (idx < intervals.length) {

            if (stack.isEmpty()) {
                stack.push(intervals[idx]);
                // prev = intervals[idx];
            } else {
                int[] prev = stack.peek();
                int[] curr = intervals[idx];

                if (curr[0] <= prev[1]) {
                    int[] merged = new int[2];
                    merged[0] = Math.min(curr[0], prev[0]);
                    merged[1] = Math.max(curr[1], prev[1]);
                    stack.pop();
                    stack.push(merged);
                } else {
                    stack.push(curr);
                }
            }
            idx++;
        }

        int[][] result = new int[stack.size()][2];

        for (int i = stack.size()-1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    public int[][] merge_old(int[][] intervals) {

        // sort the intervals
        quickSort(intervals, 0, intervals.length-1);

        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        Stack<Interval> stack = new Stack<Interval>();

        int ctr = 0;

        while (ctr < intervals.length) {
            if (stack.isEmpty()) {
                stack.push(new Interval(intervals[ctr]));
            } else {
                Interval top = stack.peek();
                Interval curr = new Interval(intervals[ctr]);
                if (top.isOverlapping(curr)) {
                    Interval merged = top.merge(curr);
                    stack.pop();
                    stack.push(merged);
                } else {
                    stack.push(curr);
                }
            }
            ctr++;
        }

        int[][] rslt = new int[stack.size()][2];
        for (int i=stack.size()-1; i>=0; i--) {
            rslt[i] = stack.pop().getArray();
        }

        System.out.println("Merged");
        for (int[] interval : rslt) {
            System.out.println(interval[0] + " " + interval[1]);
        }

        return rslt;
    }

    private static void quickSort(int[][] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(int[][] a, int lo, int hi) {
        int i = lo, j = hi+1;
        while (true)
        {
            while (a[++i][0] < a[lo][0])
                if (i == hi) break;
            while (a[lo][0] < a[--j][0])
                if (j == lo) break;
            if (i >= j) break;
            int[] temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int[] temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    static class Interval {
        int s;
        int e;
        public Interval(int[] a) {
            s = a[0];
            e = a[1];
        }
        public boolean isOverlapping(Interval t) {
            if (s <= t.s) {
                return s <= t.e && t.s <= e;
            } else {
                return t.s <= e && s <= t.e;
            }
        }
        public Interval merge(Interval t) {
            int[] a = new int[2];
            a[0] = Math.min(s, t.s);
            a[1] = Math.max(e, t.e);
            return new Interval(a);
        }
        public int[] getArray() {
            return new int[]{s, e};
        }
    }

    public static void main(String[] args) {
        MergeIntervals_56 object = new MergeIntervals_56();
        int[][] input;
        int[][] output;

        /*input = new int[][] {{1,4},{0,5}};
        output = object.merge(input);
        Common.print2DIntArray(output);*/

        input = new int[][] {{1,3},{2,6},{8,10},{15,18}};
        output = object.merge(input);
        Common.print2DIntArray(output);
    }

}
