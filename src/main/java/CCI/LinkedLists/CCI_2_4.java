package CCI.LinkedLists;

/**
 * @author Monali L on 4/26/2020
 */

public class CCI_2_4 {

    /*
    * You have two numbers represented by a linked list, where each node contains a single digit
    * The digits are stored in reverse order, such that the 1’s digit is at the head of the list
    * Write a function that adds the two numbers and returns the sum as a linked list
    * EXAMPLE -> Input: (3 -> 1 -> 5) + (5 -> 9 -> 2) Output: 8 -> 0 -> 8
    * */

    public static ListNode sumLinkLists(ListNode h1, ListNode h2) {

        ListNode h3 = null;
        ListNode t1 = h1;
        ListNode t2 = h2;
        ListNode t3 = h3;
        int sum = 0;
        int carry = 0;

        while (t1 != null && t2 != null) {
            sum = t1.val + t2.val + carry;
            if (sum > 9) {
                carry = sum % 10;
                sum = sum/10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            if (h3 == null) {
                h3 = newNode;
                t3 = h3;
            } else {
                t3.next = newNode;
                t3 = newNode;
            }
            System.out.println("DEBUG: newNode - " + newNode.val + ", carry - " + carry);
            t1 = t1.next;
            t2 = t2.next;
        }

        while (t1 != null) {
            sum = t1.val + carry;
            if (sum > 9) {
                carry = sum % 10;
                sum = sum/10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            System.out.println("DEBUG: newNode - " + newNode.val + ", carry - " + carry);
            t3.next = newNode;
            t3 = newNode;
            t1 = t1.next;
        }

        while (t2 != null) {
            sum = t2.val + carry;
            if (sum > 9) {
                carry = sum % 10;
                sum = sum/10;
            } else {
                carry = 0;
            }
            ListNode newNode = new ListNode(sum);
            System.out.println("DEBUG: newNode - " + newNode.val + ", carry - " + carry);
            t3.next = newNode;
            t3 = newNode;
            t2 = t2.next;
        }

        if (carry > 0) {
            t3.next = new ListNode(carry);
        }

        return h3;
    }

    /*public static ListNode addTwoNodes(ListNode n1, ListNode n2, int carry) {
        int sum = n1.val + n2.val + carry;
        if ()
    }*/

    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        LinkList l1 = new LinkList(h1);
        l1.addNode(1);
        l1.addNode(5);

        ListNode h2 = new ListNode(5);
        LinkList l2 = new LinkList(h2);
        l2.addNode(9);
        l2.addNode(2);

        ListNode h3 = sumLinkLists(h1, h2);
        LinkList l3 = new LinkList(h3);
        l3.printList();
    }

}
