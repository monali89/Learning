package linklist;

/**
 * @author Monali L on 4/25/2020
 */
public class SinglyLinkedList {

    public class Node {
        int val;
        Node next;
        Node(int data) {
            this.val = data;
            next = null;
        }
    }

    private Node start;

    public Node getStart() {
        return start;
    }

    public SinglyLinkedList() {
        start = null;
    }

    // Length
    public int size() {
        int length = 0;
        Node temp = start;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    // Normal insert
    public Node insert(int data) {
        Node newNode = new Node(data);
        if (start == null) {
            start = newNode;
            return start;
        }
        Node curr = start;
        while(curr.next != null) curr = curr.next;
        curr.next = newNode;
        return start;
    }

    // insert - start/last/middle
    public void insert(int data, int pos) {
        Node newNode = new Node(data);
        if (start == null)  {
            start = newNode;
            return;
        }
        if (pos <= 1) {
            newNode.next = start;
            start = newNode;
            return;
        }
        Node curr = start;
        Node prev = null;
        int currPos = 1;
        while(curr != null) {
            if (currPos == pos) {
                prev.next = newNode;
                newNode.next = curr;
                return;
            }
            currPos++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = newNode;
    }

    // delete - start/end/middle
    public void delete(int data) {
        if (start == null) return;
        Node curr = start;
        Node prev = null;
        while(curr != null) {
            if (curr.val == data) {
                if (prev == null) {
                    start = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Get N'th - EASY

    // Reverse

    // To string
    public String getString() {
        String str = "[ ";
        Node curr = start;
        while (curr != null) {
            str = str.concat(curr.val + " ");
            curr = curr.next;
        }
        str = str + "]";
        return str;
    }



}
