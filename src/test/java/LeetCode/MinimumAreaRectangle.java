import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

    public static void main(String[] args) {
        int[][] input = {{1,1},{1,3},{3,1},{3,3},{2,2}};
        System.out.println(minAreaRect(input));
    }


    public static int minAreaRect(int[][] points) {
        return helper(points);
    }

    public static int helper(int[][] points){

        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        int minArea = Integer.MAX_VALUE;

        for(int i=0; i<points.length; i++){
            if(!map.containsKey(points[i][0])){
                map.put(points[i][0], new HashSet<Integer>());
            }
            map.get(points[i][0]).add(points[i][1]);
        }

        System.out.println(map.toString());

        for(int[] p1: points){
            for(int[] p2: points){
                //System.out.println("Comparing first " + p1[0] + p1[1] + " " + p2[0] + p2[1]);
                if(p1[0] == p2[0] || p1[1] == p2[1]) continue;
                System.out.println("Comparing " + p1[0] + p1[1] + " " + p2[0] + p2[1]);
                if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])){
                    minArea = Math.min(minArea, Math.abs(p1[0]-p2[0]) * Math.abs(p1[1]-p2[1]));
                }
            }
        }
        return minArea == Integer.MAX_VALUE ? 0 : minArea;
    }


}
