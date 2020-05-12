import org.junit.Before;
import org.junit.Test;
import trees.BinaryTree;
import trees.TreeNode;
import trees.TreeProblems;

/**
 * @author Monali L on 4/24/2020
 */
public class TreesTest {

    TreeProblems obj;

    @Before
    public void beforeTest() {
        obj = new TreeProblems();
    }

    @Test
    public void test_levelOrder() {
        TreeNode node = new TreeNode(10);
        BinaryTree bt = new BinaryTree(node);
        bt.insert(node, 5);
        bt.insert(node, 19);
        bt.insert(node, 1);
        bt.insert(node, 8);
        bt.insert(node, 17);
        bt.insert(node, 21);
        bt.insert(node, 6);
        bt.insert(node, 9);
        bt.printLevelOrder(node);
    }

    @Test
    public void test_maxPathNAryTree() {
        obj.maxPathNAryTree();
    }

}
