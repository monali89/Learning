package Hard;

import java.util.Random;

public class CCI_20_3 {

    public static void main(String[] args) {
        int[] a = {45, 89, 27, 93, 02, 95, 16};
        generate(a, 3);
        //getRandomNumberInRange(0, 7);
    }

    public static void generate(int[] a, int m){

        if(m > a.length) return;

        int n = a.length;
        int[] selected = a;
        Random ran = new Random();

        for(int i=0; i<m; i++){
           int index = getRandomNumberInRange(i, n);
            System.out.println(selected[index]);
            selected[i] = selected[index];
        }
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random ran = new Random();
        return ran.nextInt(max-min+1) + min;
    }


}

/*
* Write a method to randomly generate a set of m integers from an array of size n.
* Each element must have equal probability of being chosen.
*
* */
