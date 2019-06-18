package CCI.LinkedLists;

import java.util.HashSet;

public class CCI_2_1 {

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
        removeDuplicates_2(head);
        l.printList();
    }

    public static void removeDuplicates_1(ListNode head){
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode current = head;
        ListNode previous = head;
        while(current != null){
            if(set.contains(current.val)){
                previous.next = current.next;
            }else{
                set.add(current.val);
            }
            previous = current;
            current = current.next;
        }
    }

    public static void removeDuplicates_2(ListNode head){
        ListNode current = head;
        while(current != null){
            ListNode previous = current;
            ListNode faster = current.next;
            while(faster != null){
                if(current.val == faster.val){
                    previous.next = faster.next;
                }
                previous = faster;
                faster = faster.next;
            }
            current = current.next;
        }
    }
}


/*
* Write code to remove duplicates from an unsorted linked list.
* FOLLOW UP
* How would you solve this problem if a temporary buffer is not allowed?
* */