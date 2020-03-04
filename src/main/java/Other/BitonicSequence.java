package Other;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 6/9/2019
 * @author: Monali
 */

public class BitonicSequence {

    @Test
    public void test01(){
        Assert.assertEquals(5, getLongestBitonicSequence(new int[]{1,2,3,2,1}));
    }

    public int getLongestBitonicSequence(int[] a){

        boolean isInc = true;
        int prev = a[0];
        int size = 1;

        for (int i = 1; i < a.length; i++) {
            if(isInc){
                if(prev < a[i]){
                    size++;
                    prev = a[i];
                }else{
                    isInc = false;
                }
            }else{

            }
        }

        return 0;
    }
}
