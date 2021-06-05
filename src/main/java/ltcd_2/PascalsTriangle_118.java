package ltcd_2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 6/5/2021
 */
public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for(int i = 1; i <= numRows; i++) {
            List<Integer> list1 = result.size() == 0 ? new ArrayList<Integer>() : result.get(result.size()-1);

            System.out.println("list1: " + list1);

            List<Integer> list2 = new ArrayList<Integer>();
            list2.add(1);

            for (int j = 0; j < list1.size()-1; j++) {
                list2.add(list1.get(j) + list1.get(j+1));
            }
            if (result.size() != 0) list2.add(1);
            result.add(list2);

            System.out.println("list2: " + list2);
        }

        return result;
    }

    public static void main(String[] args) {
        PascalsTriangle_118 object = new PascalsTriangle_118();
        System.out.println(object.generate(5));
    }

}
