package ltcd_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSmallNumsAfterSelf_315 {

    private Map<Integer, Integer> counts;

    public List<Integer> countSmaller(int[] nums) {

        counts = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            counts.put(i, 0);
        }

        mergeSort(nums, 0, nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return new ArrayList<Integer>(counts.values());
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
                for (int i = lIdx; i < left.length; i++) {
                    counts.put(l + i, counts.get(l + i)+1);
                }
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
        /*input = new int[] {5,2,6,1};
        expected = "[2,1,1,0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        // example 2
        input = new int[] {-1};
        expected = "[0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        // example 3
        input = new int[] {-1, -1};
        expected = "[0, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        input = new int[] {1, 2, 3, 4, 5};
        expected = "[0, 0, 0, 0, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        input = new int[] {5, 4, 3, 2, 1, -1};
        expected = "[5, 4, 3, 2, 1, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        input = new int[] {11, 11, 11, 11, 11, 11};
        expected = "[0, 0, 0, 0, 0, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);

        // after submit test 1
        input = new int[] {0, 2, 1};
        expected = "[0, 1, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);*/

        input = new int[] {2, 0, 1};
        expected = "[2, 0, 0]";
        output = object.countSmaller(input);
        System.out.printf("Output: %s | Expected: %s\n\n", output, expected);
    }

}
