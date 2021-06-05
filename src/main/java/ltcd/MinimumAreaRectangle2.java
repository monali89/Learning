package ltcd;

import java.util.HashMap;
import java.util.Map;

public class MinimumAreaRectangle2 {

    public static void main(String[] args) {

        /*double[] m = getMidpoint(new int[]{1,0}, new int[]{2,0});
        System.out.println(m[0] + ", " + m[1]);*/

        int[][] input =  {{0,1},{2,1},{1,1},{1,0},{2,0}};
        System.out.println(minAreaFreeRect(input));
    }

    public static double minAreaFreeRect(int[][] points) {
        return helper(points);
    }

    public static double helper(int[][] points){

        Map<int[], Double> map = new HashMap<int[], Double>();
        // Two point coordinates, distance between them
        for(int i=0; i<points.length; i++){
            for(int j=i+1; j<points.length; j++){
                if(i != j){
                    map.put(new int[]{i, j}, getDistance(points[i], points[j]));
                }
            }
        }

        double minArea = Double.MAX_VALUE;
        for(int[] s1: map.keySet()){
            for(int[] s2: map.keySet()){
                if(s1 != s2){
                    double d1 = map.get(s1);
                    double d2 = map.get(s2);
                    if(d1 == d2){
                        double[] m1 = getMidpoint(points[s1[0]], points[s1[1]]);
                        double[] m2 = getMidpoint(points[s2[0]], points[s2[1]]);
                        if(isSame(m1, m2)) {
                            double area = getDistance(points[s1[0]], points[s2[0]])
                                    * getDistance(points[s2[0]], points[s1[1]]);
                            minArea = Math.min(minArea, area);
                        }
                    }
                }
            }
        }

        return minArea == Double.MAX_VALUE ? 0 : minArea;
    }

    public static boolean isSame(double[] p1, double[] p2){
        return (p1[0] == p2[0]) && (p1[1] == p2[1]);
    }

    public static double[] getMidpoint(int[] p1, int[] p2){
        return new double[]{(p1[0]+p2[0])/2.0, (p1[1]+p2[1])/2.0};
    }

    public static double getDistance(int[] p1, int[] p2){
        return Math.sqrt((p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]));
    }
}
