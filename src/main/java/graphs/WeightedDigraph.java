package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Monali L on 4/18/2020
 */

public class WeightedDigraph {

    private int[][] adjacencyMatrix;
    private List<Integer> vertexList;

    WeightedDigraph(int vertices){
        adjacencyMatrix = new int[vertices][vertices];
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                adjacencyMatrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        vertexList = new ArrayList<Integer>();
        for (int i = 0; i < vertices; i++) {
            vertexList.add(i);
        }
    }

    public Iterable<Integer> getVertexList(){
        return vertexList;
    }

    public void addEdge(int v, int u, int weight){
        adjacencyMatrix[v][u] = weight;
    }

    public Iterable<Integer> getAdjEdges(int v) {
        List<Integer> adj = new ArrayList<Integer>();
        for (int i = 0; i < size(); i++) {
            if (adjacencyMatrix[v][i] > 0) adj.add(i);
        }
        return adj;
    }

    public int getEdgeWeight(int v, int u) {
        return adjacencyMatrix[v][u];
    }

    public int size() {
        return adjacencyMatrix.length;
    }

}
