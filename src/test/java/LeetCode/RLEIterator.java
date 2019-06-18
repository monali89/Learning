package LeetCode;

import org.junit.Assert;

public class RLEIterator {

    public static void main(String[] args) {

        int[] input = {811,903,310,730,899,684,472,100,434,611};
        RLEIterator obj = new RLEIterator(input);

        Assert.assertEquals(next(358), 903);
        Assert.assertEquals(next(345), 903);
        Assert.assertEquals(next(154), 730);
        Assert.assertEquals(next(265), 684);
        Assert.assertEquals(next(73), 684);
        Assert.assertEquals(next(220), 684);
        Assert.assertEquals(next(138), 684);
        Assert.assertEquals(next(4), 684);
        Assert.assertEquals(next(170), 684);
        Assert.assertEquals(next(88), 684);
    }

    static int INDEX;
    static int[] arr;

    public RLEIterator(int[] A) {
        INDEX = 0;
        arr = A;
    }

    public static int next(int n) {

        /*for(int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
        System.out.println();*/

        while(INDEX < arr.length-1){
            //System.out.println("INDEX-" + INDEX + ", arr[INDEX]-" + arr[INDEX] + ", n-" + n);
            if(arr[INDEX] >= n){
                arr[INDEX] = arr[INDEX] - n;
                /*for(int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
                System.out.println();
                System.out.println();*/
                return arr[INDEX+1];
            }
            else{
                n = n - arr[INDEX];
                //arr[INDEX] = 0;
                INDEX = INDEX+2;
            }
        }
        /*for(int k=0; k<arr.length; k++) System.out.print(arr[k] + " ");
        System.out.println();
        System.out.println();*/
        return -1;
    }
}
