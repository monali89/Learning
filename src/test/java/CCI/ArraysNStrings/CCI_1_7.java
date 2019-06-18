package ArraysNStrings;

import org.junit.Assert;

public class CCI_1_7 {

    public static void main(String[] args) {

        int[][] rslt = setZeros(new int[][]{
                {1,2,3},
                {4,5,6},
                {7,8,0}
        });

        int[][] expected = {
                {1,0,0},
                {0,0,0},
                {0,0,0}
        };

        for (int i = 0; i < rslt.length; i++) {
            for (int j = 0; j < rslt.length; j++) {
                //Assert.assertEquals(expected[i][j], rslt[i][j]);
                System.out.print(rslt[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] setZeros(int[][] a){

        boolean[] row = new boolean[a.length];
        boolean[] col = new boolean[a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(row[i] == true || col[j] == true) a[i][j] = 0;
            }
        }

        return a;
    }
}


/*
* Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
* */