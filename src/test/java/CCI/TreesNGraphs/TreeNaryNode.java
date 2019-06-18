package CCI.TreesNGraphs;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 6/3/2019
 * @author: Monali
 */

public class TreeNaryNode {

    protected int data;
    protected int numOfLeaves;
    protected List<TreeNaryNode> leaves;

    public TreeNaryNode(int data, int numOfLeaves){
        this.data = data;
        this.numOfLeaves = numOfLeaves;
        leaves = new ArrayList<TreeNaryNode>();
    }

    public TreeNaryNode(){}

    public List getLeaves(TreeNaryNode node){
        return node.leaves;
    }
}
