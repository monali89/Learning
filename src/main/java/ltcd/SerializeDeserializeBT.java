package ltcd;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author: monali on 5/8/2019
 */

public class SerializeDeserializeBT extends TreeNode {

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) return "[]";

        List<String> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();

        int count = 1;
        queue.add(root);

        while (!queue.isEmpty()) {

            int next = 0;

            for (int i = 0; i < count; i++) {

                TreeNode curr = queue.remove();

                if (curr.val == -2000) {
                    list.add("null");
                } else {
                    list.add(String.valueOf(curr.val));

                    queue.add((curr.left != null) ? curr.left : new TreeNode(-2000));
                    queue.add((curr.right != null) ? curr.right : new TreeNode(-2000));
                    next = next+2;
                }
            }
            count = next;
        }

        String temp = list.get(list.size()-1);
        while (temp.equals("null")) {
            list.remove(list.size()-1);
            temp = list.get(list.size()-1);
        }

        StringBuilder result = new StringBuilder();
        result.append("[");

        for (String s : list) {
            result.append(s);
            result.append(",");
        }
        result.deleteCharAt(result.length()-1);
        result.append("]");

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() <= 2) return null;

        data = data.replace("[", "");
        data = data.replace("]", "");
        String[] arr = data.split(",");

        if (arr.length == 0) return null;

        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        int ctr = 1;

        while (ctr < arr.length && !queue.isEmpty()) {
            TreeNode curr = queue.remove();

            if (!arr[ctr].equals("null")) {
                curr.left = new TreeNode(Integer.parseInt(arr[ctr]));
                queue.add(curr.left);
            }
            ctr++;

            if (ctr < arr.length && !arr[ctr].equals("null")) {
                curr.right = new TreeNode(Integer.parseInt(arr[ctr]));
                queue.add(curr.right);
            }
            ctr++;
        }

        return root;
    }

    public static void main(String[] args) {

        SerializeDeserializeBT object = new SerializeDeserializeBT();
        String input = "";
        TreeNode root;

        input = "[1,2,3,null,null,4,5]";
        root = object.deserialize(input);
        System.out.println(object.serialize(root));

        input = "[]";
        root = object.deserialize(input);
        System.out.println(object.serialize(root));

        input = "[1]";
        root = object.deserialize(input);
        System.out.println(object.serialize(root));

        input = "[1,2]";
        root = object.deserialize(input);
        System.out.println(object.serialize(root));

    }

}


/*
* 297
* Serialization is the process of converting a data structure or object into a sequence of
* bits so that it can be stored in a file or memory buffer, or transmitted across a network
* connection link to be reconstructed later in the same or another computer environment.
*
* Design an algorithm to serialize and deserialize a binary tree. There is no restriction
* on how your serialization/deserialization algorithm should work. You just need to ensure
* that a binary tree can be serialized to a string and this string can be deserialized to
* the original tree structure.
*
* */
