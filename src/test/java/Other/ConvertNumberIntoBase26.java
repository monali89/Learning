package Other;

import org.junit.Assert;
import org.junit.Test;

/**
 * Date: 6/6/2019
 * @author: Monali
 */

public class ConvertNumberIntoBase26 {

    @Test
    public void test01(){
        Assert.assertEquals("B", numberToBase26(2));
    }

    //@Test
    public void test02(){
        Assert.assertEquals("AB", numberToBase26(28));
    }

    public String numberToBase26(int n) {
        StringBuffer buff = new StringBuffer();
        while (n > 0) {
            n--;
            buff.append((char)(n % 26 + 'A'));
            n = n / 26;
        }
        return buff.reverse().toString();
    }

    public int base26ToNumber(String str) {
        int result = 0;
        int pow = 1;
        for(int i = str.length() - 1; i>=0; i--) {
            char s = str.charAt(i);
            s = (char)(s - 'A'+1);
            result += s*pow;
            pow *= 26;
        }
        return result;
    }

}


/*
* Given an excel sheet kind of numbering, convert it into decimal and vice versa
* Copied from: https://github.com/mission-peace/interview/wiki/Misc
*
* */
