package cn.itcast.day1212HashTable;

import java.util.TreeMap;

@SuppressWarnings("ALL")
public class HashTableNew<K, V> {

    private final int[] capacity = {53,97,193,398,769,1543,3079,6151,12289,24593,
        49157,98317,196613,393241,786443,1572869,3145739,6291469,
        12582917,25165843,50331653,100663319,201326611,402653189,80530645};
    private final static int upperTol = 10;
    private final static int lowerTol = 2;
    private int capacityIndex = 0;

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;

    public HashTableNew() {
        this.M = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[M];

        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new TreeMap<>();
        }
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
            if (size >= upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
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
            if (size <= upperTol * M && M / 2 > capacity[capacityIndex] && capacityIndex + 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
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
