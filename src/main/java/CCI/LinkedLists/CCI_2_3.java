package CCI.LinkedLists;

/**
 * @author Monali L on 4/26/2020
 */

public class CCI_2_3 {

    /* Implement an algorithm to delete a node in the middle of a
    single linked list, given only access to that node
    EXAMPLE
    input: the node ‘c’ from the linked list a->b->c->d->e
    Result: nothing is returned, but the new linked list looks like a->b->d->e
    */

    public static void deleteGivenNode(ListNode node) {

        // there is no way to get the previous node
        // there is - copy data from all the next nodes to this node and delete the last one

        if (node == null || node.next == null) return;
        ListNode nextNode = node.next;
        node.val = nextNode.val;
        node.next = nextNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        deleteGivenNode(n2);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

}
