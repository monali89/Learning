package Other;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Date: 6/17/2019
 * @author: Monali
 */

public class Ggpi2 {

    static Map<String, Integer> map;

    public static void main(String[] args) {
        getWordFrequency("the sun rising in the west", 3);
    }

    public static void getWordFrequency(String str, int k){

        map = new HashMap<String, Integer>();
        PriorityQueue<String> q = new PriorityQueue<String>(k, new Comparator<String>() {
            public int compare(String o1, String o2) {
                if(map.get(o1) >= map.get(o2)) return 1;
                else return -1;
            }
        });

        String[] s = str.split(" ");
        for (int i = 0; i < s.length; i++) {
            if(map.containsKey(s[i])){
                map.put(s[i], map.get(s[i])+1);
            }else{
                map.put(s[i], 1);
            }
        }

        for(String w: map.keySet()){
            q.add(w);
        }

        int i = 1;
        while(i <= k){
            System.out.println(q.peek() + " " + map.get(q.remove()));
            i++;
        }
    }

}


/*
* Q: Given a sentence, output top k frequency words
*
* */
