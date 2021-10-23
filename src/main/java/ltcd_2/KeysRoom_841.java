package ltcd_2;

import java.util.*;

public class KeysRoom_841 {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        queue.add(0);
        set.add(0);

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            List<Integer> keys = rooms.get(curr);
            for (int key: keys) {
                if (!set.contains(key)) {
                    queue.add(key);
                    set.add(key);
                }
            }
        }

        System.out.println(set);

        return set.size() == rooms.size();
    }


    public static void main(String[] args) {

        KeysRoom_841 object = new KeysRoom_841();
        int[][] input;

        // test 1
        input = new int[][] {{1,3},{3,0,1},{2},{0}};
        System.out.println(object.canVisitAllRooms(object.getInput(input)));

    }

    private List<List<Integer>> getInput(int[][] a) {
        List<List<Integer>> ll = new ArrayList<>();

        for (int i = 0; i < a.length; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j < a[i].length; j++) {
                l.add(a[i][j]);
            }
            ll.add(l);
        }

        return ll;
    }
}
