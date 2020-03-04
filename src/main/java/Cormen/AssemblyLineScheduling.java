package Cormen;

import Global.Global;

import java.util.Arrays;

public class AssemblyLineScheduling extends Global {

    public static void main(String[] args) {

        initializeLogger(AssemblyLineScheduling.class.getName());

        int[] n = {6, 6};
        int[][] a = {
                {7, 9, 3, 4, 8, 4},
                {8, 5, 6, 4, 5, 7}
        };
        int[][] t = {
                {2, 3, 1, 3, 4},
                {2, 1, 2, 2, 1}
        };
        int[] e = {2, 4};
        int[] x = {3, 2};

        int result = fastestWay(a, t, e, x, n);
        System.out.println("Result - " + result);
    }

    public static int fastestWay(int[][] a, int[][] t, int[] e, int[] x, int[] n){
        int rslt = 0;
        int[] f1 = new int[n[0]];
        int[] f2 = new int[n[1]];

        f1[0] = e[0] + a[0][0];
        f2[0] = e[1] + a[1][0];

        logger.debug("Selecting station 1 on line " + (f1[0] < f2[0] ? "1" + ", " + f1[0] : "2" + ", " + f2[0] ));

        for(int j=1; j<n[0]; j++){

            f1[j] = Math.min( (f1[j-1] + a[0][j]), (f2[j-1] + a[0][j] + t[1][j-1]) );
            f2[j] = Math.min( (f2[j-1] + a[1][j]), (f1[j-1] + a[1][j] + t[0][j-1]) );

            logger.debug("Selecting station " + (j+1) + " on line " + (f1[j] < f2[j] ? "1"  + ", " + f1[j] : "2"  + ", " + f2[j]));
        }

        logger.debug("F1 - " + Arrays.toString(f1));
        logger.debug("F2 - " + Arrays.toString(f2));

        rslt = Math.min( f1[n[0]-1]+x[0], f2[n[1]-1]+x[1]);
        return rslt;
    }
}


/*
* f*    = min( (f1[n] + x[1]), (f2[n] + x[2]) )
*
* f1[j] = e[1] + a[1][1]                                                   (if j = 1)
*       = min( (f1[j-1] + a[1][j]), (f2[j-1] + t[2][j-1] + a[1][j]) )      (if j >= 2)
* f2[j] = e[2] + a[2][1]                                                   (if j = 1)
*       = min( (f2[j-1] + a[2][j]), (f1[j-1] + t[1][j-1] + a[2][j]) )      (if j >= 2)
*
* n         = Number of stations in each assembly line
* i         = Line number
* j         = Station number
* S[i][j]   = Jth station on line i
* a[i][j]   = Time required to complete the operation at station S[i][j]
* e[i]      = Entry time for the chassis to enter assembly line i
* x[i]      = Exit time for the completed auto to exit assembly line i
* t[i][j]   = Time to transfer chassis away from station S[i][j] to another station on different line
* f[i][j]   = Set of optimal times for lines i and stations j
* f*        = Fastest way through entire factory
*
* */