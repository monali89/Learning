package LeetCode;

import Global.Global;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author: monali on 5/11/2019
 */
public class MedianSortedArrays {

    @Test
    public void test01(){

        int[] a1 = Global.generateRandomArray(5);
        int[] a2 = Global.generateRandomArray(5);

        Arrays.sort(a1);
        Arrays.sort(a2);

        /*for (int i = 0; i < 5; i++) System.out.print(a1[i] + " ");
        System.out.println();
        for (int i = 0; i < 5; i++) System.out.print(a2[i] + " ");
        System.out.println();*/

        double expected = mergeAndGetMedian(a1, a2);
        double actual = getMedian(a1, a2);

        //System.out.println("Median: " + expected);

        Assert.assertEquals(expected, actual, 0);

    }

    public static double getMedian(int[] nums1, int[] nums2){

        int N1 = nums1.length;
        int N2 = nums2.length;

        if(N1 < N2) return getMedian(nums2, nums2); // First array needs to be the longer one

        int lo = 0;
        int hi = N2*2; // We want to cut the smaller array at the last index considering it is the overall mid point

        while(lo <= hi){
            int mid2 = (lo + hi)/2; // same as above explanation
            int mid1 = N1 + N2 - mid2; // Why???

            double L1 = nums1[(mid1-1)/2];
            double L2 = nums2[(mid2-1)/2];
            double R1 = nums1[(mid1)/2];
            double R2 = nums2[(mid2)/2];

            if(L1 > R2) lo = mid2 + 1; // Why??
            else if(L2 > R1) hi = mid2 - 1; // Why??
            else return (Math.max(L1, L2) + Math.min(R1, R2))/2;
        }
        return -1;
    }

    public static double mergeAndGetMedian(int[] nums1, int[] nums2){

        int[] nums3 = new int[nums1.length + nums2.length];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        while(i3 < nums3.length && i1 < nums1.length && i2 < nums2.length){
            nums3[i3] = nums1[i1] < nums2[i2] ? nums1[i1++] : nums2[i2++];
            i3++;
        }

        while(i3 < nums3.length && i1 < nums1.length){
            nums3[i3] = nums1[i1++];
            i3++;
        }

        while(i3 < nums3.length && i2 < nums2.length){
            nums3[i3] = nums2[i2++];
            i3++;
        }

        double L = nums3[(nums3.length - 1)/2];
        double R = nums3[(nums3.length)/2];
        return (L+R)/2;
    }

}


/*
* 4
* There are two sorted arrays nums1 and nums2 of size m and n respectively.
* Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
* You may assume nums1 and nums2 cannot be both empty.
*
* Read this for understanding:
* https://leetcode.com/problems/median-of-two-sorted-arrays/discuss/2471/Very-concise-O(log(min(MN)))-iterative-solution-with-detailed-explanation
*
* */