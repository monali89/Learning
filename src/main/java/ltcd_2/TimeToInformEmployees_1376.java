package ltcd_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author Monali L on 6/12/2021
 */

public class TimeToInformEmployees_1376 {

    private int[] m;
    private int[] t;
    private int n;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int totalTime = 0;

        this.n = n;
        this.m = manager;
        this.t = informTime;

        totalTime = getTime(headID);

        return totalTime;
    }

    private int getTime(int currManager) {
        if (t[currManager] == 0) return 0;

        int totalTime = 0;
        for (int i = 0; i < n; i++) {
            if (m[i] == currManager) {
                totalTime = Math.max(totalTime, getTime(i));
            }
        }
        return totalTime + t[currManager];
    }

    public static void main(String[] args) {
        TimeToInformEmployees_1376 object = new TimeToInformEmployees_1376();
        int n;
        int headID;
        int[] manager;
        int[] informTime;

        n = 1; headID = 0;
        manager = new int[]{-1};
        informTime = new int[]{0};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 6; headID = 2;
        manager = new int[]{2,2,-1,2,2,2};
        informTime = new int[]{0,0,1,0,0,0};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 7; headID = 6;
        manager = new int[]{1,2,3,4,5,6,-1};
        informTime = new int[]{0,6,5,4,3,2,1};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 15; headID = 0;
        manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 4; headID = 2;
        manager = new int[]{3,3,-1,2};
        informTime = new int[]{0,0,162,914};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 10; headID = 3;
        manager = new int[]{8,9,8,-1,7,1,2,0,3,0};
        informTime = new int[]{224,943,160,909,0,0,0,643,867,722};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));

        n = 11; headID = 4;
        manager = new int[]{5,9,6,10,-1,8,9,1,9,3,4};
        informTime = new int[]{0,213,0,253,686,170,975,0,261,309,337};
        System.out.println(object.numOfMinutes(n, headID, manager, informTime));
    }

}
