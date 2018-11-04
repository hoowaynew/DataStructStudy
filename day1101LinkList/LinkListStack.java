package cn.itcast.day1101LinkList;

public class LinkListStack<E> implements Stack<E> {

    private LinkList<E> listStack = new LinkList<>();

    public LinkListStack() {
    }

    @Override
    public void push(E e) {
        listStack.addFirst(e);
    }

    @Override
    public E pop() {
        return listStack.removeFirst();
    }

    @Override
    public E peek() {
        return listStack.getFirst();
    }

    @Override
    public int getSize() {
        return listStack.getSize();
    }

    @Override
    public boolean isEmpty() {
        return listStack.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("LinkListStack : Top ---> tail !\n ");
        str.append(listStack);
        return str.toString();
    }
}
