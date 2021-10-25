package ltcd_2;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator_173 {

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

    class BSTIterator {

        List<TreeNode> inorder;
        int counter;

        public BSTIterator(TreeNode root) {
            this.inorder = new ArrayList<>();
            createInorderDS(root);
            counter = 0;
        }

        public int next() {
            return inorder.get(counter++).val;
        }

        public boolean hasNext() {
            return counter < inorder.size();
        }

        private void createInorderDS(TreeNode node) {
            if (node == null) return;
            createInorderDS(node.left);
            inorder.add(node);
            createInorderDS(node.right);
        }
    }
}
