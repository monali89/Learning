package Sorting;

/**
 * @author: monali on 5/9/2019
 */

/*
 * Complexity: O(n logn)
 * In place sort, heap data structure, min/max heap properties,
 * MAX-HEAPIFY: Runs in O(logN) time, key to maintaining max-heap property
 * BUILD-MAX-HEAP: Runs in linear time, produces max heap from an unordered array
 * HEAPSORT: Runs in O(N logN) time, sorts an array in place
 * MAX-HEAP-INSERT, HEAP-EXTRACT-MAX, HEAP-INCREASE-KEY, HEAP-MAXIMUM: Run in O(logN) time,
 *                               allow the heap data structure to be used as priority queue
 * */

public class HeapSort {

    int[] heapArray;

    public int[] HeapSort(int[] array){
        return null;
    }

    public void maxHeapify(){

    }

    public int getParent(int index){
        return heapArray[index/2];
    }

    public int getLeftChild(int index){
        return heapArray[2*index];
    }

    public int getRightChild(int index){
        return heapArray[2*index + 1];
    }


}
