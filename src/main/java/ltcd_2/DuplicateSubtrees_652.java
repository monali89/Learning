package ltcd_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateSubtrees_652 {

    class TreeNode {
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

    private Map<Integer, int[]> map;
    private TreeNode duplicate;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<Integer, int[]>();
        helper(root);
        return null;
    }

    private boolean helper(TreeNode node) {
        if (node == null) return true;

        if (map.containsKey(node.val)) {
            int[] leaf = map.get(node.val);
            if (leaf[0] == -1 && leaf[1] == -1) return true;
            else return helper(node.left) && helper(node.right);
        } else {
            int[] leaf = new int[2];
            leaf[0] = node.left != null ? node.left.val : -1;
            leaf[1] = node.right != null ? node.right.val : -1;
            map.put(node.val, leaf);
            helper(node.left);
            helper(node.right);
            return false;
        }
    }

}
