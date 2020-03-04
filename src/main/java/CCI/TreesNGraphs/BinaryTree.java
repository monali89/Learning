package CCI.TreesNGraphs;

import java.util.*;

public class BinaryTree {

    private TreeNode node;

    public BinaryTree(TreeNode node) {
        this.node = node;
    }

    /*
    * 4.3: Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height
    * */
    public TreeNode insert(TreeNode treeNode, int d) {
        if (treeNode == null) {
            return new TreeNode(d);
        } else if (d < treeNode.data) {
            treeNode.left = insert(treeNode.left, d);
        } else treeNode.right = insert(treeNode.right, d);

        if (!isBalanced(treeNode)) {
            treeNode = balanceTree(treeNode, d);
        }
        return treeNode;
    }

    public TreeNode balanceTree(TreeNode treeNode, int d) {
        int diff = getHeight(treeNode.left) - getHeight(treeNode.right);

        if(diff > 0){
            if (treeNode.left != null && d < treeNode.left.data) return rightRotate(treeNode);
            if (treeNode.left != null && d > treeNode.left.data) return leftRightRotate(treeNode);
        }else if (diff < 0){
            if (treeNode.right != null && d > treeNode.right.data) return leftRotate(treeNode);
            if (treeNode.right != null && d < treeNode.right.data) return rightLeftRotate(treeNode);
        }
        return treeNode;
    }

    public TreeNode leftRotate (TreeNode treeNode){
        TreeNode newRoot = treeNode.right;
        TreeNode rightsLeftChild = treeNode.right.left;
        treeNode.right.left = treeNode;
        treeNode.right = rightsLeftChild;
        return newRoot;
    }

    public TreeNode leftRightRotate (TreeNode treeNode){
        TreeNode rootsLeftChild = treeNode.left;
        treeNode.left = treeNode.left.right;
        TreeNode replacementsLeftChild = treeNode.left.left;
        rootsLeftChild.right = replacementsLeftChild;
        treeNode.left.left = rootsLeftChild;
        return leftRotate(treeNode);
    }

    public TreeNode rightRotate (TreeNode treeNode){
        TreeNode newRoot = treeNode.left;
        TreeNode leftsRightChild = treeNode.left.right;
        treeNode.left.right = treeNode;
        treeNode.left = leftsRightChild;
        return newRoot;
    }

    public TreeNode rightLeftRotate (TreeNode treeNode){
        TreeNode rootsRightChild = treeNode.right; // Y
        treeNode.right = treeNode.right.left; // X
        TreeNode replacementsRightChild = treeNode.right.right;
        rootsRightChild.left = replacementsRightChild;
        treeNode.right.right = rootsRightChild;
        return leftRotate(treeNode);
    }

    public int getHeight (TreeNode n){
        int hl = 0, hr = 0;
        if (n == null) {
            return 0;
        } else {
            hl = getHeight(n.left);
            hr = getHeight(n.right);
            return Math.max(hl + 1, hr + 1);
        }
    }

    public boolean isBalanced (TreeNode n){
        if (n == null) {
            return false;
        } else {
            int hl, hr;
            hl = getHeight(n.left);
            hr = getHeight(n.right);
            return Math.abs(hl - hr) <= 1;
        }
    }

    public void printInorder (TreeNode root){
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public void printPreorder (TreeNode root){
        if (root != null) {
            System.out.print(root.data + " ");
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public void printPostorder (TreeNode root){
        if (root != null) {
            printPostorder(root.left);
            printPostorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void printBFS(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.peek();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            System.out.print(curr.data + " ");
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            queue.remove();
        }
        System.out.println();
    }


    /*
    * 4.4: Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth
    * (i.e., if you have a tree with depth D, you’ll have D linked lists).
    * */
    public void printLevelOrder(TreeNode root){

        List<List<TreeNode>> treeList = new ArrayList<List<TreeNode>>();
        List<TreeNode> innerl = new ArrayList<TreeNode>();
        innerl.add(root);
        treeList.add(innerl);

        int depth = getHeight(root);
        for (int i = 0; i < depth; i++) levelOrderHelp(treeList);

        for (int i = 0; i < depth; i++){
            System.out.print("Dept " + i + " - ");
            List<TreeNode> c = treeList.get(i);
            for(TreeNode t: c)System.out.print(t.data + " ");
            System.out.println();
        }
    }

    public void levelOrderHelp(List<List<TreeNode>> list){
        List<TreeNode> last = list.get(list.size()-1);
        List<TreeNode> curr = new ArrayList<TreeNode>();
        for(TreeNode t: last){
            if(t.left != null) curr.add(t.left);
            if(t.right != null) curr.add(t.right);
        }
        list.add(curr);
    }

    /*
    * 4.6: Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
    * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
    * */
    public TreeNode getCommonAncestor(TreeNode root, int n1, int n2){

        if(root == null) return null;
        if(root.data == n1 && (searchBFS(root.left, n2) || searchBFS(root.right, n2))) return root;
        if(root.data == n2 && (searchBFS(root.left, n1) || searchBFS(root.right, n1))) return root;
        if(searchBFS(root.left, n1) && searchBFS(root.right, n2)) return root;
        if(getCommonAncestor(root.left, n1, n2) != null) return root.left;
        if(getCommonAncestor(root.right, n1, n2) != null) return root.right;
        return null;
    }

    public boolean searchBFS(TreeNode root, int val){
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.peek();
            if(visited.contains(curr)) continue;
            visited.add(curr);
            if(curr.data == val) return true;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
            queue.remove();
        }
        return false;
    }

    /*
    * 4.7: You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
    * Create an algorithm to decide if T2 is a subtree of T1.
    * */
    public boolean isSubtree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.data == root2.data && isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right)) return true;
        else return isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    /*
    * 4.8: You are given a binary tree in which each node contains a value.
    * Design an algorithm to print all paths which sum up to that value.
    * Note that it can be any path in the tree - it does not have to start at the root.
    * */
    public List<List<Integer>> getSumPaths(TreeNode root, int sum, List<List<Integer>> l){


        return null;
    }

    /*
    * Iterative tree traversals
    * */

    public void printInorderItr(TreeNode root){

        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }

    public void printPreorderItr(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        stack.push(curr);

        while(!stack.isEmpty()){
            curr = stack.pop();
            System.out.print(curr.data + " ");
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        System.out.println();
    }

    public void printPostorderItr(TreeNode root){
        if(root == null) return;
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        TreeNode curr = root;
        s1.push(curr);
        while(!s1.isEmpty()){
            curr = s1.pop();
            s2.push(curr);
            if(curr.right != null) s1.push(curr.right);
            if(curr.left != null) s1.push(curr.left);
        }
        while(!s2.isEmpty()) System.out.print(s2.pop().data + " ");
        System.out.println();
    }

}



















