package cn.itcast.day1029Queue;

public interface Queue<E> {

    public abstract void  enqueue(E e);

    public abstract E dequeue();

    public abstract int getSize();

    public abstract E getFront();

    public abstract boolean isEmpty();

}
