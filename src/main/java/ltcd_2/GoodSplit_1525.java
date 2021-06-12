package ltcd_2;

/**
 * @author Monali L on 6/12/2021
 */

public class GoodSplit_1525 {

    public int numSplits(String s) {
        int goodSplits = 0;
        for (int i=1; i < s.length(); i++) {
            String s1 = s.substring(0, i+1);
            String s2 = s.substring(i);
            if (uniqueCount(s1) == uniqueCount(s2)) goodSplits++;
        }
        return goodSplits;
    }

    private int uniqueCount(String s) {
        char[] c = s.toCharArray();
        int orCount = (c[0] - 'a') + 1;
        int xorCount = (c[0] - 'a') + 1;
        System.out.println(c[0] + " | " + orCount + " | " + xorCount);
        for (int i=1; i < c.length; i++) {
            orCount = (orCount | (c[i] - 'a' + 1));
            xorCount = xorCount + (xorCount ^ (c[i] - 'a' + 1));
            System.out.println(c[i] + " | " + orCount + " | " + xorCount);
        }
        return (orCount - xorCount);
    }

    public static void main(String[] args) {

        GoodSplit_1525 object = new GoodSplit_1525();
        String input = "";

        //System.out.println(object.uniqueCount("aacaba"));
        System.out.println('a' | 'a');
        System.out.println('a' ^ 'a');
        System.out.println('a' | 'd');
        System.out.println('a' ^ 'd');

        /*input = "aacaba";
        System.out.println(input + ": " + object.numSplits(input));

        input = "abcd";
        System.out.println(input + ": " + object.numSplits(input));

        input = "aaaaa";
        System.out.println(input + ": " + object.numSplits(input));

        input = "acbadbaada";
        System.out.println(input + ": " + object.numSplits(input));*/
    }
}
