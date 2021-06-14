package ltcd;

import java.util.Stack;

public class InsertInterval_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Stack<Interval> stack = new Stack<Interval>();
        Interval new_int = new Interval(newInterval);
        if (intervals.length <= 0) stack.push(new_int);

        for (int[] interval : intervals) {
            Interval curr = new Interval(interval);
            if (curr.isOverlapping(new_int)) {
                Interval merged = curr.merge(new_int);
                if (stack.isEmpty()) {
                    stack.push(merged);
                    continue;
                }
                Interval prevInt = stack.peek();
                if (prevInt.isOverlapping(merged)) {
                    stack.pop();
                    stack.push(prevInt.merge(merged));
                } else stack.push(merged);
            } else {
                stack.push(curr);
            }
        }

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

    public static void main(String[] args) {

        InsertInterval_57 object = new InsertInterval_57();
        int[][] intervals;
        int[] newInterval;
        int[][] result;

        // example 1
        intervals =  new int[][] {{1,3},{6,9}};
        newInterval = new int[] {2, 5};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[1,5],[6,9]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();

        // example 2
        intervals =  new int[][] {{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        newInterval = new int[] {4, 8};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[1,2],[3,10],[12,16]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();

        // example 3
        intervals =  new int[][] {};
        newInterval = new int[] {5, 7};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[5,7]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();

        // example 4
        intervals =  new int[][] {{1,5}};
        newInterval = new int[] {2, 3};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[1, 5]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();

        // example 5
        intervals =  new int[][] {{1, 5}};
        newInterval = new int[] {2, 7};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[1,7]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();

        // after submit test
        intervals =  new int[][] {{1, 5}};
        newInterval = new int[] {6, 8};
        result = object.insert(intervals, newInterval);
        System.out.println("Expected: [[1,5],[6,8]]");
        for (int[] ints : result)
            System.out.println(ints[0] + ", " + ints[1]);
        System.out.println();
    }
}
