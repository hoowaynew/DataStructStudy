package cn.itcast.day1208Red_Black_Tree;

import java.util.Comparator;

public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
