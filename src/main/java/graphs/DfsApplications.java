package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Monali L on 4/18/2020
 */

public class DfsApplications {

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
}
