package ltcd;

/**
 * @author Monali L on 4/28/2020
 */

public class BitwiseAndNumRange {

    public static int rangeBitwiseAnd(int m, int n) {
        int rslt = m;
        for(int i=m; i<=n; i++) {
            if (rslt <= 0 || i <= 0) break;
            System.out.println("DEBUG: For         m - " + Integer.toBinaryString(i) + " (" + i + ")");
            System.out.println("DEBUG: before | rslt - " + Integer.toBinaryString(rslt));
            rslt = rslt & i;
            System.out.println("DEBUG: after  | rslt - " + Integer.toBinaryString(rslt));
            System.out.println();
        }
        return rslt;
    }

    public static void main(String[] args) {

        //System.out.println((1&2));
        //System.out.println(rangeBitwiseAnd(1, 10));
        //System.out.println(rangeBitwiseAnd(0, 2147483647));
        System.out.println(rangeBitwiseAnd(2147483646, 2147483647));
    }

}
