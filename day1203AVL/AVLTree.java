package cn.itcast.day1203AVL;

import cn.itcast.day1123Map.Map;

import java.util.ArrayList;

public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        K key;
        V value;
        Node left, right;
        int height;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            height = 1;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }
    }

    // 根节点和Map大小
    private Node root;
    private int size;

    public AVLTree() {
        this(null, 0);
    }

    public AVLTree(Node root, int size) {
        this.root = root;
        this.size = size;
    }

    // AVL右旋转（AVL左子树高度偏高）
    /* 二分搜索树的大小关系：T1 < Z < T2 < x < T3 < Y < T4
     *
     *           Y                               X
     *         /   \                           /    \
     *       X      T4       右旋转            Z      Y
     *     /   \              ===>           /  \   /  \
     *    Z     T3                          T1  T2 T3  T4
     *  /   \
     * T1   T2
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;
        // 右旋转操作
        x.right = y;
        y.left = T3;
        // 维护不平衡度
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        // 返回新的根节点
        return x;
    }

    // AVL左旋转（AVL右子树高度偏高）
    /* 二分搜索树的大小关系：T1 < Y < T2 < x < T3 < Z < T4
     *
     *           Y                               X
     *         /   \                           /    \
     *       T1     x       右旋转            Z      Y
     *            /   \        ===>         /  \   /  \
     *           T2    Z                   T1  T2 T3  T4
     *               /   \
     *              T3    T4
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;
        // 右旋转操作
        x.right = y;
        y.left = T2;
        // 维护不平衡度
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        // 返回新的根节点
        return x;
    }

    // AVL获取节点的高度
    public int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    // AVL获取节点的不平衡因子
    private int getBalance(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 判断AVL是不是二分搜索树，二分搜索树中序遍历应该是从小到大的顺序
    public boolean isBST() {
        ArrayList<K> list = new ArrayList<>();
        inOrder(root, list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0)
                return false;
        }
        return true;
    }

    // BST中序遍历
    private void inOrder(Node node, ArrayList<K> list) {
        if (node == null)
            return;
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    // 判断AVLTree是不是平衡二叉树（左右子树的高度相差不超过1）
    public boolean isBalanceTree() {
        return isBalanceTree(root);
    }

    private boolean isBalanceTree(Node node) {
        if (node == null)
            return true;
        if (Math.abs(getBalance(node)) > 1)
            return false;

        return isBalanceTree(node.left) && isBalanceTree(node.right);
    }

    // 获取key键的节点
    private Node getNode(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) == 0)
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else
            return getNode(node.right, key);
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value); // 必须root接收返回值
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {// key.compareTo(node.key) = 0
            node.value = value;
        }

        // 更新node的height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 获取不平衡度
        int unbalance = getBalance(node);

        // 左右旋转进行AVL处理进行平衡维护
        if (getBalance(node) > 1 && getBalance(node.left) >= 0)
            return rightRotate(node);
        if (getBalance(node) < -1 && getBalance(node.right) <= 0)
            return leftRotate(node);
        if(getBalance(node) > 1 && getBalance(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(getBalance(node) < -1 && getBalance(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // 寻找二叉树最小的值并返回
    public V Minimum() {
        return Minimum(root).value;
    }

    private Node Minimum(Node node) {
        if (node == null)
            throw new IllegalArgumentException("the AVL doesn't exit!");
        if (node.left == null) {
            return node;
        }

        return Minimum(node.left);
    }

    public V removeMin() {
        V ret = Minimum();
        removeMin(root);
        return ret;
    }

    // 删除以node为根节点的二分搜索树的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {
        if (node == null)
            return null;

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null)
            return null;
        else {
            root = remove(root, key);
            return node.value;
        }
    }

    private Node remove(Node node, K key) {
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else { // key.comparaTo(node.key) == 0
            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = Minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }

    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {

        Node node = getNode(root, key);

        return node == null ? null : node.value;
    }

    @Override
    public V set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException("The key in map doesn't exit!");
        V temp = node.value;
        node.value = value;
        return temp;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
