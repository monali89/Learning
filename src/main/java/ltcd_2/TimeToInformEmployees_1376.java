package ltcd_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeToInformEmployees_1376 {

    private int[] t;
    private Map<Integer, List<Integer>> map;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        int totalTime = 0;

        this.t = informTime;
        map = new HashMap<Integer, List<Integer>>();

        // Create a manager <-> subordinate storage for fast access
        for (int i = 0; i < manager.length; i++) {
            List<Integer> subs;
            if (map.containsKey(manager[i])) {
                subs = map.get(manager[i]);

            } else {
                subs = new ArrayList<Integer>();
            }
            subs.add(i);
            map.put(manager[i], subs);
        }

        totalTime = getTime(headID);

        return totalTime;
    }

    private int getTime(int currManager) {
        if (t[currManager] == 0) return 0;

        int totalTime = 0;
        for (int i: map.get(currManager)) {
            totalTime = Math.max(totalTime, getTime(i));
        }
        return totalTime + t[currManager];
    }

    public static void main(String[] args) {
        TimeToInformEmployees_1376 object = new TimeToInformEmployees_1376();
        int n;
        int headID;
        int[] manager;
        int[] informTime;
        int output;
        int expected;

        n = 1; headID = 0;
        manager = new int[]{-1};
        informTime = new int[]{0};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 0;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 6; headID = 2;
        manager = new int[]{2,2,-1,2,2,2};
        informTime = new int[]{0,0,1,0,0,0};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 1;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 7; headID = 6;
        manager = new int[]{1,2,3,4,5,6,-1};
        informTime = new int[]{0,6,5,4,3,2,1};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 21;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 15; headID = 0;
        manager = new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6};
        informTime = new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 3;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 4; headID = 2;
        manager = new int[]{3,3,-1,2};
        informTime = new int[]{0,0,162,914};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 1076;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 10; headID = 3;
        manager = new int[]{8,9,8,-1,7,1,2,0,3,0};
        informTime = new int[]{224,943,160,909,0,0,0,643,867,722};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 3665;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();

        n = 11; headID = 4;
        manager = new int[]{5,9,6,10,-1,8,9,1,9,3,4};
        informTime = new int[]{0,213,0,253,686,170,975,0,261,309,337};
        output = object.numOfMinutes(n, headID, manager, informTime);
        expected = 2560;
        System.out.printf("Output: %4s, Expected: %4s, Result: %s", output, expected, (output == expected));
        System.out.println();
    }

}
