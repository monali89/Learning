package ltcd;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 7/9/2019
 * @author: Monali
 */

public class CompareVersionNumbers {

    @Test
    public void test01(){
        Assert.assertEquals(-1, compareVersion("0.1", "1.1"));
    }

    public int compareVersion(String version1, String version2) {

        String[] v1 = version1.split(".");
        String[] v2 = version2.split(".");

        int ctr = 0;
        //System.out.println(version1.split("."));

        while(ctr < v1.length && ctr < v2.length){
            System.out.println(Integer.parseInt(v1[ctr]) + " | " + Integer.parseInt(v2[ctr]));
            if(Integer.parseInt(v1[ctr]) < Integer.parseInt(v2[ctr])) return -1;
            ctr++;
        }
        return 1;
    }

}
