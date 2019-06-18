package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RanNumWithBlacklist {

    public static void main(String[] args) {

        int[] bl = {2,1};
        RanNumWithBlacklist obj = new RanNumWithBlacklist(4, bl);

        for(int i=0; i<10; i++) System.out.println(obj.pick());
    }

    int[] some;

    public RanNumWithBlacklist(int N, int[] blacklist) {

        Arrays.sort(blacklist);
        some = new int[N-blacklist.length];
        int j=0, k=0;
        for(int i=0; i<N; i++){
            if(j < some.length){
                if(k<blacklist.length && i == blacklist[k]) {
                    k++;
                }else{
                    some[j] = i;
                    j++;
                }
            }
        }
    }

    public int pick() {
        int r = (int) (Math.random()*some.length);
        return some[r];
    }

}
