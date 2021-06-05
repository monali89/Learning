package ltcd;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author: monali on 5/11/2019
 */
public class RemoveDuplicateLetters {

    @Test
    public void test01(){
        Assert.assertEquals("abc", removeDuplicateLetters("bcabc"));
        Assert.assertEquals("acdb", removeDuplicateLetters("cbacdcbc"));
    }

    public static String removeDuplicateLetters(String s) {
        Set<Character> set = new HashSet<Character>();
        String rslt = "";
        for(int i=0; i<s.length(); i++){
            if(set.contains(s.charAt(i))) continue;
            set.add(s.charAt(i));
            rslt = rslt + s.charAt(i);
        }
        return rslt;
    }
}
