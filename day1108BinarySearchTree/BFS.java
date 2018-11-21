package cn.itcast.day1108BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left;
        Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    Node root;
    int size;

    public BFS() {
        root = null;
        size = 0;
    }


    // 返回BFS元素个数
    public int getSize() {
        return size;
    }

    // 判断BFS是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 清空二分搜索树
    public void clean() {
        if(root != null) {
            root.e = null;
            root = null;
        }
    }

    // 使用递归方式向BFS中添加元素,面向用户
    public void add(E e) {
        root = add(root, e);
//        if (root == null) {
//            root = new Node(e);
//        } else {
//            add(root, e);
//        }

    }

    // 1.add（）方法内部调用
    private Node add(Node node, E e) {
        // 1.递归基础终止条件,BFS不包含重复元素
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        else if ((e.compareTo(node.e) > 0))
            node.right = add(node.right, e);

        return node;
/*        if (e.compareTo(node.e) == 0){
            return; // 终止下面程序运行
        } else if(e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return; // 终止下面程序运行
        } else if(e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return; // 终止下面程序运行
        }

        // 2.递归运行条件
        if(e.compareTo(node.e) < 0)
            add(node.left,e);
        else
            add(node.right,e);*/
    }


    // 使用递归方式向BFS中查询元素,面向用户
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 2.contains（）方法内部调用
    private boolean contains(Node node, E e) {
        if (node == null)
            return false;
        else if (node.e == e)
            return true;

        else if (e.compareTo(node.e) < 0)
            return contains(node.left, e);
        else
            return contains(node.right, e);
    }


    // 使用前序遍历二分搜索树
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null)
            return;

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }


    // 使用中序遍历二分搜索树
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }


    // 使用后序遍历二分搜索树
    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node node) {
        if (node == null)
            return;

        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.e);
    }


    // 使用非递归方式前序遍历二分搜索树
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }

    }

    // 层序遍历二分搜索树
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);

            if (cur.left != null)
                q.add(cur.left);
            if (cur.right != null)
                q.add(cur.right);
        }
    }

    // 查找二分搜索树的最小值
    public E minimum(){
        return minimum(root).e;
    }
    private Node minimum(Node node) {
        if(size == 0)
            throw new IllegalArgumentException("BFT is empty");

        if (node.left == null)
            return node;
        else
            return minimum(node.left);

    }

    // 查找二分搜索树的最大值
    public E maxmum(){
        return maxmum(root).e;
    }
    private Node maxmum(Node node) {
        if(size == 0)
            throw new IllegalArgumentException("BFT is empty");

        if (node.right == null)
            return node;
        else
            return maxmum(node.right);

    }

    // 删除二分搜索树的最小值,返回根节点
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }
    private Node removeMin(Node node) {

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 删除二分搜索树的最大值,返回根节点
    public E removeMax() {
        E ret = maxmum();
        root = removeMax(root);
        return ret;
    }

    // 删除二分搜索树指定元素为e的节点
    public void remove(E e){
        root = remove(root,e);
    }
    private Node remove(Node node, E e) {
        if(node == null)
            return null;
        if(e.compareTo(node.e) < 0)
            node.left = remove(node.left,e);
        else if(e.compareTo(node.e) > 0)
            node.right = remove(node.right,e);
        else { // e == node.e
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // 左右子树均不为空
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;
        }
        return node;
    }

    private Node removeMax(Node node) {
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;

    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder();
        generateString(root, 0, ret);
        return ret.toString();
    }

    private void generateString(Node node, int depth, StringBuilder ret) {
        if (node == null) {
            ret.append(generatDepth(depth) + "null\n");
            return;
        }
        ret.append(generatDepth(depth) + node.e + "\n");
        generateString(node.left, depth + 1, ret);
        generateString(node.right, depth + 1, ret);
    }

    private String generatDepth(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }
}
