package graphs;

/*
* Implemented with Adjacency List
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Graph {

    private HashMap<Integer, List<Integer>> adjacencyList;

    Graph(int size){
        adjacencyList = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < size; i++) addVertex(i);
    }

    public Set<Integer> getVertexList(){
        return adjacencyList.keySet();
    }

    private void addVertex(int v){
        adjacencyList.put(v, new ArrayList<Integer>());
    }

    public void addEdge(int v, int u){
        List<Integer> tempList;

        tempList = adjacencyList.get(v);
        tempList.add(u);
        adjacencyList.put(v, tempList);

        tempList = adjacencyList.get(u);
        tempList.add(v);
        adjacencyList.put(u, tempList);
    }

    public Iterable<Integer> getAdjEdges(int v) {
        return adjacencyList.get(v);
    }

    public int size() {
        return adjacencyList.size();
    }

}
