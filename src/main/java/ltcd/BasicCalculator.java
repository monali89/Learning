package ltcd;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Date: 5/13/2019
 * @author: Monali
 */

public class BasicCalculator {

    @Test
    public void test01(){
        Assert.assertEquals(23, basicCalculator("(1 + (4 + 5 + 2) - 3) + (6 + 8)"));
    }

    @Test
    public void test02(){
        Assert.assertEquals(20, basicCalculator("(32 - 12)"));
    }

    @Test
    public void test03(){
        Assert.assertEquals(0, basicCalculator(""));
    }

    @Test
    public void test04(){
        Assert.assertEquals(0, basicCalculator(""));
    }

    @Test
    public void test05(){
        Assert.assertEquals(0, basicCalculator(""));
    }

    public int basicCalculator(String s){

        Stack<Integer> stack = new Stack<Integer>();
        int sign = 1;
        boolean pis = false;
        int rslt = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ' || c == '(' || c == ')') {
                pis = true;
                continue;
            }
            if(c == '+'){
                pis = true;
                sign = 1;
            }
            if(c == '-'){
                pis = true;
                sign = -1;
            }
            if(c >= '0' || c <= '9'){
                if(pis){
                    stack.push(sign * Integer.valueOf(c));
                    sign = 1;
                }else{
                    int p = stack.isEmpty() ? 0 : stack.pop();
                    stack.push(p*10 + Integer.valueOf(c));
                }
                pis = false;
            }
        }
        System.out.println(stack.toString());

        while(!stack.isEmpty()){
            rslt = rslt + stack.pop();
        }

        return rslt;
    }

}








