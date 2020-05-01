package LeetCode;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author Monali L on 4/29/2020
 */

public class TreeFromPreInorder {

    public static void main(String[] args) {
        int[] pre = {1,2}; //{3,9,4,19,20,15,7};
        int[] in = {2,1}; //{4,9,19,3,15,20,7};
        TreeNode root = buildTree(pre, in);
        printInorder(root);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length <= 0 || inorder.length == 0) return null;
        //return helper(preorder, inorder, 0);
        return helper(preorder, inorder);
    }

    public static TreeNode helper(int[] pre, int[] in, int ind) {

        System.out.println("DEBUG: pre - " + pre.length + ", in - " + in.length + ", ind - " + ind);
        if (ind < 0 || (in.length != pre.length) || ind >= pre.length || ind >= in.length) return null;

        if (pre.length <= 0 || in.length <= 0) return null;

        TreeNode n = new TreeNode(pre[ind]);
        if (pre.length == 1 && in.length == 1) return n;

        int curr = 0;
        while (in[curr] != pre[ind]) curr++;
        n.left = helper(Arrays.copyOfRange(pre, ind+1, curr+1),
                Arrays.copyOfRange(in, 0, curr), ind+1);
        n.right = helper(Arrays.copyOfRange(pre, curr+1, pre.length),
                Arrays.copyOfRange(in, curr+1, in.length), ind+2);

        return n;
    }

    public static TreeNode helper(int[] pre, int[] in) {

        System.out.println("DEBUG: pre - " + pre.length + ", in - " + in.length);
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

    public static void printInorder(TreeNode n) {
        if (n == null) return;
        printInorder(n.left);
        System.out.println(n.val);
        printInorder(n.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
