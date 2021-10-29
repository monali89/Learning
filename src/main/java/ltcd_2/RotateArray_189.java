package ltcd_2;

import common.Common;

import java.util.Arrays;

public class RotateArray_189 {

    public void rotate(int[] nums, int k) {

        int len = nums.length;
        int[] rslt = new int[len];

        for (int i = 0; i < len; i++) {

            int newIndex = (i + k) >= len ? (i + k) % len : (i + k);
            rslt[newIndex] = nums[i];
        }

        for (int i = 0; i < len; i++) {
            nums[i] = rslt[i];
        }
    }

    public static void main(String[] args) {
        RotateArray_189 object = new RotateArray_189();
        int[] input;
        int k;

        input = new int[] {1,2,3,4,5,6,7};
        k = 3;
        object.rotate(input, k);
        System.out.println(Common.arrayToString(input));

        input = new int[] {1,2};
        k = 3;
        object.rotate(input, k);
        System.out.println(Common.arrayToString(input));

        input = new int[] {1};
        k = 2;
        object.rotate(input, k);
        System.out.println(Common.arrayToString(input));
    }
}
