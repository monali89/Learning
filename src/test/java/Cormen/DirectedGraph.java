package Cormen;

import java.util.*;

import org.apache.log4j.Logger;

public class DirectedGraph {

    private HashMap<Integer, List<Integer>> adjacencyList;
    final static Logger logger = Logger.getLogger(DirectedGraph.class);

    DirectedGraph(){
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

    public void bfs(DirectedGraph g, int root){

        Set<Integer> vertexList = getVertexList();

        if(vertexList.isEmpty()){
            System.out.println("Graph is Empty");
        }

        HashMap<Integer, String> colorMap = new HashMap<Integer, String>();
        LinkedList<Integer> queue = new LinkedList<Integer>();

        for(int v: vertexList){
            colorMap.put(v, "WHITE");
        }

        queue.add(root);

        while(!queue.isEmpty()){
            int currentNode = queue.peek();
            if(colorMap.get(currentNode) == "WHITE"){
                System.out.print(queue.peek() + " ");
                colorMap.put(currentNode, "BLACK");
                List<Integer> neighbours = g.adjacencyList.get(currentNode);
                logger.debug("Neighbours of " + currentNode + ": " + neighbours.toString());
                for(int n: neighbours){
                    queue.add(n);
                }
            }
            queue.remove(queue.getFirst());
        }
        System.out.println();
    }

    public void dfs(DirectedGraph g, int root){

        Set<Integer> vertexList = getVertexList();

        if(vertexList.isEmpty()){
            System.out.println("Graph is Empty");
        }

        HashMap<Integer, String> colorMap = new HashMap<Integer, String>();
        Stack<Integer> stack = new Stack<Integer>();

        for(int v: vertexList){
            colorMap.put(v, "WHITE");
        }

        stack.push(root);

        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            if(colorMap.get(currentNode) == "WHITE"){
                System.out.print(currentNode + " ");
                colorMap.put(currentNode, "BLACK");
                List<Integer> neighbours = g.adjacencyList.get(currentNode);
                logger.debug("Neighbours of " + currentNode + ": " + neighbours.toString());
                for(int n: neighbours){
                    if(colorMap.get(n) == "WHITE") {
                        stack.push(n);
                    }
                }
            }
        }
        System.out.println();
    }

    public int getInDegree(int v){
        return -1;
    }

    public int getOutDegree(int v){
        return -1;
    }

    public DirectedGraph getTranspose(DirectedGraph graph){
        return null;
    }

    public void primsMinimumSpanningTree(){

    }

    public void DijkstrasShortestPath(){

    }

}
