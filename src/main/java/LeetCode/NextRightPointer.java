package LeetCode;

import trees.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author Monali L on 5/2/2020
 * TODO: Problem 116: You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. Populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 */

public class NextRightPointer {

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;

        printBFS(n1);
        //Node nNew = connect(n1);
        //printPreOrderNext(nNew);
    }

    public static Node connect(Node root) {


        return null;
    }


    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public static void printPreOrderNext(Node n) {
        if (n == null) return;
        System.out.println(n.val + ", next - " + (n.next != null ? n.next.val : "null"));
        printPreOrderNext(n.left);
        printPreOrderNext(n.right);
    }

    public static void printBFS(Node root){
        Queue<Node> queue = new LinkedList<Node>();
        Set<Node> visited = new HashSet<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.peek();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            System.out.print(curr.val + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            queue.remove();
        }
        System.out.println();
    }
}
