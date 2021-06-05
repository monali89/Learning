package ltcd_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 6/5/2021
 */

public class Triangle_120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, triangle).get(0);
    }

    public List<Integer> helper(int rowNum, List<List<Integer>> t) {

        if (rowNum == t.size() - 1) return t.get(t.size() - 1);

        List<Integer> curr = t.get(rowNum);
        List<Integer> prev = helper(rowNum+1, t);
        List<Integer> rslt = new ArrayList<Integer>();

        for (int i = 0; i < curr.size(); i++) {
            rslt.add(i, curr.get(i) + Math.min(prev.get(i), prev.get(i+1)));
        }
        return rslt;
    }

    public List<List<Integer>> getInput() {
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
        String s = "[[2],[3,4],[6,5,7],[4,1,8,3]]";
        String[] arr = s.split("],\\[");
        for (String a: arr) {
            String str = a.replace("[", "");
            str = str.replace("]", "");
            String[] arr2 = str.split(",");
            List<Integer> list = new ArrayList<Integer>();
            for (String a2: arr2) {
                list.add(Integer.valueOf(a2));
            }
            listOfList.add(list);
        }
        return listOfList;
    }

    public static void main(String[] args) {
        Triangle_120 object = new Triangle_120();
        List<List<Integer>> triangle = object.getInput();
        System.out.println(triangle);
        System.out.println(object.minimumTotal(triangle));
    }

}
