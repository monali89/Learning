package ltcd;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Monali L on 4/28/2020
 */

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        int rem = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            set.add(num);
            rem = rem ^ num;
        }
        for (int num: nums) {
            if (set.contains(rem ^ num)) {
                int[] a = {num, rem^num};
                return a;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] ip = {1,2,1,3,2,5};
        int[] op = singleNumber(ip);
        for (int value : op) {
            System.out.println(value);
        }
    }

    /*
    * ones - 2
    * twos - 1, 2, 1 => .. => 3, 2
    * */

}
