package Cormen;

public class GraphMain {

    public static void main(String[] args){
        DirectedGraph g = new DirectedGraph();

        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);
        g.addVertex(7);
        g.addVertex(8);

        System.out.println(g.getVertexList().toString());

        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,5);
        g.addEdge(2,6);
        g.addEdge(3,6);
        g.addEdge(4,6);
        g.addEdge(4,7);
        g.addEdge(5,8);
        g.addEdge(7,8);

        System.out.print("BFS: ");
        g.bfs(g, 1);
        System.out.println();

        System.out.print("DFS: ");
        g.dfs(g, 1);
        System.out.println();
    }

}
