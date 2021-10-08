package ltcd_2;

public class StoneGameIII_1406 {

    public String stoneGameIII(int[] stoneValue) {
        int result = helper(0, 1, stoneValue[0], stoneValue);

        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int helper(int i, int tries, int currTotal, int[] stoneValue) {

        if (i >= stoneValue.length) return currTotal;

        int totalAlice = Integer.MIN_VALUE;
        int totalBob = Integer.MIN_VALUE;



        if (tries > 3) { // Only Bob can try
            totalBob = helper(i+1, tries-1, currTotal + stoneValue[i], stoneValue);
        } else if (tries < 1) { // Only Alice can try
            totalAlice = helper(i+1, tries+1, currTotal + stoneValue[i], stoneValue);
        } else {
            totalBob = helper(i+1, tries-1, currTotal + stoneValue[i], stoneValue);
            totalAlice = helper(i+1, tries+1, currTotal + stoneValue[i], stoneValue);
        }

        return currTotal + Math.max(totalAlice, totalBob);
    }

    public static void main(String[] args) {
        StoneGameIII_1406 object = new StoneGameIII_1406();
        int[] input;
        String output;
        String expected;

        // example 1
        input = new int[] {1,2,3,7};
        expected = "Bob";
        output = object.stoneGameIII(input);
        System.out.printf("Output: %5s | Expected: %5s | Result: %5s",output, expected, (output.equals(expected)));
    }

}
