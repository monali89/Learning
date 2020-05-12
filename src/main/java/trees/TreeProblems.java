package trees;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Monali L on 4/22/2020
 */

public class TreeProblems {

    // Find Minimum Depth of a Binary Tree
    public int getMaxDept(TreeNode root) {
        int maxDept = 0;
        if (root == null) return 0;
        maxDept = 1 + Math.max(getMaxDept(root.left), getMaxDept(root.right));
        return maxDept;
    }

    // Maximum Path Sum in a Binary Tree
    // Problem: Given a binary tree, find the maximum path sum.
    // The path may start and end at any node in the tree.
    // There are four possible counts at each node
    // 1. the node itself
    // 2. the node + left (path just passes through this node)
    // 3. the node + right (path just passes through this node)
    // 4. the node + left + right
    static class res {
        public static int val;
    }
    public int findMaxPath(TreeNode root) {
        return Math.max(findMaxPath_helper(root), res.val);
    }

    public int findMaxPath_helper(TreeNode node) {
        if (node == null) return 0;
        int max_this = Integer.MIN_VALUE;
        int l = findMaxPath_helper(node.left);
        int r = findMaxPath_helper(node.right);
        max_this = Math.max(node.data+l+r, Math.max(Math.max(l, r) + node.data, node.data));
        res.val = Math.max(res.val, max_this);
        return Math.max(Math.max(l, r) + node.data, node.data);
    }

    // TODO: Check if a given array can represent Preorder Traversal of Binary Search Tree

    // Check whether a binary tree is a full binary tree or not
    // Problem: A full binary tree is defined as a binary tree in which all nodes have either zero or two child nodes.
    // Conversely, there is no node in a full binary tree, which has one child node.
    public boolean isFull(TreeNode root) {
        return isFull_helper(root);
    }

    public boolean isFull_helper(TreeNode node) {
        if (node == null) return true;
        if (node.left != null && node.right != null)
            return isFull_helper(node.left) && isFull_helper(node.right);
        else return false;
    }

    // TODO: Bottom View Binary Tree
    // Problem: Given a Binary Tree, we need to print the bottom view from left to right.
    // A node x is there in output if x is the bottommost node at its horizontal distance.
    // Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1,
    // and that of right child is horizontal distance of x plus 1.

    // TODO: Print Nodes in Top View of Binary Tree
    // TODO: Remove nodes on root to leaf paths of length < K
    // TODO: Lowest Common Ancestor in a Binary Search Tree
    // TODO: Check if a binary tree is subtree of another binary tree

    // TODO: Reverse alternate levels of a perfect binary tree
    // Do pre-order traversal and store values in an array/list
    // Reverse the list and traverse the tree again replacing values at every odd level node
    public void reverseLevels(BinaryTree bt, TreeNode root) {
        // Get all nodes in pre-order
        List<Integer> preorder = new ArrayList<Integer>();
        reverseLevels_helper(root, preorder);
        // Reverse the list
        int s = 0, e = preorder.size()-1;
        while (s < e) {
            int temp = preorder.get(s);
            preorder.add(s, preorder.get(e));
            preorder.add(e, temp);
        }
        // Traverse the tree again replacing nodes at odd level
        
    }

    private void reverseLevels_helper(TreeNode node, List<Integer> l) {
        // pre-order traversal
        if (node == null) return;
        if (node.left != null) reverseLevels_helper(node.left, l);
        if (node.right != null) reverseLevels_helper(node.right, l);
        l.add(node.data);
    }

    // Problem: Maximum path in a n-ary tree
    private static int maxOverall = Integer.MIN_VALUE;
    public void maxPathNAryTree() {
        TreeNaryNode n1 = new TreeNaryNode(1);
        TreeNaryNode n2 = new TreeNaryNode(2);
        TreeNaryNode n3 = new TreeNaryNode(3);
        TreeNaryNode n4 = new TreeNaryNode(4);
        TreeNaryNode n5 = new TreeNaryNode(5);
        TreeNaryNode n6 = new TreeNaryNode(6);
        TreeNaryNode n7 = new TreeNaryNode(7);

        n1.leaves.add(n2);
        n1.leaves.add(n3);
        n1.leaves.add(n4);
        n2.leaves.add(n5);
        n2.leaves.add(n6);
        n3.leaves.add(n7);

        System.out.println("RESULT - " + Math.max(maxPathNAryTree_helper(n1), maxOverall));
    }

    public int maxPathNAryTree_helper(TreeNaryNode n) {
        if (n == null) return 0;
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(2, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (TreeNaryNode leaf: n.leaves) {
            q.add(maxPathNAryTree_helper(leaf));
        }
        int oneLeafPath = q.isEmpty() ? n.data : q.peek() + n.data;
        int twoLeafPath = n.data;
        for (int i = 0; i < 2; i++) {
            twoLeafPath = twoLeafPath + (q.isEmpty() ? 0 : q.remove());
        }
        maxOverall = Math.max(maxOverall, twoLeafPath);
        return oneLeafPath;
    }


}
