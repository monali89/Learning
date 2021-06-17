package ltcd;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Date: 6/26/2019
 * @author: Monali
 */

public class MaxPointsLine {

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
                    slope = Double.valueOf((points[i][1] - points[j][1])/(points[i][0] - points[j][0]));
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
                System.out.println(points[i][0] + "," + points[i][1] + " | " + points[j][0] + "," + points[j][1] + " | " + slope);
            }
        }
        System.out.println(map);
        return rslt;
    }
}


/*
* Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
* */