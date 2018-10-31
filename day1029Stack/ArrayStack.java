package cn.itcast.day1029Stack;

public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }



    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getElement(array.getSize()-1);
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Stack: [ ");
        for (int i = 0; i < getSize(); i++) {
            if (i != getSize()-1)
                str.append(array.getElement(i) + ", ");
        }
        str.append(array.getElement(getSize()-1) + " ] top");
        return str.toString();
    }
}
