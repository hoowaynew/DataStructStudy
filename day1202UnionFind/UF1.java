package cn.itcast.day1202UnionFind;

public class UF1 implements UnionFind{

    private int[] id;

    public UF1(int size) {

        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }

    }

    private int find(int p) {
        if (p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound...");
        return id[p];
    }

    @Override
    public int getSize() {
        return id.length;
    }

    // O(n)复杂度
    @Override
    public void unionElements(int p, int q) {

        int pid = id[p];
        int qid = id[q];

        if (pid == qid)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }

    // O(1)复杂度
    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}
