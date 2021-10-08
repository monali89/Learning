package ltcd_2;

/**
 * @author Monali L on 10/5/2021
 *
 * Given an array nums with n objects colored red, white, or blue,
 * sort them in-place so that objects of the same color are adjacent,
 * with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */

public class SortColors_75 {

    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length-1);
    }

    private static void quickSort(int[] a, int lo, int hi)
    {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    private static int partition(int[] a, int lo, int hi)
    {
        int i = lo, j = hi+1;
        while (true)
        {
            while (a[++i] < a[lo])
                if (i == hi) break;
            while (a[lo] < a[--j])
                if (j == lo) break;
            if (i >= j) break;
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        int temp = a[lo];
        a[lo] = a[j];
        a[j] = temp;
        return j;
    }

    public static void main(String[] args) {

        SortColors_75 object = new SortColors_75();
        int[] input;

        input = new int[] {2,0,2,1,1,0};
        object.sortColors(input);

        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }
}
