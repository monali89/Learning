package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Monali L on 4/18/2020
 */

public class BfsApplications {

    // Breadth first search
    public List<Integer> bfs(int root, Graph g) {
        List<Integer> bfsOrder = new ArrayList<Integer>();
        Queue<Integer> q = new PriorityQueue<Integer>(); // new Queue<Integer>();
        boolean[] isVisited = new boolean[g.size()];
        q.add(root);
        isVisited[root] = true;
        while(!q.isEmpty()) {
            int curr = q.remove();
            bfsOrder.add(curr);
            for(int adj: g.getAdjEdges(curr)) {
                if(!isVisited[root]) {
                    isVisited[adj] = true;
                    q.add(adj);
                }
            }
        }
        return bfsOrder;
    }

    public List<Integer> bfs(int root, Digraph g) {
        List<Integer> bfsOrder = new ArrayList<Integer>();
        Queue<Integer> q = new PriorityQueue<Integer>();
        boolean[] isVisited = new boolean[g.size()];
        q.add(root);
        isVisited[root] = true;
        while(!q.isEmpty()) {
            int curr = q.remove();
            bfsOrder.add(curr);
            System.out.println("DEBUG: curr - " + curr + ", adj - " + g.getAdjEdges(curr) + ", q - " + q);
            for(int adj: g.getAdjEdges(curr)) {
                if(!isVisited[adj]) {
                    isVisited[adj] = true;
                    q.add(adj);
                }
            }
        }
        return bfsOrder;
    }


    public int snakesAndLadders(int[] moves) {

        int diceThrows = 0;

        // Breadth first search, all adjacent squares can be neighbors of that vertex


        return diceThrows;
    }

}
