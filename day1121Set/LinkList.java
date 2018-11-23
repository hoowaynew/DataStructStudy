/*
package cn.itcast.day1101LinkList;

public class LinkList<E> {
    private Node head;
    private int size;

    // LinkList节点类，包含数据域e与下一个节点地址next
    private class Node<E> {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    // 发挥链表的长度
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 采用头插法向链表插入元素
    public void addFirst(E e) {

        Node node = new Node(e);
        node.next = head;
        head = node;

        // head = new Node(e,head);

        size++;
    }

    // 向中间位置插入元素
    public void add(E e, int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("add fail, the index is illegal!");
        }

        Node prev = head;
        if (index == 0) {
            addFirst(e);
        } else {
            Node node = new Node(e);
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
            size++;
        }
    }

    // 在链表末尾添加元素
    public void addLast(E e) {
        add(e, size);
    }

    // 复写toString方法
    @Override
    public String toString() {
        Node cur = head;
        StringBuilder ret = new StringBuilder();
        while (cur != null) {
            ret.append(cur.e + "--->");
            cur = cur.next;
        }
        ret.append("null");
        return ret.toString();
    }
}
*/

package cn.itcast.day1121Set;

public class LinkList<E> {

    // LinkList节点类，包含数据域e与下一个节点地址next
    private class Node<E> {

        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }
    }

    // 使用虚拟头节点（简化代码，去除头节点的特殊情况判断）
    private Node dumHead = new Node(null,null);
    private int size;

    // 发挥链表的长度
    public int getSize() {
        return size;
    }

    // 判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向中间位置插入元素
    public void add(E e, int index) {
        if (index < 0 && index > size) {
            throw new IllegalArgumentException("Add fail, the index is illegal!");
        }

        Node prev = dumHead;
        Node node = new Node(e);
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        node.next = prev.next;
        prev.next = node;
        size++;
    }

    // 采用头插法向链表插入元素
    public void addFirst(E e) {
        add(e,0);
        // head = new Node(e,head);
    }

    // 在链表末尾添加元素
    public void addLast(E e) {
        add(e, size);
    }

    // 获取某个索引的元素
    public E getElement(int index) {
        if (index < 0 && index >= size)
            throw new IllegalArgumentException("Get fail, the index is illegal!");

        Node cur = dumHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return (E) cur.e;
    }

    // 获取头节点元素
    public E getFirst() {
        return getElement(0);
    }

    // 获取尾节点元素
    public E getLast() {
        return getElement(size-1);
    }

    // 是否包含某个元素
    public boolean contains(E e) {
        Node cur = dumHead;
        //System.out.println(dumHead.e);
        while (cur != null) {
            if(cur.e == e)
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 修改指定索引元素
    public void set(E e, int index) {
        if (index < 0 && index >= size)
            throw new IllegalArgumentException("Set fail, the index is illegal!");
        Node cur = dumHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    // 删除链表指定索引的元素并返回该元素
    public E remove(int index) {
        if (index < 0 && index >= size)
            throw new IllegalArgumentException("Remove fail, the index is illegal!");
        Node prev = dumHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;

        size--;
        return (E) cur.e;
    }

    // 删除链表指定元素
    public boolean remove(E e) {
//        System.out.println(contains(e) + ".......");
        if(contains(e)) {
            Node<E> cursor = dumHead;
            while (cursor.next != null) {
                if(cursor.next.e != e)
                    cursor = cursor.next;
                else {
                    Node temp = cursor.next.next;
                    cursor.next.next = null;
                    cursor.next = temp;
                    size--;
                }
            }

            return true;
        }else
            return false;
    }

    // 删除链表头节点的元素并返回该元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除链表尾节点的元素并返回该元素
    public E removeLast() {
        return remove(size-1);
    }

    // 复写toString方法
    @Override
    public String toString() {
        Node cur = dumHead.next;
        StringBuilder ret = new StringBuilder();
        ret.append("The length of LinkList is " + size + "\n");
        while (cur != null) {
            ret.append(cur.e + "--->");
            cur = cur.next;
        }
        ret.append("null\n");
        return ret.toString();
    }
}

