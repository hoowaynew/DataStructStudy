package cn.itcast.day1123Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key,value,null,null);
        }

        public Node() {
            this(null,null,null,null);
        }
    }

    // 根节点和Map大小
    private Node root;
    private int size;

    public BSTMap() {
        this(null,0);
    }

    public BSTMap(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    // 获取key键的节点
    private Node getNode(Node node, K key) {
        if(node == null)
            return null;

        if(key.compareTo(node.key) == 0)
            return node;
        else if(key.compareTo(node.key) < 0)
            return getNode(node.left,key);
        else
            return getNode(node.right,key);
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value); // 必须root接收返回值
    }

    private Node add(Node node,K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if(key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        }
        else if(key.compareTo(node.key) > 0) {
            node.right = add(node.right,key,value);
        }
        return node;
    }

    public K removeMin(){
        return removeMin(root).key;
    }

    // 删除以node为根节点的二分搜索树的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if(node == null)
            return null;

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
            node.left = removeMin(node.left);
        return node;
        }


    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException("The key in map doesn't exit!");
        return remove(root,key).value;
    }

    private Node remove(Node node, K key) {



        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {

        Node node = getNode(root,key);

        return node == null? null: node.value;
    }

    @Override
    public V set(K key, V value) {
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException("The key in map doesn't exit!");
        V temp = node.value;
        node.value = value;
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
