package cn.itcast.day1127SegmentTree;

/*
 *   线段树不涉及添加操作，初始化时需要传入一个数组；
 *   当传入数组有n个节点时，线段树tree大约最大需要4n空间，按满二叉树估计，没有元素的节点看做空即可
 * */

public class SegmentTree<E> {

    E[] tree;
    E[] data;
    Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[4 * arr.length];
        // 业务逻辑，用户实现
        buildSegmenTree(0, 0, data.length - 1);
    }

    // 在index索引节点创建线段树,l,r分别为线段树的左右区间
    public void buildSegmenTree(int index, int l, int r) {
        // 递归终止条件
        if (l == r) {
            tree[index] = data[l];
            return;         // 注意不能遗漏
        }

        // 递归条件
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        // 线段中间的索引
        int mid = l + (r - l) / 2;

        buildSegmenTree(leftChildIndex, l, mid);
        buildSegmenTree(rightChildIndex, mid + 1, r);
        // 执行的业务逻辑由用户来确定
        tree[index] = merger.merge(tree[leftChildIndex], tree[rightChildIndex]);

    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL > data.length - 1 || queryR < 0 || queryR > data.length - 1 || queryL > queryR)
            throw new IllegalArgumentException("The query index is illegal...");

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    // 在以index为根节点范围为[l,r]中查询[queryL,queryR]的值
    private E query(int index, int l, int r, int queryL, int queryR) {
        // 递归到底的情况
        if (l == queryL && r == queryR)
            return tree[index];

        // 递归操作
        int leftChildIndex = leftChild(index);
        int rightChildIndex = rightChild(index);
        int mid = l + (r - l) / 2;
        // 1.查询边界完全在中间点mid的左侧
        if (queryR <= mid)
            return query(leftChildIndex, l, mid, queryL, queryR);

        // 2.查询边界完全在中间点mid的右侧
        else if (queryL >= mid + 1)
            return query(rightChildIndex, mid + 1, r, queryL, queryR);

        // 3.查询的边界分布mid两侧
        E leftRet = query(leftChildIndex, l, mid, queryL, mid);
        E rightRet = query(rightChildIndex, mid + 1, r, mid + 1, queryR);
        return merger.merge(leftRet, rightRet);
    }

    // 更新索引index节点的值为e
    public void set(int index, E e) {
        if (index < 0 || index > data.length - 1)
            throw new IllegalArgumentException("The index is illegal...");
        data[index] = e;
        set(0,0,data.length-1,index,e);
    }

    // 在以treeIndex为根的线段树中更新index的值为e

    // 在以treeIndex索引的根节点范围为[l,r]更新index索引的元素为e
    private void set(int treeIndex, int l, int r, int index, E e) {
        // 递归终止条件
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        // 递归执行条件
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        if (index <= mid)
            set(leftChildIndex,l,mid,index,e);
        else
            set(rightChildIndex,mid+1,r,index,e);
        // 执行条件
        tree[treeIndex] = merger.merge(tree[leftChildIndex],tree[rightChildIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Array Index is illegal!");
        return data[index];
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                sb.append(tree[i]);
            else
                sb.append("null");
            if (i != tree.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}
