package CCI.StacksNQueues;

import org.junit.Assert;

/**
 * @author: monali on 5/10/2019
 */

public class ArrayQueue {

    public static void main(String[] args) {
        ArrayQueue q = new ArrayQueue(5);
        Assert.assertEquals(-1, q.dequeue());
        q.enqueue(2);
        q.enqueue(4);
        Assert.assertEquals(2, q.dequeue());
        q.enqueue(6);
        q.enqueue(3);
        q.enqueue(7);
        Assert.assertEquals(4, q.dequeue());
        q.enqueue(9);
        q.enqueue(2);
        Assert.assertEquals(false, q.enqueue(1));
    }

    int[] queue;
    int head;
    int tail;

    ArrayQueue(int capacity){
        queue = new int[capacity];
        head = tail = 0;
    }

    public boolean enqueue(int val){
        if(head == tail +1){
            System.out.println("Queue is full");
            return false;
        }else{
            queue[tail] = val;
            if(tail == queue.length) tail = 1;
            else tail++;
        }
        return true;
    }

    public int dequeue(){
        if(head == tail){
            System.out.println("Queue is empty");
            return -1;
        }else{
            int x = queue[head];
            if(head == queue.length) head = 1;
            else head++;
            return x;
        }
    }
}
