package LeetCode;

import org.junit.Assert;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author: monali on 5/7/2019
 */

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        Assert.assertEquals(-1, cache.get(2)); // get - 2
        cache.put(2,6); // put - 2,6
        Assert.assertEquals(-1, cache.get(1)); // get - 1
        cache.put(1,5); // put - 1,5
        cache.put(1,2); // put - 1,2
        Assert.assertEquals(2, cache.get(1)); // get - 1
        Assert.assertEquals(6, cache.get(2)); // get - 2

        /*cache.put(1, 1);
        cache.put(2, 2);
        Assert.assertEquals(1,cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        Assert.assertEquals(2,cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        Assert.assertEquals(-1,cache.get(1));       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4*/
    }

    Map<Integer, Integer> map;
    Queue<Integer> q;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Integer>();
        q = new LinkedList<Integer>();
        cap = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            q.remove();
            q.add(key);
            return map.get(key);
        }else{
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.size() == cap){
            map.remove(q.remove());
            map.put(key, value);
            q.add(key);
        }else{
            map.put(key, value);
            q.add(key);
        }
    }
}


/*
* 146
* Design and implement a data structure for Least Recently Used (LRU) cache.
* It should support the following operations: get and put.
*
* get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
* put(key, value) - Set or insert the value if the key is not already present.
* When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
* */