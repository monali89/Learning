package CCI.LinkedLists;

import java.util.List;

/**
 * @author Monali L on 4/26/2020
 */

public class CCI_2_2 {

    // Implement an algorithm to find the nth to last element of a singly linked list

    public static int getNthNode(ListNode head, int pos) {

        // Easy - traverse the list twice
        // Using two pointers, p1, p2 - increment by n-1 pos
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < pos-1; i++) {
            if (p2 == null) return -1;
            p2 = p2.next;
        }
        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1.val;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        LinkList l = new LinkList(head);
        l.addNode(3);
        l.addNode(7);
        l.addNode(2);
        l.addNode(9);
        l.addNode(3);
        l.addNode(8);
        l.printList();

        System.out.println("Get 3rd node - " + getNthNode(head, 3));
        System.out.println("Get non existing node - " + getNthNode(head, 10));
        System.out.println("Get 1st node - " + getNthNode(head, 1));
        System.out.println("Get last node - " + getNthNode(head, 7));

    }

}
