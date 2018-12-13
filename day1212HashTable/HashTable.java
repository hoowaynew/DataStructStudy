package cn.itcast.day1212HashTable;

import java.util.TreeMap;

@SuppressWarnings("ALL")
public class HashTable<K, V> {

    private final static int upperTol = 10;
    private final static int lowerTol = 2;
    private final static int initM = 7;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTable(int M) {
        this.M = M;
        size = 0;
        hashTable = new TreeMap[M];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public HashTable() {
        this(initM);
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K,V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key,value);
        } else {
            map.put(key,value);
            size++;
            if (size >= upperTol * M)
                resize(M * 2);
        }
    }

    private void resize(int newM) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newHashTable.length; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        this.M = newM;
        for (int i = 0; i < oldM; i++) {
            TreeMap<K,V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key,map.get(key));
            }
        }

        this.hashTable = newHashTable;
    }

    public V remove(K key) {
        TreeMap<K,V> map = hashTable[hash(key)];
        V ret = null;
        if(map.containsKey(key)) {
            size--;
            ret = map.remove(key);
            if (size <= upperTol * M && M / 2 > initM)
                resize(M / 2);
        }

        return ret;
    }

    public V set(K key,V value) {
        TreeMap<K,V> map = hashTable[hash(key)];
        if (!map.containsKey(key))
            throw new IllegalArgumentException(key + "doesn't exit!");
        return map.put(key,value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }
}
