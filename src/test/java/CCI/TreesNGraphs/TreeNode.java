package CCI.TreesNGraphs;

public class TreeNode {

    protected int data;
    protected TreeNode left;
    protected TreeNode right;

    public TreeNode(int d){
        this.data = d;
        left = null;
        right = null;
    }

    public TreeNode(){}

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
