package Cormen;

import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decodeString("3[abc]"));
    }

    public static String decodeString(String s){
        char[] a = s.toCharArray();
        int ctr = 0;
        Stack<Character> stack = new Stack<Character>();
        while(ctr < a.length){
            if(a[ctr] >= '1' || a[ctr] <= '9'){
                stack.push(a[ctr++]);
                while(a[ctr] != ']' && ctr<a.length) stack.push(a[ctr++]);
                stack.push(a[ctr]);
            }
            if(a[ctr] == ']'){
                String temp = "";
                while(ctr<a.length && a[ctr] != '[' && !stack.isEmpty()){
                    temp = temp + stack.pop();
                    ctr++;
                }
                temp = helper(stack.pop(), temp);
                char[] temp_a = temp.toCharArray();
                for(int j=0; j<temp_a.length; j++){
                    stack.push(temp_a[j]);
                }
            }
        }
        String rslt = "";
        while(!stack.isEmpty()){
            rslt = rslt + stack.pop();
        }
        return rslt;
    }

    public static String helper(int n, String s){

        String rslt = "";
        for(int i=0; i<n; i++){
            rslt = rslt + s;
        }
        return rslt;
    }


}
