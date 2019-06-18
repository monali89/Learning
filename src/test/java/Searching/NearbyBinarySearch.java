package Searching;

import org.junit.Assert;

public class NearbyBinarySearch {

    static int[] array;

    public static void main(String[] args) {

        int[] input = {0,5,10,15,20,25,30};
        NearbyBinarySearch obj = new NearbyBinarySearch(input);

        Assert.assertEquals(matchOrLesser(0, 0, input.length-1), 0); // valid & smallest
        Assert.assertEquals(matchOrLesser(30, 0, input.length-1), 6); // valid & greatest
        Assert.assertEquals(matchOrLesser(15, 0, input.length-1), 3); // valid & present
        Assert.assertEquals(matchOrLesser(13, 0, input.length-1), 2); // valid & not present
        Assert.assertEquals(matchOrLesser(-2, 0, input.length-1), -1); // less than smallest
        Assert.assertEquals(matchOrLesser(35, 0, input.length-1), 6); // less than greatest

        Assert.assertEquals(matchOrGreater(0, 0, input.length-1), 0); // valid & smallest
        Assert.assertEquals(matchOrGreater(30, 0, input.length-1), 6); // valid & greatest
        Assert.assertEquals(matchOrGreater(15, 0, input.length-1), 3); // valid & present
        Assert.assertEquals(matchOrGreater(13, 0, input.length-1), 3); // valid & not present
        Assert.assertEquals(matchOrGreater(-2, 0, input.length-1), 0); // less than smallest
        Assert.assertEquals(matchOrGreater(35, 0, input.length-1), -1); // less than greatest
    }

    NearbyBinarySearch(int[] a){
        array = a;
    }

    public static int matchOrLesser(int val, int start, int end){
        if(val < array[0]) return -1;
        if(end-start == 1) return val >= array[end] ? end : start;

        int mid = (start+end)/2;
        if(val < array[mid]) return matchOrLesser(val, start, mid);
        else if(val > array[mid]) return matchOrLesser(val, mid, end);
        return mid;
    }

    public static int matchOrGreater(int val, int start, int end){
        if(val > array[array.length - 1]) return -1;
        if(end-start == 1) return val <= array[start] ? start : end;

        int mid = (start+end)/2;
        if(val < array[mid]) return matchOrGreater(val, start, mid);
        else if(val > array[mid]) return matchOrGreater(val, mid, end);
        return mid;
    }
}
