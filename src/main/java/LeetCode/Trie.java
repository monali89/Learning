package LeetCode;

/**
 * @author Monali L on 5/5/2020
 * Problem (208): Implement a trie with insert, search, and startsWith methods.
 */

public class Trie {

    class Node {
        Node[] children = new Node[26];
        public Node() {}
        public void setNode(char c, Node node) {
            children[c - 'a'] = node;
        }
        public Node getNode(char c) {
            return children[c - 'a'];
        }
    }

    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] w = word.toCharArray();
        Node curr = root;
        for (int i = 0; i <w.length ; i++) {
            if (curr.children[w[i] - 'a'] == null) {
                Node n = new Node();
                curr.setNode(w[i], n);
            } else {
                curr = curr.getNode(w[i]);
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] w = word.toCharArray();
        Node curr = root;
        for (int i = 0; i < w.length; i++) {
            if (curr.children[w[i] - 'a'] != null) {
                curr = curr.getNode(w[i]);
            } else {
                return false;
            }
        }
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abc");
        System.out.println(trie.search("abc"));
    }
}
