package ltcd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Monali L on 4/29/2020
 */

public class HouseRobberIII {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int rob(TreeNode root) {

        int even = root.val;
        int odd = 0;
        boolean flag = false; // start with even
        List<TreeNode> lp = new ArrayList<TreeNode>();
        lp.add(root);
        List<TreeNode> lc = new ArrayList<TreeNode>();

        while (true) {
            for(TreeNode n: lp) {
                System.out.println("DEBUG: node - " + n.val);
                int total = 0;
                if(n.left != null) {
                    lc.add(n.left);
                    total = total + n.left.val;
                }
                if(n.right != null) {
                    lc.add(n.right);
                    total = total + n.right.val;
                }
                if (flag) {
                    System.out.println("DEBUG: even");
                    even = even + total;
                } else {
                    System.out.println("DEBUG: odd");
                    odd = odd + total;
                }
                System.out.println("DEBUG: total - " + total);
            }
            if(lc.size() == 0) break;
            flag = !flag;
            lp.clear();
            lp.addAll(lc);
            lc.clear();
            System.out.println("DEBUG: new lp - " + lp);
            System.out.println();
        }
        return Math.max(even, odd);
    }

    public static void main(String[] args) {

        /*TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.left = n5;

        System.out.println(rob(n1));*/


        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(3);

        n1.left = n2;
        n2.left = n3;
        n3.left = n4;

        System.out.println(rob(n1));

    }

}
