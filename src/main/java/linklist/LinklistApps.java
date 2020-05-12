package linklist;

/**
 * @author Monali L on 4/25/2020
 */
public class LinklistApps {

    public class Node {
        int val;
        Node next;
        Node(int data) {
            this.val = data;
            next = null;
        }
    }

    // Insertion of a node in Linked List (On the basis of some constraints) - Done
    // Delete a given node in Linked List (under given constraints) - Done

    // Compare two strings represented as linked lists
    public boolean isEqual(Node s1, Node s2) {
        Node c1 = s1;
        Node c2 = s2;
        while (c1 != null && c2 != null) {
            if (c1.val != c2.val) return false;
            c1 = c1.next;
            c2 = c2.next;
        }
        if (c1 != null || c2 != null) return false;
        return true;
    }

    // TODO: Add Two Numbers Represented By Linked Lists
    // TODO: Merge A Linked List Into Another Linked List At Alternate Positions
    // TODO: Reverse A List In Groups Of Given Size
    // TODO: Union And Intersection Of 2 Linked Lists
    // TODO: Detect And Remove Loop In A Linked List
    // TODO: Merge Sort For Linked Lists
    // TODO: Select A Random Node from A Singly Linked List

}
