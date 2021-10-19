package ltcd_2;

import trees.TreeNode;

import java.util.Arrays;

public class BTFromPreInTraversal_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length == 0) return null;
        return helper(preorder, inorder);
    }

    public static TreeNode helper(int[] pre, int[] in) { // ind = 0

        if ((in.length != pre.length) || pre.length <= 0) return null;

        TreeNode n = new TreeNode(pre[0]);
        if (pre.length > 1) {
            int curr = 0;
            while (in[curr] != pre[0]) curr++;
            n.left = helper(Arrays.copyOfRange(pre, 1, curr+1),
                    Arrays.copyOfRange(in, 0, curr));
            n.right = helper(Arrays.copyOfRange(pre, curr+1, pre.length),
                    Arrays.copyOfRange(in, curr+1, in.length));

        }
        return n;
    }

    private TreeNode helper_2(int[] pre, int sp, int ep, int[] in, int si, int ei) {

        if (sp > ep || si > ei) return null;

        TreeNode node = new TreeNode(pre[sp]);

        // find start node from preorder in inorder
        int ctr = si;
        while (ctr < in.length && in[ctr] != pre[sp]) ctr++;

        // everything left to ctr in inorder will go to left subtree
        node.left = helper_2(pre, sp+1, ep, in, si, ctr-1);

        // everything right to ctr in inorder will go to left subtree
        node.right = helper_2(pre, sp+2, ep, in, ctr+1, ei);

        return node;
    }
}
