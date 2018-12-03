package cn.itcast.day1130Trie;

import java.util.TreeMap;

public class Trie {

    class Node {

        boolean isWord;
        TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    // Trie的根节点
    private Node root;
    // 记录Trie的单词数
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String words) {
        Node cur = root;

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    // recursion add

    public boolean addRecur(String words) {
        Node cur = root;
        return addR(words, cur, 0);
    }

    private boolean addR(String words, Node node, int index) {
        // 递归到底
        if (index == words.length() - 1) {
            if (node.next.get(words.charAt(index)) == null) {
                node.next.put(words.charAt(index), new Node());
                size++;
                node.isWord = true;
            }
            return node.isWord;
        }

        //递归操作
        if (node.next.get(words.charAt(index)) == null)
            node.next.put(words.charAt(index), new Node());
        return addR(words, node.next.get(words.charAt(index)), ++index);

    }

    public boolean contains(String words) {

        Node cur = root;

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) != null)
                cur = cur.next.get(c);
            else
                return false;
        }

        return cur.isWord;
    }

    // 判断一个单词是不是前缀树中某个单词的前缀
    public boolean isPrefix(String words) {

        Node cur = root;

        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) != null)
                cur = cur.next.get(c);
            else
                return false;
        }

        return true;
    }


}
