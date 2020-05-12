package LeetCode;

import trees.BinaryTree;
import trees.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Date: 6/5/2019
 * @author: Monali
 */

public class ClosestBSTValueII {

    @Test
    public void test01(){
        TreeNode root = new TreeNode(4);
        BinaryTree t = new BinaryTree(root);
        t.insert(root, 2);
        t.insert(root, 5);
        t.insert(root, 1);
        t.insert(root, 3);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        expected.add(3);
        List<Integer> actual = closestKValues(root, 3.714286, 2);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test02(){
        TreeNode root = new TreeNode(4);
        BinaryTree t = new BinaryTree(root);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(4);
        List<Integer> actual = closestKValues(root, 3.714286, 2);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void test03(){
        TreeNode root = new TreeNode(78);
        BinaryTree t = new BinaryTree(root);
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(78);
        List<Integer> actual = closestKValues(root, 3.714286, 2);
        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }

    PriorityQueue<Integer> queue;
    double t;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        t = target;
        queue = new PriorityQueue<Integer>(k, new Comparator<Integer>(){
            public int compare(Integer v1, Integer v2){
                if(Math.abs(v1 - t) > Math.abs(v2 - t)) return 1;
                return -1;
            }
        });

        List<Integer> rslt = new ArrayList<Integer>();
        helper(root);

        int i = 0;
        while(!queue.isEmpty() && i<k){
            rslt.add(queue.remove());
        }
        return rslt;
    }

    public void helper(TreeNode root){
        if(root == null) return;
        queue.add(root.getData());
        helper(root.getLeft());
        helper(root.getRight());
    }

}
