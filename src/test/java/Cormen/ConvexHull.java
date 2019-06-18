

/*
* The convex hull of a set Q of points in the smallest convex polygon P
* for which each point in Q is either on the boundary of P or it's interior.
*
* Consider each point as a nail sticking out of a board and convex hull
* as a tight rubber band surrounding all the nails.
*
* */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConvexHull {

    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {

    }

    public void GrahamScan(){

    }


    /*
    * Computes convex hull by a technique called package wrapping or gift wrapping
    * Time complexity: O(nh), n - no. of points, h - no. of points in the convex hull
    * Worst case: O(n^2) time, O(n) space
    * */
    public void JarvisMarch(Point[] points){

        // Find leftmost point - It should be the one with least x value
        Point start = points[0];
        for (int i = 0; i < points.length; i++) {
            if(points[i].x < start.x) start = points[i];
        }

        // Start with the left most point
        Point current = start;
        Set<Point> rslt = new HashSet<Point>();
        List<Point> colPoints = new ArrayList<Point>();

        // Loop until start is not equal to end (circle is complete)
        while(true){
            Point next = points[0];
            for (int i = 1; i < points.length; i++) {
                if(points[i] == current) continue;
                // Get the cross product considering current point as common
                int val = getPointCrossProduct(current, next, points[i]);
                if(val > 0){ // This point is on the left side of current->next

                }else{ // // This point is on the right side of current->next, do nothing

                }
            }
        }
    }

    public int getPointCrossProduct(Point p0, Point p1, Point p2){
        /*
        * Cormen 935
        * To determine whether a directed segment p0p1-> is clockwise from a directed segment p0p2-> w.r.t their common endpoint p0
        * (p1-p0) X (p2-p0) = (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0)
        * */
        return  (p1.x - p0.x)*(p2.y - p0.y) - (p2.x - p0.x)*(p1.y - p0.y);
    }

}
