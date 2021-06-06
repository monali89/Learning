package ltcd_2;

/**
 * @author Monali L on 6/5/2021
 */
public class HouseRobberII_213 {

    private int[] memo;

    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = nums[1];
        helper(nums.length-1, nums);

        for (int i = 0; i < memo.length; i++) {
            System.out.println(memo[i]);
        }

        if (nums.length % 2 == 0) {
            return memo[nums.length - 1];
        } else {
            return memo[nums.length - 2];
        }
    }

    public int helper(int i, int[] nums) {
        if (i < 0) return 0;
        if (memo[i] != 0) return memo[i];
        memo[i] = Math.max( helper(i-1, nums) , nums[i] + helper(i-2, nums) );
        return memo[i];
    }

    public static void main(String[] args) {
        HouseRobberII_213 object = new HouseRobberII_213();
        int[] input = new int[]{1,3,1,3,100};
        System.out.println("Answer: " + object.rob(input)); // 4
    }
}
