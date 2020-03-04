package CCI.ArraysNStrings;

import java.util.Arrays;
import org.junit.Assert;

public class CCI_1_1 {

    public static void main(String[] args) {

        Assert.assertEquals(false, isUniqueChar("afnshcal"));
        Assert.assertEquals(false, isUniqueChar("ahnajisph"));
        Assert.assertEquals(false, isUniqueChar("hsiamdffgap"));
        Assert.assertEquals(true, isUniqueChar("agshjo"));
    }

    public static boolean isUniqueChar(String str){
        char[] a = str.toCharArray();
        Arrays.sort(a);
        for(int i=0; i<a.length-1; i++){
            if(a[i] == a[i+1]){
                return false;
            }
        }
        return true;
    }

}

/*
* Implement an algorithm to determine if a string has all unique characters.
* What if you can not use additional data structures?
* */
