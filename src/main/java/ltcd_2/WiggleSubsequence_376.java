package ltcd_2;

public class WiggleSubsequence_376 {

    public int wiggleMaxLength(int[] nums) {

        if (nums.length == 0) return 0;

        int[] pos = new int[nums.length];
        int[] neg = new int[nums.length];

        pos[0] = 1;
        neg[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int val = nums[i-1] - nums[i];
            if (val < 0) {
                neg[i] = pos[i-1] + 1;
                pos[i] = pos[i-1];
            } else if (val > 0) {
                pos[i] = neg[i-1] + 1;
                neg[i] = neg[i-1];
            } else {
                neg[i] = neg[i-1];
                pos[i] = pos[i-1];
            }
        }

        return Math.max(pos[nums.length - 1], neg[nums.length - 1]);
    }

    public static void main(String[] args) {
        WiggleSubsequence_376 object = new WiggleSubsequence_376();

        System.out.println(object.wiggleMaxLength(new int[] {1,7,4,9,2,5}));

        System.out.println(object.wiggleMaxLength(new int[] {1,17,5,10,13,15,10,5,16,8}));
    }
}
