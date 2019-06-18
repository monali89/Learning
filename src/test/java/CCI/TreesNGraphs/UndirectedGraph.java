package CCI.TreesNGraphs;

/*
* Implemented with Adjacency List
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class UndirectedGraph {

    private HashMap<Integer, List<Integer>> adjacencyList;

    UndirectedGraph(){
        adjacencyList = new HashMap<Integer, List<Integer>>();
    }

    public Set<Integer> getVertexList(){
        return adjacencyList.keySet();
    }

    public boolean addVertex(int v){
        try {
            adjacencyList.put(v, new ArrayList<Integer>());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean addEdge(int fromV1, int toV2){
        if(adjacencyList.containsKey(fromV1) || adjacencyList.containsKey(toV2)){
            List<Integer> tempList = adjacencyList.get(fromV1);
            tempList.add(toV2);
            adjacencyList.put(fromV1, tempList);
            return true;
        }else{
            return false;
        }
    }



}
