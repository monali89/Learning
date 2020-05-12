package LeetCode;

/**
 * @author Monali L on 5/5/2020
 * Problem (124): Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the root.
 */

public class BTMaxPathSum {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int maxOverall = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        int max = helper(root);
        return Math.max(maxOverall, max);
    }

    /*
    Possible paths
    1. Passes through root, with either left or right
    2. Root completes path, with left and right
    3.
    */

    private static int helper(TreeNode n) {

        int l = n.left != null ? Math.max(helper(n.left), 0) : 0;
        int r = n.right != null ?  Math.max(helper(n.right), 0) : 0;
        int p1 = l + r + n.val;
        int p2 = l + n.val;
        int p3 = r + n.val;
        int pathHere = Math.max(p2, p3);
        maxOverall = Math.max(maxOverall, p1);
        return pathHere;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(-1);
        TreeNode n3 = new TreeNode(-2);
        n1.left = n2;
        n1.right = n3;

        System.out.println(maxPathSum(n1));
    }
}
