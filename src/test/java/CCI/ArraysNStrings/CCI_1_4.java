package ArraysNStrings;

import org.junit.Assert;

import java.util.Arrays;

public class CCI_1_4 {

    public static void main(String[] args) {
        Assert.assertEquals(true, isAnagram("listen".toCharArray(), "silent".toCharArray()));
        Assert.assertEquals(true, isAnagram("elvis".toCharArray(), "lives".toCharArray()));
        Assert.assertEquals(false, isAnagram("abc".toCharArray(), "xyz".toCharArray()));
    }

    public static boolean isAnagram(char[] s1, char[] s2){

        if(s1.length != s2.length) return false;
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0; i<s1.length; i++) if(s1[i] != s2[i]) return false;
        return true;
    }
}


/*
* Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
* NOTE: One or two additional variables are fine. An extra copy of the array is not.
* FOLLOW UP - Write the test cases for this method.
* */