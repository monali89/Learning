package ltcd_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSmallNumsAfterSelf_315 {

    private Map<Integer, Integer> map;

    public List<Integer> countSmaller(int[] nums) {
        map = new HashMap<Integer, Integer>();

        mergeSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        return null;
    }

    private void merge(int[] nums, int l, int m, int r) {

        int[] left = new int[m - l + 1];
        int[] right = new int[r - m];

        for (int i = 0; i < left.length; ++i) {
            left[i] = nums[l + i];
        }

        for (int i = 0; i < right.length; ++i) {
            right[i] = nums[m + 1 + i];
        }

        int lIdx = 0, rIdx = 0, mIdx = l;

        while (lIdx < left.length && rIdx < right.length) {
            if (left[lIdx] <= right[rIdx]) {
                nums[mIdx] = left[lIdx++];
            } else {
                nums[mIdx] = right[rIdx++];
            }
            mIdx++;
        }

        while (lIdx < left.length) {
            nums[mIdx++] = left[lIdx++];
        }

        while (rIdx < right.length) {
            nums[mIdx++] = right[rIdx++];
        }

    }

    private void mergeSort(int[] nums, int l, int r) {

        if (l < 0 || r < 0 || l > r) return;
        if (l == r) return;

        int m = l+ (r-l)/2;
        mergeSort(nums, l, m);
        mergeSort(nums, m+1, r);
        merge(nums, l, m, r);
    }

    public static void main(String[] args) {

        CountSmallNumsAfterSelf_315 object = new CountSmallNumsAfterSelf_315();
        int[] input;
        List<Integer> output;
        String expected;

        // example 1
        input = new int[] {5,2,6,1};
        expected = "2,1,1,0";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        // example 2
        /*input = new int[] {-1};
        expected = "0";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        // example 3
        input = new int[] {-1, -1};
        expected = "0";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);*/
    }

}
