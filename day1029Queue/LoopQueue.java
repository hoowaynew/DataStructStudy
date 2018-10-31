package cn.itcast.day1029Queue;

public class LoopQueue<E> implements Queue<E> {

    E[] data;
    int front, tail;
    int size;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1 ];  //故意多创建一个元素位置用于判断循环队列是空还是满，front==tail代表空，tail+1==front则代表队列满了
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }



    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("The LoopArray is empty!");

        E temp = data[front];
        data[front] = null;  // 优化
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity()/4 && getCapacity()/2!=0)
            resize(getCapacity()/2);

        return temp;
    }


    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("The LoopArray is empty!");
        return data[front];
    }

    public void resize(int newCapacity){
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {    // i < size不能改。
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("The capacity : " + getCapacity() + ", the size: " + getSize() + "\n");
        str.append("Queue: front [ ");
        for (int i = 0; i < getSize(); i++) {
            if (i != getSize()-1)
                str.append(data[(front + i) % data.length] + ", ");
        }
        str.append(data[(front + getSize() - 1) % data.length] + " ] tail");
        return str.toString();
    }

}
