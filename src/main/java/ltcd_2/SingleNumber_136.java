package ltcd_2;

/**
 * @author Monali L on 10/4/2021
 *
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space
 */

public class SingleNumber_136 {

    public int singleNumber(int[] nums) {

        int total = nums[0];
        int result = -1;

        for (int i = 1; i < nums.length; i++) {
            total = total ^ nums[i];
        }

        System.out.println(total);

        return result;
    }

    public static void main(String[] args) {

        SingleNumber_136 object = new SingleNumber_136();
        int[] input;

        input = new int[] {4,1,2,1,2};
        System.out.println(object.singleNumber(input));
    }
}
