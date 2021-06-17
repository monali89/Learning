package ltcd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MaxPointsLine_149 {

    @Test
    public void test01(){
        int[][] input = {{84,250},{0,0},{1,0},{0,-70},{0,-70},{1,-1},{21,10},{42,90},{-42,-230}};
        Assert.assertEquals(6, maxPoints(input));
    }


    public int maxPoints(int[][] points) {

        if(points == null) return 0;
        if(points.length <= 2) return points.length;

        int rslt = 0;
        Map<Double, Set<String>> map = new HashMap<Double, Set<String>>();

        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                Double slope;
                if(points[i][1] == points[j][1]){
                    slope = 1.0;
                }else if(points[i][0] == points[j][0]){
                    slope = 0.0;
                }else{
                    slope = (double) ((points[i][1] - points[j][1]) / (points[i][0] - points[j][0]));
                }

                Set<String> set;

                if(map.containsKey(slope)){
                    set = map.get(slope);
                    set.add(i + "&" + points[i][0] + "&" + points[i][1]);
                    set.add(j + "&" + points[j][0] + "&" + points[j][1]);
                    map.put(slope, set);
                }else{
                    set = new HashSet<String>();
                    set.add(i + "&" + points[i][0] + "&" + points[i][1]);
                    set.add(j + "&" + points[j][0] + "&" + points[j][1]);
                    map.put(slope, set);
                }

                rslt = Math.max(map.get(slope).size(), rslt);
                //System.out.println(points[i][0] + "," + points[i][1] + " | " + points[j][0] + "," + points[j][1] + " | " + slope);
            }
        }
        //System.out.println(map);
        return rslt;
    }

    public static void main(String[] args) {

        MaxPointsLine_149 object = new MaxPointsLine_149();
        int[][] input;
        int output;
        int expected;

        // example 1
        input = new int[][] {{1,1},{2,2},{3,3}};
        expected = 3;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();

        // example 2
        input = new int[][] {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        expected = 4;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();

        // after submitting 1
        input = new int[][] {{1,0},{0,0}};
        expected = 2;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();

        // after submitting 2
        input = new int[][] {{0,0},{1,1}};
        expected = 2;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();

        // after submitting 3
        input = new int[][] {{4,5},{4,-1},{4,0}};
        expected = 3;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();

        // after submitting 4
        input = new int[][] {{84,250},{0,0},{0,-70},{-42,-230},{21,10},{42,90},{1,0},{1,-1}};
        expected = 5;
        output = object.maxPoints(input);
        System.out.printf("Expected: %s | Output: %s | Result: %s", expected, output, (expected == output));
        System.out.println();
    }
}
