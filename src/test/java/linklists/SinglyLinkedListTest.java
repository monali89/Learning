package linklists;

import linklist.SinglyLinkedList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Monali L on 4/25/2020
 */
public class SinglyLinkedListTest {

    SinglyLinkedList ll;

    @Before
    public void beforeTest() {
        ll = new SinglyLinkedList();
    }

    @Test
    public void test_insert() {
        ll.insert(1);
        ll.insert(2);
        ll.insert(4);
        ll.insert(5);
        Assert.assertEquals("[ 1 2 4 5 ]", ll.getString());
        ll.insert(3, 3);
        Assert.assertEquals("[ 1 2 3 4 5 ]", ll.getString());
        ll.insert(0, 1);
        Assert.assertEquals("[ 0 1 2 3 4 5 ]", ll.getString());
        ll.insert(6, 7);
        Assert.assertEquals("[ 0 1 2 3 4 5 6 ]", ll.getString());
    }

    @Test
    public void test_insert_delete() {
        ll.insert(1);
        ll.insert(2);
        ll.insert(4);
        ll.insert(5);
        Assert.assertEquals("[ 1 2 4 5 ]", ll.getString());
        ll.insert(3, 3);
        Assert.assertEquals("[ 1 2 3 4 5 ]", ll.getString());
        ll.insert(0, 1);
        Assert.assertEquals("[ 0 1 2 3 4 5 ]", ll.getString());
        ll.insert(6, 7);

        ll.delete(10);
        Assert.assertEquals("[ 0 1 2 3 4 5 6 ]", ll.getString());
        ll.delete(6);
        Assert.assertEquals("[ 0 1 2 3 4 5 ]", ll.getString());
        ll.delete(0);
        Assert.assertEquals("[ 1 2 3 4 5 ]", ll.getString());
        ll.delete(3);
        Assert.assertEquals("[ 1 2 4 5 ]", ll.getString());
    }



}
