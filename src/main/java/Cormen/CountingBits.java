package Cormen;

public class CountingBits {

    public static void main(String[] args) {
        int[] rslt = countBits(4);
        for(int i=0; i<rslt.length; i++){
            //System.out.println(rslt[i]);
        }
    }

    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++){
            f[i] = f[i >> 1] + (i & 1);
            System.out.println(i + " | " + (i>>1) + " | " + (i&1) + " => "
                    + Integer.toBinaryString(i) + " | "
                    + Integer.toBinaryString(i>>1)
                    + " | " + Integer.toBinaryString(i&1));
        }
        return f;
    }

}
