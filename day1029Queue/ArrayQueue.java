package cn.itcast.day1029Queue;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array = new Array<>();

    public ArrayQueue() {
        this.array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        this.array = new Array<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public E getFront() {
        return array.getElement(0);
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Queue: front [ ");
        for (int i = 0; i < getSize(); i++) {
            if (i != getSize()-1)
                str.append(array.getElement(i) + ", ");
        }
        str.append(array.getElement(getSize()-1) + " ] tail");
        return str.toString();
    }

    public int getCapacity(){
        return array.getCapacity();
    }
}
