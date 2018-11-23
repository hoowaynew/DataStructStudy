package cn.itcast.day1121Set;

public class BSTSet<E extends Comparable<E>> implements MySet<E>{

    BFS<E> bfs;

    public BSTSet() {
        bfs = new BFS<>();
    }

    @Override
    public void add(E e) {
        bfs.add(e);
    }

    @Override
    public void remove(E e) {
        bfs.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bfs.contains(e);
    }

    @Override
    public int getSize() {
        return bfs.getSize();
    }

    @Override
    public boolean isEmpty() {
        return bfs.isEmpty();
    }
}
