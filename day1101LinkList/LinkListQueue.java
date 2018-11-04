package cn.itcast.day1101LinkList;


import java.util.Random;

public class LinkListQueue<E> implements Queue<E> {

    // Node内部类
    private class Node<E> {
        E e;
        Node next;

        public Node() {
            this(null,null);
        }

        public Node(E e) {
            this(e,null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


    private Node head;
    private Node tail;
    private int size;

    public LinkListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null){
            tail = new Node(e);
            head = tail;
        }else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;

    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Dequeue failed, the LinkListQueue is empty!");
        Node ret = head;
        head = head.next;
        if(head.next == null)   // 当队列只有一个元素的时候，需要将尾指针指向null
            tail = null;

        ret.next = null;
        size--;
        return (E) ret.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Dequeue failed, the LinkListQueue is empty!");
        return (E) head.e;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Queue: front ");
        Node cur = head;
        while(cur != null) {
            str.append(cur.e + "--->");
            cur = cur.next;
        }
        str.append(" tail");
        return str.toString();
    }


    // 主方法测试
    public static void main(String[] args) {

        LinkListQueue<Integer> linkListQueue = new LinkListQueue<>();
        for (int i = 0; i < 10; i++) {
            linkListQueue.enqueue(i);
            if(i % 3 ==2)
                linkListQueue.dequeue();
            System.out.println(linkListQueue);

        }

//        System.out.println("================");
//        for (int i = 0; i < 4; i++) {
//            System.out.println(linkListQueue.getSize());
//            linkListQueue.dequeue();
//        }

        int count = 10000000;
        double time = testTime(linkListQueue,count);
        System.out.println("The time of LinkListQueue : " + time + " s!");
//        System.out.println(linkListQueue);
//        System.out.println(linkListQueue.getFront());
//        System.out.println(linkListQueue.isEmpty());
    }


    public static double testTime(LinkListQueue queue, int count) {

        Random rand = new Random();

        long start = System.nanoTime();

        for (int i = 0; i < count; i++) {
            queue.enqueue(rand.nextInt());
        }

        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long end = System.nanoTime();

        double cont = (end-start)/Math.pow(10,9);

        return cont;

    }
}
