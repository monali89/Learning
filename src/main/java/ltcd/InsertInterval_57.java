package ltcd;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class InsertInterval_57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        Stack<Interval> stack1 = new Stack<Interval>();
        Stack<Interval> stack2 = new Stack<Interval>();
        Interval newInt = new Interval(newInterval);

        stack2.push(newInt);

        // insert all intervals along with new interval
        // onto stack 1 in ascending order of start time
        int i = intervals.length-1;
        while (i > -1) {
            if (intervals[i][0] >= newInterval[0] || stack2.isEmpty()) {
                stack1.push(new Interval(intervals[i]));
                i--;
            } else {
                stack1.push(stack2.pop());
            }
        }
        if (!stack2.isEmpty()) stack1.push(stack2.pop());

        // Use two stacks - stack1 which will have the initial interval array
        // along with new interval merged in ascending order,
        // stack2 where we will be pushing the merged intervals.
        // Take top elements from both stack, if they can be merged,
        // push the merged interval to stack2 or push both intervals to stack2

        while (!stack1.isEmpty()) {
            Interval old = stack1.pop();
            Interval fresh = stack2.isEmpty() ? null : stack2.pop();

            if (fresh == null) {
                stack2.push(old);
            } else {
                if (old.isOverlapping(fresh)) {
                    Interval merged = old.merge(fresh);
                    stack2.push(merged);
                } else {
                    stack2.push(fresh);
                    stack2.push(old);
                }
            }
        }

        int[][] result = new int[stack2.size()][2];
        for (int j = stack2.size() - 1; j >= 0; j--) {
            result[j] = stack2.pop().getArray();
        }
        return result;
    }

    public int[][] insert_2(int[][] intervals, int[] newInterval) {

        Stack<Interval> stack = new Stack<Interval>();
        Interval newInt = new Interval(newInterval);

        if (intervals.length <= 0) stack.push(newInt);

        for (int[] interval : intervals) {
            Interval curr = new Interval(interval);
            if (curr.isOverlapping(newInt)) {
                Interval merged = curr.merge(newInt);
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
