package ltcd_2;

import trees.TreeNode;

import java.util.Arrays;

public class BTFromPreInTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length <= 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }

    private TreeNode helper(int[] pre, int sp, int ep, int[] in, int si, int ei) {

        if (sp > ep || si > ei) return null;

        TreeNode node = new TreeNode(pre[sp]);

        // find start node from preorder in inorder
        int ctr = si;
        while (ctr < in.length && in[ctr] != pre[sp]) ctr++;

        // everything left to ctr in inorder will go to left subtree
        if (si <= (ctr-1)) sp = sp+1;
        node.left = helper(pre, sp, ep, in, si, ctr-1);

        // everything right to ctr in inorder will go to left subtree
        if ((ctr+1) <= ei) sp = sp+1;
        node.right = helper(pre, sp, ep, in, ctr+1, ei);

        return node;
    }

    public static void main(String[] args) {
        BTFromPreInTraversal_105 object = new BTFromPreInTraversal_105();
        int[] preorder;
        int[] inorder;
        TreeNode root;

        // test 1
        preorder = new int[] {3,1,2,4};
        inorder = new int[] {1,2,3,4};
        root = object.buildTree(preorder, inorder);
        root.printTree(root);
    }
}
