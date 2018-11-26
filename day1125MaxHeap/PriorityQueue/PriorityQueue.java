package cn.itcast.day1125MaxHeap.PriorityQueue;

import cn.itcast.day1125MaxHeap.MaxHeap;

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
