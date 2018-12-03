package cn.itcast.day1202UnionFind;

// 第4版并查集，基于深度rank来优化

public class UF4 implements UnionFind{

    int[] parent;
    int[] rank;

    public UF4(int size) {

        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    // O(h)复杂度，寻找p索引的根节点,h为树的深度
    private int find(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound...");
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    // O(h)复杂度，将p索引所在的集合和q所在的集合聚合
    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        }
        else if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else { // rank[pRoot] == rank[qRoot]
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }

    }

    // O(h)复杂度，判断p索引节点和q索引节点是不是同一个集合
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
