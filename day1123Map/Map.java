package cn.itcast.day1123Map;

public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    V set(K key, V value);

    int getSize();

    boolean isEmpty();
}
