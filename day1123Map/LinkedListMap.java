package cn.itcast.day1123Map;

import java.util.Objects;

public class LinkedListMap<K, V> implements Map<K, V> {

    // 节点内部类
    class Node<K, V> {
        K key;
        V value;
        Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

//        @Override
//        public String toString() {
//            return key.toString() + ": " + value.toString();
//        }
    }

    Node dummyhead;     // 虚拟头节点
    int size;           // 记录Map中元素个数

    public LinkedListMap() {
        dummyhead = new Node();
    }

    // 私有方法，返回key键的节点
    private Node getNode(K key) {
        Node cur = dummyhead.next;
        while (cur != null) {
            if (cur.key == key)
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node != null)
            node.value = value;
        else {
            dummyhead.next = new Node(key, value, dummyhead.next);
            size++;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException("The key in Map isn't exit!");
        Node prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.key != key) {
                prev = prev.next;
            } else {
                prev.next = prev.next.next;
//                prev.next.next = null;
                size--;
                return (V) node.value;
            }
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        if (getNode(key) != null)
            return (V) getNode(key).value;
        return null;
    }

    @Override
    public V set(K key, V value) {
        if (getNode(key) == null)
            throw new IllegalArgumentException("The key in Map isn't exit!");
        Node node = getNode(key);
        V temp = (V) node.value;
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

    @Override
    public String toString() {
        return "LinkedListMap{" +
                "dummyhead=" + dummyhead +
                ", size=" + size +
                '}';
    }
}
