package ltcd_2;

import common.Common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinNumVertices_1557 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        int[] inDegree = new int[n];
        List<Integer> result = new ArrayList<>();

        for (List<Integer> l: edges) {
            inDegree[l.get(1)]++;
        }

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {

        MinNumVertices_1557 object = new MinNumVertices_1557();
        int[][] input;
        int n;
        String output = "";

        // test 1
        n = 6;
        input = new int[][] {{0,1},{0,2},{2,5},{3,4},{4,2}};
        output = object.findSmallestSetOfVertices(n, object.getInput(input)).toString();
        System.out.println(output);

        // test 2
        // test 1
        n = 6;
        input = new int[][] {{0,1},{0,2},{2,5},{3,4},{4,2}};
        output = object.findSmallestSetOfVertices(n, object.getInput(input)).toString();
        System.out.println(output);
    }

    private List<List<Integer>> getInput(int[][] a) {
        List<List<Integer>> ll = new ArrayList<>();

        for (int[] ints : a) {
            List<Integer> l = new ArrayList<>();
            l.add(ints[0]);
            l.add(ints[1]);
            ll.add(l);
        }

        return ll;
    }
}
