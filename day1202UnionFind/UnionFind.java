package cn.itcast.day1202UnionFind;

public interface UnionFind {

    int getSize();

    void unionElements(int p, int q);

    boolean isConnected(int p, int q);
}
