import Global.Global;

import java.util.Arrays;

public class Temp {

    public static void main(String[] args) {

        String str1 = "abc";
        String str2 = "xyz";
        StringBuilder s1 = new StringBuilder(str1);
        StringBuilder s2 = s1.reverse();

        System.out.println(s2);
        System.out.println(s1.equals(s2));

        String s = "012345";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(3, s.length()));

    }

}
