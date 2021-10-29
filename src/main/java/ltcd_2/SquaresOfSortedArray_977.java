package ltcd_2;

import common.Common;

public class SquaresOfSortedArray_977 {

    public int[] sortedSquares(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] < 0 ? -1 * nums[i] : nums[i];
        }

        quickSort(result, 0, result.length-1);

        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * result[i];
        }

        return result;
    }

    private void quickSort(int[] arr, int lo, int hi) {
        if (lo > hi) return;
        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot-1);
        quickSort(arr, pivot+1, hi);
    }

    private int partition(int[] arr, int lo, int hi) {

        int pivotVal = arr[hi];
        int pivotIndex = lo-1;

        for (int i = lo; i < hi; i++) {
            if (arr[i] <= pivotVal) {
                pivotIndex++;
                int temp = arr[i];
                arr[i] = arr[pivotIndex];
                arr[pivotIndex] = temp;
            }
        }

        int temp = arr[pivotIndex+1];
        arr[pivotIndex+1] = arr[hi];
        arr[hi] = temp;

        return pivotIndex+1;
    }

    public static void main(String[] args) {

        SquaresOfSortedArray_977 object = new SquaresOfSortedArray_977();
        int[] input;
        int[] output;
        String expected;

        input = new int[] {-4,-1,0,3,10};
        output = object.sortedSquares(input);
        expected = "0,1,9,16,100";
        Common.printResult(Common.arrayToString(input), Common.arrayToString(output), expected);

        input = new int[] {12,18,15,21,19,30,4,17};
        output = object.sortedSquares(input);
        expected = "[0,1,9,16,100]";
        Common.printResult(Common.arrayToString(input), Common.arrayToString(output), expected);
    }
}
