package LeetCode;

import trees.BinaryTree;
import trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: monali on 5/8/2019
 */

public class SerializeDeserializeBT extends TreeNode {

    TreeNode root;
    BinaryTree bt;

    @Before
    public void setup(){
        root = new TreeNode(1);
        bt = new BinaryTree(root);
        root = bt.insert(root, 2);
        root = bt.insert(root, 3);
        root = bt.insert(root, 4);
        root = bt.insert(root, 5);
    }

    @Test
    public void test01(){
        Assert.assertEquals("", serialize(root));
    }

    String r;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) return "[]";
        List<TreeNode> l = new ArrayList<TreeNode>();
        r = "[" + root.getData();
        l.add(root);
        int h = getHeight(root);
        for(int i=1; i<=h; i++){
            l = helper(l);
        }
        r = r + "]";
        return r;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        data = data.replace("[", "");
        data = data.replace("]", "");
        System.out.println(data);

        String[] d = data.split(",");

        if(d.length < 1) return null;

        List<TreeNode> l = new ArrayList<TreeNode>();
        TreeNode root = new TreeNode(Integer.valueOf(d[0]));
        l.add(root);

        int i = 1;

        while(i < d.length){
            List<TreeNode> cl = new ArrayList<TreeNode>();
            for(TreeNode t: l){
                System.out.println(d[i]);
                if(i < d.length && d[i] != "null"){
                    t.setLeft(new TreeNode(Integer.valueOf(d[i++])));
                    cl.add(t.getLeft());
                }else{
                    //t.left = null;
                    i++;
                }
                System.out.println(d[i]);
                if(i < d.length && d[i] != "null"){
                    t.setRight(new TreeNode(Integer.valueOf(d[i++])));
                    cl.add(t.getRight());
                }else{
                    //t.right = null;
                    i++;
                }
            }
            l = cl;
        }
        return root;
    }

    public List<TreeNode> helper(List<TreeNode> l){
        List<TreeNode> cl = new ArrayList<TreeNode>();
        for(TreeNode t: l){
            if(t.getLeft() != null){
                cl.add(t.getLeft());
                r = r + "," + t.getLeft().getData();
            } else{
                r = r + ",null";
            }
            if(t.getRight() != null){
                cl.add(t.getRight());
                r = r + "," + t.getRight().getData();
            } else{
                r = r + ",null";
            }
        }
        return cl;
    }

    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return Math.max(getHeight(root.getLeft()), getHeight(root.getRight())) + 1;
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
