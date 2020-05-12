package LeetCode;

import java.util.*;

/**
 * @author Monali L on 5/4/2020
 * Problem: Given a reference of a node in a connected undirected graph.
 * Return a deep copy (clone) of the graph.
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public String toString() {
            StringBuilder n = new StringBuilder();
            for (Node neigh: neighbors) n.append(neigh.val).append(" ");
            return "Node{" +
                    "val=" + val +
                    ", neighbors=" + n +
                    '}';
        }
    }

    private static Map<Integer, Node> isVisited;

    public static Node cloneGraph(Node node) {
        isVisited = new HashMap<Integer, Node>();
        return helper(node);
    }

    private static Node helper(Node node) {
        if (node == null) return null;
        if (isVisited.containsKey(node.val)) return isVisited.get(node.val);
        Node newNode = new Node(node.val);
        isVisited.put(node.val, newNode);
        for (Node neigh: node.neighbors) {
            Node newNeigh = helper(neigh);
            newNode.neighbors.add(newNeigh);
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        List<Node> n1_neigh = new ArrayList<Node>();
        n1_neigh.add(n2);
        n1_neigh.add(n4);
        n1.neighbors.addAll(n1_neigh);

        List<Node> n2_neigh = new ArrayList<Node>();
        n2_neigh.add(n1);
        n2_neigh.add(n3);
        n2.neighbors.addAll(n2_neigh);

        List<Node> n3_neigh = new ArrayList<Node>();
        n3_neigh.add(n2);
        n3_neigh.add(n4);
        n3.neighbors.addAll(n3_neigh);

        List<Node> n4_neigh = new ArrayList<Node>();
        n4_neigh.add(n1);
        n4_neigh.add(n3);
        n4.neighbors.addAll(n4_neigh);

        System.out.println(n1.toString());
        System.out.println(n2.toString());
        System.out.println(n3.toString());
        System.out.println(n4.toString());
        System.out.println();

        Node newNode = cloneGraph(n1);
        System.out.println(newNode.toString());
    }

    public static void dfs(){

    }

}
