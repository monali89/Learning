package CCI.LinkedLists;

public class LinkListMain {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        LinkList l = new LinkList(head);
        l.addNode(2);
        l.addNode(3);
        l.printList();
        l.reverseList();
        l.printList();
    }



}
