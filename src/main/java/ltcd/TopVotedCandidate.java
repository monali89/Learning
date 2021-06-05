package ltcd;

import org.junit.Assert;
import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {

    public static void main(String[] args) {

        int[] persons = {0,1,2,2,1};
        int[] times = {20,28,29,54,56};
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);

        int[] input = {28,53,57,29,29,28,30,20,56,55};
        int[] output = {1,2,1,2,2,1,2,0,1,2};

        /*for(int i=0; i<input.length; i++){
            Assert.assertEquals(obj.q(input[i]), output[i]);
        }*/

        Assert.assertEquals(obj.q(56), 1);
    }

    int[] p;
    int[] t;
    int[] leads;

    public TopVotedCandidate(int[] persons, int[] times){
        p = persons;
        t = times;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        leads = new int[times.length];
        leads[0] = persons[0];
        map.put(persons[0], 1);

        for(int i=1; i<times.length; i++){

            if(map.containsKey(persons[i]))
                map.put(persons[i], map.get(persons[i])+1);
            else map.put(persons[i], 1);

            if(map.get(leads[i-1]) > map.get(persons[i]))
                leads[i] = leads[i-1];
            else leads[i] = persons[i];
        }
    }

    public int q(int t){
        int index = getIndex(t, 0, this.t.length-1);
        return leads[index];
    }

    public int getIndex(int val, int s, int e){

        if(val < t[0]) return -1;
        if(e-s == 1) return val >= t[e] ? e : s;

        int mid = (s+e)/2;
        if(val < t[mid]) return getIndex(val, s, mid);
        else if(val > t[mid]) return getIndex(val, mid, e);
        return mid;
    }


}
