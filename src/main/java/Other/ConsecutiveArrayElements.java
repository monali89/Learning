package Other;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Date: 6/7/2019
 * @author: Monali
 */

public class ConsecutiveArrayElements {

    @Test
    public void test01(){
        Assert.assertEquals(true, checkIfConsecutive(new int[]{5, 2, 3, 1, 4}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(true, checkIfConsecutive(new int[]{83, 78, 80, 81, 79, 82}));
    }

    @Test
    public void test03(){
        Assert.assertEquals(false, checkIfConsecutive(new int[]{34, 23, 52, 12, 3}));
    }

    @Test
    public void test04(){
        Assert.assertEquals(false, checkIfConsecutive(new int[]{7, 6, 5, 5, 3, 4}));
    }

    public boolean checkIfConsecutive(int[] a){
        Set<Integer> set = new HashSet<Integer>();
        int start = Integer.MAX_VALUE;
        for(int i=0; i<a.length; i++){
            start = Math.min(start, a[i]);
            set.add(a[i]);
        }
        for(int i=1; i<a.length; i++){
            if(set.contains(++start)) continue;
            return false;
        }
        return true;
    }


}
