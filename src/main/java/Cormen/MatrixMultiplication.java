package Cormen;

import Global.Global;

public class MatrixMultiplication extends Global {

    private static int[][] m;
    private static int[][] s;

    public static void main(String[] args) {

        initializeLogger(MatrixMultiplication.class.getName());

        int[] matrixDimensions = {30, 35, 15, 5, 10, 20, 25};
        //{40, 20, 30, 10, 30};
        int n = matrixDimensions.length + 1;
        m = new int[n][n];
        s = new int[n][n];

        matrixChainOrder(matrixDimensions);

        for(int i=0; i<m.length; i++){
            for(int j=0; j<m[i].length; j++){
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        for(int i=0; i<s.length; i++){
            for(int j=0; j<s[i].length; j++){
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }

    public static void matrixChainOrder(int[] p) {

        int n = p.length;

        for (int i = 0; i < n; i++) {
            m[i][i] = 0;
        }

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n-L+1; i++) {
                int j = i+L-1;
                if(i < j){
                    logger.debug("For i -> " + i + ", j -> " + j);
                    int k = i;
                    m[i][j] = Integer.MAX_VALUE;
                    while(k < j){
                        int q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];
                        logger.debug("And k -> " + k + ", q is " + q);
                        if(q < m[i][j]){
                            m[i][j] = q;
                            s[i][j] = k;
                        }
                        k++;
                    }
                }
            }
        }
    }
}

/*
 * m[i, j] = 0                                              if i = j
 *         = min { m[i, k] + m[k+1, j] + p[i-1]p[k]p[j] }   if i < j
 *           (for all i<=k<j)
 */