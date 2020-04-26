package CCI.LinkedLists;

/**
 * @author Monali L on 4/26/2020
 */

public class CCI_2_5 {

    /*
    * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop
    * DEFINITION Circular linked list: A (corrupt) linked list in which a node’s next pointer points to an earlier node,
    * so as to make a loop in the linked list
    * EXAMPLE -> input: A -> B -> C -> D -> E -> C [the same C as earlier], output: C
    * */

    public static ListNode getNode(ListNode head) {

        ListNode t1 = head;
        ListNode t2 = head;

        while (t2.next != null) {
            t1 = t1.next;
            t2 = t2 = t2.next.next;
            if (t1 == t2) break;
        }

        if (t2.next == null) return null;

        t1 = head;
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        return t2;
    }

    public static void main(String[] args) {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n3;

        System.out.println(getNode(n1).val);

    }

}
