package cn.itcast.day1202UnionFind;

// 第6版并查集，查询操作时使用递归进行path compression路径压缩，使得所有节点直接指向根节点

public class UF6 implements UnionFind{

    int[] parent;
    int[] rank;

    public UF6(int size) {

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

        if (p != parent[p])
            parent[p] = find(parent[p]); // 路径压缩思想,无需维护rank，rank只是作为一个粗略参考，此处不维护仍然具有比较意义

        return parent[p];
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
