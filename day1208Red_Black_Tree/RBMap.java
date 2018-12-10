package cn.itcast.day1208Red_Black_Tree;

@SuppressWarnings("ALL")
public class RBMap<K extends Comparable<K>, V> implements Map<K,V> {

    RBTree<K,V> rbTree;

    public RBMap() {
        rbTree = new RBTree<>();
    }

    @Override
    public void add(K key, V value) {
        rbTree.add(key,value);
    }

    @Override
    public V remove(K key) {
        return rbTree.remove(key);
    }

    @Override
    public boolean contains(K key) {
        return rbTree.contains(key);
    }

    @Override
    public V get(K key) {
        return rbTree.get(key);
    }

    @Override
    public V set(K key, V value) {
        V ret = rbTree.get(key);
        rbTree.set(key,value);
        return ret;
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
