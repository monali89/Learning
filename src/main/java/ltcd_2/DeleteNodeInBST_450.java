package ltcd_2;

import java.util.Stack;

public class DeleteNodeInBST_450 {

    public class TreeNode {
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

    public TreeNode deleteNode(TreeNode root, int key) {

        TreeNode parent = null;
        TreeNode curr = root;

        while (curr != null && curr.val != key) {
            parent = curr;
            if (key < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }

        if (curr == null) return null;

        // case 1
        if (curr.left == null && curr.right == null) {
            if (curr != root) {
                if (parent.left == curr) parent.left = null;
                else parent.right = null;
            } else {
                root = null;
            }
        }

        // case 2
        if (parent != null && (curr.left == null || curr.right == null) ){

            TreeNode child = curr.left != null ? curr.left : curr.right;
            if (curr == root) {
                root = child;
            }

            if (parent.left == curr) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        }

        // case 3
        if (curr.left != null && curr.right != null) {
            TreeNode successor = getMinSuccessor(curr.right);
            int val = successor.val;
            deleteNode(root, successor.val);
            curr.val = val;
        }

        return root;
    }

    private TreeNode getMinSuccessor(TreeNode n) {
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }

    public static void main(String[] args) {

    }
}


/*
* 1. Deleting node with no children: simply remove the node
* 2. Deleting node with one child:
*       Delete the node and replace it with it's child
* 3. Deleting node with both the children:
*       Choose either it's predecessor or successor
*       Which to choose depends on the height of both child
*       If left heavy choose predecessor
*       If right heavy choose successor
* */
