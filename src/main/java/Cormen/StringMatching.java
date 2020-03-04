package Cormen;

import org.junit.Assert;

/*
* Algorithm                   Processing Time     Matching Time
* Naive                       0                   O((n - m + 1) * m)
* Rabin Karp                  theta(m)            O((n - m + 1) * m)
* Finite automation           O(m)                theta(n)
* KMP                         theta(m)            theta(n)
* */

public class StringMatching {

    public static void main(String[] args) {
        Assert.assertEquals(true, RabinKarp("dabc", "abc"));
        //Assert.assertEquals(true, RabinKarp("abdcefabcbacb", "abc"));
        //Assert.assertEquals(false, RabinKarp("abdcefaacbacb", "abc"));
    }

    public static boolean RabinKarp(String string, String pattern){

        int m = pattern.length();
        int n = string.length();
        double ph = 0, th = 0;
        int pow = 0;

        // Pre-processing
        for (int i = 0; i < m; i++) {
            ph = ph + pattern.charAt(i) * Math.pow(3, pow);
            th = th + string.charAt(i) * Math.pow(3, pow++);
        }
        pow--;

        for (int i = 1; i <= n-m; i++) {
            if(ph == th){
                if(pattern.equals(string.substring(i-1, m))){
                    System.out.println("Matched at - " + string.substring(i-1, m));
                    return true;
                }
            }else{
                th = (th - string.charAt(i))/3 + string.charAt(i+m-1) * Math.pow(3, pow);
            }
        }
        return ph == th;
    }

    public void KnuthMorrisPratt(){

    }

}
