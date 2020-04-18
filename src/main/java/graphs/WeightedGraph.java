package graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 4/18/2020
 */

public class WeightedGraph {

    private int[][] adjacencyMatrix;
    private int[] vertexList;

    WeightedGraph(int vertices){
        adjacencyMatrix = new int[vertices][vertices];
    }

    public int[] getVertexList(){
        return vertexList;
    }

    public void addEdge(int v, int u, int weight){
        adjacencyMatrix[v][u] = weight;
        adjacencyMatrix[u][v] = weight;
    }

    public Iterable<Integer> getAdjEdges(int v) {
        List<Integer> adj = new ArrayList<Integer>();
        for (int i = 0; i < size(); i++) {
            if (adjacencyMatrix[v][i] > 0) adj.add(i);
        }
        return adj;
    }

    public int size() {
        return adjacencyMatrix.length;
    }
}
