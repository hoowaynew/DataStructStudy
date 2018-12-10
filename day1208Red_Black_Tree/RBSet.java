package cn.itcast.day1208Red_Black_Tree;

public class RBSet<E extends Comparable<E>> implements Set<E> {

    RBTree<E,Object> rbTree;

    public RBSet() {
        rbTree = new RBTree<>();
    }

    @Override
    public void add(E e) {
        rbTree.add(e,null);
    }

    @Override
    public void remove(E e) {
        rbTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return rbTree.contains(e);
    }

    @Override
    public int getSize() {
        return rbTree.getSize();
    }

    @Override
    public boolean isEmpty() {
        return rbTree.isEmpty();
    }
}
