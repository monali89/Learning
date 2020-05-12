package trees;

/**
 * Date: 6/3/2019
 * @author: Monali
 */

public class NaryTree {

    private TreeNaryNode root;

    public NaryTree(TreeNaryNode root){
        this.root = root;
    }

    public void addNode(int d){
        addNodeHelper(root, d);
    }

    public void addNodeHelper(TreeNaryNode node, int d){
        TreeNaryNode newLeaf = new TreeNaryNode(d, node.numOfLeaves);
        if(node.leaves.size() < node.numOfLeaves){
            node.leaves.add(newLeaf);
        }else{

        }
    }

    public void printPath(TreeNaryNode node){
        if(node == null) return;
        if(node.leaves == null) return;
        System.out.println(node.data);
        for(TreeNaryNode leaf: node.leaves){
            if(node.data - leaf.data == 1){
                printPath(leaf);
            }
        }
    }

}
