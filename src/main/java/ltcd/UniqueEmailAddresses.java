package ltcd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: monali on 5/7/2019
 */

public class UniqueEmailAddresses {

    @Test
    public void test01(){
        Assert.assertEquals(3,numUniqueEmails(new String[]{"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    @Test
    public void test02(){
        Assert.assertEquals(2,numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();
        for(int i=0; i<emails.length; i++){
            set.add(parse(emails[i]));
        }
        return set.size();
    }

    public static String parse(String email){
        String[] s = email.split("@");
        String[] temp = s[0].split("\\+");
        temp[0] = temp[0].replace(".", "");
        return temp[0] + "@" + s[1];
    }
}


/*
*
* */