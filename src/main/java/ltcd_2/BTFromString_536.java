package ltcd_2;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTFromString_536 {

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

    public TreeNode str2tree(String s) {

        int i = 0;
        char c = s.charAt(i);
        String prev = ""; // String.valueOf(c);

        while ((c >= '0' && c <= '9') || c == '-') {
            prev = prev.concat(String.valueOf(c));
            c = s.charAt(++i);
        }

        TreeNode root = new TreeNode(Integer.parseInt(prev));
        prev = "";

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (!stack.isEmpty()) {
            c = s.charAt(i++);
            if (c == '(') {
                if (!prev.equals("")) {
                    TreeNode topNode = stack.peek();
                    TreeNode newNode = new TreeNode(Integer.parseInt(prev));
                    if (topNode.left == null) {
                        topNode.left = newNode;
                    } else {
                        topNode.right = newNode;
                    }
                    stack.push(newNode);
                    prev = "";
                }
            } else if ((c >= '0' && c <= '9') || c == '-') {
                prev = prev.concat(String.valueOf(c));
            } else if (c == ')' )
                stack.pop();
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        printTreeHelper(list);
    }

    public static void printTreeHelper(List<TreeNode> list) {
        if (list == null || list.size() <= 0) return;
        List<TreeNode> leafList = new ArrayList<TreeNode>();
        for (TreeNode n: list) {
            System.out.println(n.val);
            if (n.left != null) leafList.add(n.left);
            if (n.right != null) leafList.add(n.right);
        }
        printTreeHelper(leafList);
    }

    public static void main(String[] args) {
        BTFromString_536 object = new BTFromString_536();
        String input = "";
        TreeNode output = null;
        String expected = "";

        // example 1
        input = "4(2(3)(1))(6(5))";
        output = object.str2tree(input);
        printTree(output);
    }
}
