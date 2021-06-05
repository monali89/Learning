package ltcd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 5/1/2020
 * Problem: Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */

public class UniqueBSTII {

    public static void main(String[] args) {
        List<TreeNode> trees = generateTrees(3);
        for (TreeNode root: trees) {
            printInorder(root);
            System.out.println();
        }
    }

    public static List<TreeNode> generateTrees(int n) {
        return helper(1, n);
    }

    public static List<TreeNode> helper(int s, int e) {
        List<TreeNode> l = new ArrayList<TreeNode>();
        if (s > e) l.add(null);
        for (int i = s; i <= e; i++) {
            List<TreeNode> leftTrees = helper(s, i-1);
            List<TreeNode> rightTrees = helper(i+1, e);
            for (TreeNode left: leftTrees) {
                for (TreeNode right: rightTrees) {
                    TreeNode n = new TreeNode(i);
                    n.left = left;
                    n.right = right;
                    l.add(n);
                }
            }
        }
        return l;
    }

    public static void printInorder(TreeNode n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.println(n.val);
        printInorder(n.right);
    }

}
