package ltcd;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointstoOrigin {

    public static void main(String[] args) {
        int[][] input = {{3,3},{5,-1},{-2,4}};
        int[][] output = kClosest(input, 2);

        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i][0] + ", " + output[i][1]);
        }
    }

    public static int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(K, new Comparator<int[]>(){
            public int compare(int[] p1, int[] p2){
                double d1 = Math.sqrt(p1[0]*p1[0] + p1[1]*p1[1]);
                double d2 = Math.sqrt(p2[0]*p2[0] + p2[1]*p2[1]);
                if(d1 > d2) return 1;
                else return -1;
            }
        });

        for(int i=0; i<points.length; i++){
            System.out.println("Adding points [" + points[i][0] +", " + points[i][1] + "]" + ", Distance - " +
                    Math.sqrt(points[i][0]*points[i][0] + points[i][0]*points[i][0]));
            queue.add(points[i]);
        }

        int[][] rslt = new int[K][2];
        int i = 0;
        while(!queue.isEmpty() && i < K){
            rslt[i++] = queue.remove();
        }
        return rslt;
    }
}
