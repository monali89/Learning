package graphs;

import java.util.*;

/**
 * @author Monali L on 4/18/2020
 */

public class DfsApplications {

    // Depth First Search
    public List<Integer> dfs(int root, Digraph dg) {
        boolean[] isVisited = new boolean[dg.size()];
        List<Integer> dfsOrder = new ArrayList<Integer>();
        dfs_helper(root, dg, isVisited, dfsOrder);
        return dfsOrder;
    }

    public void dfs_helper(int n, Digraph dg, boolean[] isVisited, List<Integer> dfsOrder) {
        dfsOrder.add(n);
        isVisited[n] = true;
        for(int adj: dg.getAdjEdges(n)) {
            if(!isVisited[adj]) {
                isVisited[adj] = true;
                dfs_helper(adj, dg, isVisited, dfsOrder);
            }
        }
    }

    // Given 2D matrix find number of islands (connected 1's)
    public int getNumberOfIslands(int[][] m) {

        if (m.length <= 0 || m.length != m[0].length) return -1;

        int size = m.length;
        boolean[][] isVisited = new boolean[size][size];
        int islands = 0;
        int[] r = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] c = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                isVisited[i][j] = true;
                if (m[i][j] != 1) continue;
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    if (i+r[k] < 0 || i+r[k] >= size || j+c[k] < 0 || j+c[k] >= size) continue;
                    if (!isVisited[i + r[k]][j + c[k]] && m[i + r[k]][j + c[k]] == 1) count++;
                }
                if (count > 0) islands++;
            }
        }
        return islands;
    }

    // Implementation Details: Do a dfs of every visited vertex,
    // if there is an adjacent u, such that u is already visited
    // and u is not a parent of v, this is a cycle
    public boolean hasCycle(Graph g) {

        boolean[] isVisited = new boolean[g.size()];
        return hasCycleHelper(g, 0, isVisited);
    }

    private boolean hasCycleHelper(Graph g, int v, boolean[] isVisited) {
        // DFS
        Iterable<Integer> neighbors = g.getAdjEdges(v);
        for (int neigh: neighbors) {
            if (isVisited[neigh]) {
                List<Integer> l = (List<Integer>) g.getAdjEdges(neigh);
                if (l.contains(v)) return true;
            } else {
                isVisited[neigh] = true;
                hasCycleHelper(g, neigh, isVisited);
            }
        }
        return false;
    }

    // Longest distance/path between two vertices in a graph
    public int longestPath(WeightedDigraph wdg) {

        int[] dist = new int[wdg.size()];
        int[] tp = topologicalOrder(wdg);
        int max_dist = Integer.MIN_VALUE;

        for (int i = 0; i < wdg.size(); i++) dist[i] = 0;

        for (int i = 0; i < wdg.size(); i++) {
            Iterable<Integer> neighbors = wdg.getAdjEdges(tp[i]);
            for (int neigh: neighbors) {
                if (dist[neigh] < dist[tp[i]] + wdg.getEdgeWeight(tp[i], neigh)) {
                    dist[neigh] = dist[tp[i]] + wdg.getEdgeWeight(tp[i], neigh);
                }
                max_dist = Math.max(max_dist, dist[neigh]);
            }
        }
        return max_dist;
    }

    public int motherVertex(Digraph dg) {
        return -1;
    }

    public void iterativeDfs(Digraph dg) {

    }

    public void printAllPaths(Digraph dg, int v, int u) {

    }

    public void steppingNumbers(int s, int e) {

    }

    // Misc

    // Topological sorting for Directed Acyclic Graph (DAG)
    // is a linear ordering of vertices such that for every directed edge uv,
    // vertex u comes before v in the ordering.
    public int[] topologicalOrder(Digraph dg) {

        int[] order = new int[dg.size()];
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isVisited = new boolean[dg.size()];

        Iterable<Integer> vertexes = dg.getVertexList();
        for (int vertex: vertexes) {
            if (!isVisited[vertex]) topologicalOrderHelper(dg, isVisited, stack, vertex);
        }

        for (int i = 0; i < dg.size(); i++) {
            order[i] = stack.isEmpty() ? -1 : stack.pop();
        }

        return order;
    }

    private void topologicalOrderHelper(Digraph dg, boolean[] isVisited, Stack<Integer> stack, int v) {

        isVisited[v] = true;
        Iterable<Integer> neighbors = dg.getAdjEdges(v);
        for (int neigh: neighbors) {
            if (!isVisited[neigh]) {
                topologicalOrderHelper(dg, isVisited, stack, neigh);
            }
        }
        stack.push(v);
    }

    public int[] topologicalOrder(WeightedDigraph wdg) {

        int[] order = new int[wdg.size()];
        Stack<Integer> stack = new Stack<Integer>();
        boolean[] isVisited = new boolean[wdg.size()];

        Iterable<Integer> vertexes = wdg.getVertexList();
        for (int vertex: vertexes) {
            if (!isVisited[vertex]) topologicalOrderHelper(wdg, isVisited, stack, vertex);
        }

        for (int i = 0; i < wdg.size(); i++) {
            order[i] = stack.isEmpty() ? -1 : stack.pop();
        }

        return order;
    }

    private void topologicalOrderHelper(WeightedDigraph wdg, boolean[] isVisited, Stack<Integer> stack, int v) {

        isVisited[v] = true;
        Iterable<Integer> neighbors = wdg.getAdjEdges(v);
        for (int neigh: neighbors) {
            if (!isVisited[neigh]) {
                topologicalOrderHelper(wdg, isVisited, stack, neigh);
            }
        }
        stack.push(v);
    }

    // Dijkstra Algorithm - given a source vertex find shortest path to all other vertices form here
    // Can be bfs/dfs
    // Directed non negative edges
    public void djk(int s, WeightedDigraph wdg) {
        int[] distTo = new int[wdg.size()];
        int[] edgeTo = new int[wdg.size()];
        boolean[] isVisited = new boolean[wdg.size()];
        Queue<Integer> queue = new PriorityQueue<Integer>();

        queue.add(s);
        for (int i = 0; i < wdg.size(); i++) distTo[i] = Integer.MAX_VALUE;
        distTo[s] = 0;
        for (int i = 0; i < wdg.size(); i++) edgeTo[i] = -1;

        while (!queue.isEmpty()) {
            int curr = queue.remove();
            isVisited[curr] = true;
            for (int adj: wdg.getAdjEdges(curr)) {
                int thisDist = distTo[curr] + wdg.getEdgeWeight(curr, adj);
                if (distTo[adj] > thisDist) {
                    queue.add(adj);
                    isVisited[adj] = true;
                    distTo[adj] = thisDist;
                    edgeTo[adj] = curr;
                }
            }
        }

        System.out.print("Vertex: ");
        for (int i = 0; i < wdg.size(); i++) System.out.print(i + " ");
        System.out.println();

        System.out.print("DistTo: ");
        for (int i = 0; i < wdg.size(); i++) System.out.print(distTo[i] + " ");
        System.out.println();

        System.out.print("EdgeTo: ");
        for (int i = 0; i < wdg.size(); i++) System.out.print(edgeTo[i] + " ");
        System.out.println();
    }

    // TODO: Bellman Ford Algorithm
    // Single source shortest path in a graph with negative edges

    // Floyd Warshall Algorithm
    // Finding shortest paths in a weighted graph with positive and negative edges (no negative cycles)
    // Performance: V^2, V^3
    public void floydWarshall(WeightedDigraph wdg) {
        // Create a matrix of vxv size
        int[][] distTo = new int[wdg.size()][wdg.size()];
        // Initialize all weights as infinity
        // Initialize matrix with 0 for self weight and actual weight for other edges
        for (int i = 0; i < wdg.size(); i++) {
            for (int j = 0; j < wdg.size(); j++) {
                //distTo[i][j] = Integer.MAX_VALUE;
                if (i == j) distTo[i][j] = 0;
                else distTo[i][j] = wdg.getEdgeWeight(i, j);
            }
        }
        // Loop through the graph thrice and compare weights
        for (int k = 0; k < wdg.size(); k++) {
            for (int i = 0; i < wdg.size(); i++) {
                for (int j = 0; j < wdg.size(); j++) {
                    if (distTo[i][j] > distTo[i][k] + distTo[k][j]) {
                        distTo[i][j] = distTo[i][k] + distTo[k][j];
                    }
                }
        }
        }
        for (int i = 0; i < distTo.length; i++) {
            for (int j = 0; j < distTo.length; j++) {
                System.out.print(distTo[i][j] + " ");
            }
            System.out.println();
        }
    }

    // TODO: Detect Cycle in an Undirected Graph OR Union find algorithm

    // TODO: Minimum Spanning tree **Prim**

    // TODO: Minimum Spanning tree **Kruskal**

    // TODO: Topological Sort

    // TODO: Boggle (Find all possible words in a board of characters)

    // TODO: Bridges in a Graph

}
