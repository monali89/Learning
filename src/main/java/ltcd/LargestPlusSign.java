package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 7/7/2019
 * @author: Monali
 */

public class LargestPlusSign {

    @Test
    public void test01(){
        Assert.assertEquals(2, orderOfLargestPlusSign(5, new int[][]{{4,2}}));
    }

    int[][] a;

    public int orderOfLargestPlusSign(int N, int[][] mines) {

        int maxOrder = 0;
        a = new int[N][N];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                a[i][j] = 1;
            }
        }
        for(int i=0; i<mines.length; i++){
            a[mines[i][0]][mines[i][1]] = 0;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int temp = helper(i, j);
                maxOrder = Math.max(temp, maxOrder);
                //System.out.println(i + ", " + j + " = " + temp);
            }
        }

        return maxOrder;
    }

    public int helper(int i, int j){
        int k = 0;
        int order = 0;
        while((i+k<a.length && i-k>-1) && (j+k<a.length && j-k>-1)){
            if(a[i][j-k]==1 && a[i][j+k]==1 && a[i-k][j]==1 && a[i+k][j]==1){
                order++;
                k++;
            }
            else break;
        }
        return order;
    }
}

