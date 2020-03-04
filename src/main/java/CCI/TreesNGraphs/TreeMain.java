package CCI.TreesNGraphs;

public class TreeMain {

    public static void main(String[] args){

        TreeNode root = new TreeNode(1);
        BinaryTree bt = new BinaryTree(root);

        for (int i = 2; i <= 8; i++) root = bt.insert(root, i);

        System.out.println("Inorder Traversal");
        bt.printInorder(root);
        System.out.println();
        bt.printInorderItr(root);

        System.out.println("Preorder Traversal");
        bt.printPreorder(root);
        System.out.println();
        bt.printPreorderItr(root);

        System.out.println("Postorder Traversal");
        bt.printPostorder(root);
        System.out.println();
        bt.printPostorderItr(root);

        /*System.out.print("BFS - ");
        bt.printBFS(root);*/
        /*System.out.println("Level Order");
        bt.printLevelOrder(root);*/

        /*TreeNode commonAncestor = bt.getCommonAncestor(root, 1, 2);
        if(commonAncestor != null) System.out.println(commonAncestor.data);
        else System.out.println("Not Found");*/

        /*TreeNode root2 = new TreeNode(6);
        BinaryTree bt2 = new BinaryTree(root2);
        root2 =  bt2.insert(root2, 5);
        root2 =  bt2.insert(root2, 7);
        root2 =  bt2.insert(root2, 8);
        System.out.println(bt.isSubtree(root, root2));*/


    }
}
