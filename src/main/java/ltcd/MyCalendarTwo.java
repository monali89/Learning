package ltcd;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 6/11/2019
 * @author: Monali
 */

public class MyCalendarTwo {

    List<int[]> cal;

    public MyCalendarTwo() {
        cal = new ArrayList<int[]>();
    }

    public boolean book(int start, int end) {
        int[] currEvent = {start, end};
        for(int[] e: cal){
            if(isIntersecting(e, currEvent)){
                if(e[2] < 3){
                    int[] et1 = merge(e, currEvent);
                    int[] et2 = {et1[0], et1[1], e[2]+1};
                    cal.remove(e);
                    cal.add(et2);
                    return true;
                }else{
                    return false;
                }
            }
        }
        int[] thisEvent = {start, end, 1};
        cal.add(thisEvent);
        return true;
    }

    public boolean isIntersecting(int[] e1, int[] e2){
        if(e1[0] <= e2[0]){
            return true;
        }else{
            if(e2[1] >= e1[0] && e2[1] <= e1[1]) return true;
        }
        return false;
    }

    public int[] merge(int[] e1, int[] e2){
        return new int[]{
                Math.min(e1[0], e2[0]),
                Math.max(e1[1], e2[1])
        };
    }

}
