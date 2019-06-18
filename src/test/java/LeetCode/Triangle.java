package LeetCode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 6/10/2019
 * @author: Monali
 */

public class Triangle {

    @Test
    public void test01(){
        List<List<Integer>> input = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        l.add(2);
        input.add(l);
        l.clear();
        l.add(3);
        l.add(4);
        input.add(l);
        l.clear();
        l.add(6);
        l.add(5);
        l.add(7);
        input.add(l);
        l.clear();
        l.add(4);
        l.add(1);
        l.add(8);
        l.add(3);
        input.add(l);
        Assert.assertEquals(11, minimumTotal(input));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int minProd = 1;
        for(List l: triangle){
            System.out.println(l);
            int minN = Integer.MAX_VALUE;
            for (int i = 0; i < l.size(); i++) {
                minN = Math.min(minN, ((Integer) l.get(i)).intValue());
            }
            minProd = minProd * minN;
        }
        return minProd;
    }

}

/*
* 120. Triangle
* Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:

Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
* */
