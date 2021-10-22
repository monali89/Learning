package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {

    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int d){
        this.data = d;
        left = null;
        right = null;
    }

    public TreeNode(){}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void printTree(TreeNode root) {

        if (root == null) return;

        List<TreeNode> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int count = 1;

        while (!queue.isEmpty()) {
            int next = 0;

            for (int i = 0; i < count; i++) {

                TreeNode curr = queue.remove();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    queue.add(curr.left);
                    next++;
                } else {
                    System.out.print("null ");
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                    next++;
                } else {
                    System.out.print("null ");
                }
            }
            count = next;
        }

        System.out.println();
    }

}
