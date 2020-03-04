package LeetCode;

import CCI.LinkedLists.LinkList;
import CCI.LinkedLists.ListNode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author: monali on 5/11/2019
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode h1 = new ListNode(1);
        LinkList l1 = new LinkList(h1);
        l1.addNode(4);
        l1.addNode(5);

        ListNode h2 = new ListNode(1);
        LinkList l2 = new LinkList(h2);
        l1.addNode(3);
        l1.addNode(4);

        ListNode h3 = new ListNode(2);
        LinkList l3 = new LinkList(h3);
        l1.addNode(6);

        List<ListNode> all = new LinkedList<ListNode>();
        all.add(h1);
        all.add(h2);
        all.add(h3);

        ListNode h4 = mergeKLists(all);

        while(h4 != null){
            System.out.print(h4.val + " ");
            h4 = h4.next;
        }
    }


    public static ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;

        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });

        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;

        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);

        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;

            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
