package CCI.TreesNGraphs;

/*
* Implemented with Adjacency Matrix
* Nodes have int values (Starting from Zero)
* Number of nodes have to be predefined - cannot be added/removed
* */

public class DirectedGraph {

    private int[][] adjacencyMatrix;
    private int[] vertexList;

    DirectedGraph(int nodes){
        adjacencyMatrix = new int[nodes][nodes];
    }

    public int[] getVertexList(){
        return vertexList;
    }

    public void addEdge(int e1, int e2, int weight){
        adjacencyMatrix[e1][e2] = weight;
    }
}
