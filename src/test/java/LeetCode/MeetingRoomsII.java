package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: monali on 5/8/2019
 */

public class MeetingRoomsII {

    @Test
    public void test01(){
        //Assert.assertEquals(2,minMeetingRooms(new int[][]{{0,30}, {5,10}, {15,20}}));
        Assert.assertEquals(2,minMeetingRooms(new int[][]{{35,40}, {0,10}, {5,20}, {10,25}, {20,35}, {25,30}}));
        //Assert.assertEquals(1, minMeetingRooms(new int[][]{{7,10}, {2,4}}));
        //Assert.assertEquals(2, minMeetingRooms(new int[][]{{2,10}, {7,15}}));
        //Assert.assertEquals(2, minMeetingRooms(new int[][]{{2,9}, {3,9}}));
    }


    public static int minMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int rooms = 0;

        List<int[]> list = new ArrayList<int[]>();

        for(int i=0; i<intervals.length; i++){
            if(list.isEmpty()){
                list.add(intervals[i]);
                rooms = rooms + 1;
            }
            else{
                int j = 0;
                while(j < list.size()){
                    if(isDisjoint(list.get(j), intervals[i])) break;
                    j++;
                }
                if(j < list.size()){
                    int[] c = list.get(j);
                    int[] m = new int[2];
                    m[0] = c[0];
                    m[1] = intervals[i][1];
                    list.remove(j);
                    list.add(m);
                }else{
                    list.add(intervals[i]);
                    rooms = rooms + 1;
                }
            }
        }

        return rooms;
    }

    public static boolean isDisjoint(int[] a, int[] b){
        return b[0] >= a[1];
    }

}


/*
* Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
* find the minimum number of conference rooms required.
*
* Input: [[0, 30],[5, 10],[15, 20]]
* Output: 2
*
* Input: [[7,10],[2,4]]
* Output: 1
*
* */
