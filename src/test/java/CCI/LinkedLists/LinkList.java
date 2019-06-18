package CCI.LinkedLists;

public class LinkList {

    ListNode head;

    public LinkList(ListNode head){
        this.head = head;
    }

    public void addNode(int val){
        ListNode node = new ListNode(val);
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
    }

    public void printList(){
        ListNode temp = this.head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void reverseList(){

        if(this.head == null) return;
        if(this.head.next == null) return;

        ListNode before = null;
        ListNode curr = this.head;
        ListNode after;

        while(curr != null){
            after = curr.next;
            curr.next = before;
            before = curr;
            curr = after;
        }
        head = before;
    }

    public void reverseBetween(int m, int n){

    }

}








