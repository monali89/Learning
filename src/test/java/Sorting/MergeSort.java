package Sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Date: 5/9/2019
 * @author: monali
 */

public class MergeSort {

    @Test
    public void test01(){
        int[] expected = {23,6,12,89,1,5,27,9};
        int[] actual = {23,6,12,89,1,5,27,9};
        Arrays.sort(expected);
        mergeSort(actual, 0, actual.length-1);
        Assert.assertArrayEquals(expected, actual) ;
    }


    public void mergeSort(int[] A, int p, int r){
        if(p < r){
            int q = (p + r)/2;
            mergeSort(A, p, q);
            mergeSort(A, q+1, r);
            merge(A, p, q, r);
        }
    }

    public void merge(int[] A, int p, int q, int r){
        int[] left = new int[q - p + 1];
        int[] right = new int[r - q];
        for (int i = 0; i < left.length; i++) {
            left[i] = A[p + i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = A[q + i + 1];
        }
        int i = 0, j = 0, k = p;
        while(i < left.length && j < right.length){
            if(left[i] <= right[j]){
                A[k] = left[i++];
            }else{
                A[k] = right[j++];
            }
            k++;
        }
        while(i < left.length){
            A[k] = left[i++];
            k++;
        }
        while(j < right.length){
            A[k] = right[j++];
            k++;
        }
    }

}
