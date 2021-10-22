package ltcd_2;

import java.util.ArrayList;
import java.util.List;

public class PathSumII_113 {

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> rslt = new ArrayList<List<Integer>>();
        List<Integer> l = new ArrayList<Integer>();
        helper(root, sum, 0, l, rslt);
        return rslt;
    }

    private void helper(TreeNode n, int sum, int curr_sum, List<Integer> l, List<List<Integer>> all) {

        if (n == null) return;

        // System.out.println(n.val + " | " + curr_sum + " | " + l + " | " + all);

        if (n.left == null && n.right == null) { //this is a leaf node

            if (n.val + curr_sum == sum) {
                l.add(n.val);
                List<Integer> new_l = new ArrayList<>(l);
                all.add(new_l);
                l.remove(l.size() - 1);
            }

        } else {

            l.add(n.val);

            if (n.left != null) {
                helper(n.left, sum, curr_sum + n.val, l, all);
            }

            if (n.right != null) {
                helper(n.right, sum, curr_sum + n.val, l, all);
            }

            l.remove(l.size() - 1);
        }

    }

    public static void main(String[] args) {

        PathSumII_113 obj = new PathSumII_113();

        TreeNode lb = new TreeNode(11, new TreeNode(7), new TreeNode(2));
        TreeNode rb = new TreeNode(4, new TreeNode(5), new TreeNode(1));
        TreeNode lm = new TreeNode(4, lb, null);
        TreeNode rm = new TreeNode(8, new TreeNode(13), rb);
        TreeNode root = new TreeNode(5, lm, rm);

        System.out.println(obj.pathSum(root, 22));

    }
}
