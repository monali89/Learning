package CCI.ArraysNStrings;

import org.junit.Assert;

public class CCI_1_8 {

    public static void main(String[] args) {

        Assert.assertEquals(true, isSubstring("impossible", "sibl"));
        Assert.assertEquals(true, isSubstring("immediately", "el"));
        Assert.assertEquals(true, isSubstring("Circumlocution", "cut"));

        Assert.assertEquals(true, isRotation("waterbottle", "erbottlewat"));
        Assert.assertEquals(true, isRotation("waterbottle", "ewaterbottl"));
        Assert.assertEquals(false, isRotation("waterbottle", "eerbottlewat"));

    }

    public static boolean isRotation(String s1, String s2){

        return isSubstring(s1 + s2, s2);
    }

    public static boolean isSubstring(String s1, String s2){

        int i = 0; // for s1
        int j = 0; // for s2

        if(s2.length() > s1.length()) return false;
        while(i < s1.length() && j < s2.length()){
            while(i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            if(j == s2.length()) return true;
            else if(j > 0){
                j = 0;
                i--;
            }
            i++;
        }
        return j == s2.length();
    }

}


/*
* Assume you have a method isSubstring which checks if one word is a substring of another.
* Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring
* (i.e., “waterbottle” is a rotation of “erbottlewat”).
* */