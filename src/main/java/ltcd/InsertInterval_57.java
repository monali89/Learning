package ltcd;

import java.util.Stack;

/**
 * @author Monali L on 5/4/2020
 * Problem (57): Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {

    public static void main(String[] args) {
        int[][] intervals =  {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[] newInterval = {4, 8};

        int[][] result = insert(intervals, newInterval);
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);

        /*Interval n1 = new Interval(new int[]{12, 16});
        Interval n2 = new Interval(new int[]{4, 8});
        System.out.println(n1.isOverlapping(n2));*/

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        Stack<Interval> stack = new Stack<Interval>();
        Interval new_int = new Interval(newInterval);
        stack.push(new_int);

        for (int i=0; i<intervals.length; i++) {
            Interval curr = new Interval(intervals[i]);
            Interval prevInt = stack.peek();
            System.out.println("DEBUG: curr - " + curr.toString() + ", prevInt - " + prevInt.toString());
            if (curr.isOverlapping(prevInt)) {
                Interval merged = curr.merge(prevInt);
                System.out.println("DEBUG: Is overlapping, merged - " + merged);
                stack.pop();
                stack.push(merged);
            } else {
                stack.push(curr);
            }

            /*System.out.println("DEBUG: curr - " + curr.toString());
            if (curr.isOverlapping(new_int)) {
                System.out.println("DEBUG: Is overlapping with new_int");
                Interval merged = curr.merge(new_int);
                System.out.println("DEBUG: merged - " + merged.toString());
                if (stack.isEmpty()) {
                    System.out.println("DEBUG: Stack empty so pushing merged");
                    stack.push(merged);
                    continue;
                }
                Interval prevInt = stack.peek();
                if (prevInt.isOverlapping(merged)) {
                    System.out.println("DEBUG: Prev " + prevInt.toString() + " overlaps with merged");
                    stack.pop();
                    stack.push(prevInt.merge(merged));
                } else stack.push(merged);
            } else {
                stack.push(curr);
            }*/
            System.out.println("DEBUG: stack - " + stack);
            System.out.println();
        }
        System.out.println();

        int[][] rslt = new int[stack.size()][2];
        for (int i=stack.size()-1; i>=0; i--) {
            rslt[i] = stack.pop().getArray();
        }
        return rslt;

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
        public String toString() {
            return "[" + s + ", " + e + "]";
        }
    }

}
