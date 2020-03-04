package Sorting;

import Global.Global;

/**
 * @author: monali on 5/9/2019
 *
 * Complexity
 * Worst:   Theta (N^2)
 * Average: Theta (N logN)
 *
 * Divide: Partition array A[p.....r] into A[p.....q-1] <= A[q] <= A[q+1.....r]
 *
 * Conquer: Sort the two sub arrays
 *
 * Combine: Combine all three
 *
 */

public class QuickSort {

    public static void main(String[] args) {
        int[] input = Global.generateRandomArray(5);
        int[] output = sort(input, 0, input.length-1);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }


    public static int[] sort(int[] A, int p, int r){
        if(p<r){
            int q = partition(A, p, r);
            sort(A, p, q-1);
            sort(A, q+1, r);
        }
        return A;
    }

    public static int partition(int[] A, int p, int r){
        int x = A[r];
        int i = p-1;
        for(int j=p; j<r-1; j++){
            if(A[j] <= x){
                i++;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        i++;
        int temp = A[i];
        A[i] = A[r];
        A[r] = temp;
        return i;
    }
}
