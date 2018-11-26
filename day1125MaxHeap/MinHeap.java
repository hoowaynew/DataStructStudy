package cn.itcast.day1125MaxHeap;

/*
* 使用动态数组ArrayList实现二叉堆(最大堆)（如果从数组0索引开始存储二叉堆），二叉堆作为一棵完全二叉树，具有以下特点：(增加和取出时间复杂度log n)
*   1，根节点时所在堆中最大的(父亲节点数值大于左右孩子数值)；
*   2，父亲节点的索引是左/右孩子索引(leftIndex-1)/2（整除）;
*   3，左孩子索引是父亲节点索引(parentIndex * 2 + 1);
*   4，右孩子索引是父亲节点索引(parentIndex * 2 + 2);
* */

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeap<E extends Comparable<E>> {

    ArrayList<E> data;

    public MinHeap() {
        data = new ArrayList<>();
    }

    public MinHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    // heapify: 将一个数组转化成一个最大堆，思路：
    // 默认初始数组就是一个乱序堆，然后对此堆进行排序处理(从最后一个叶子节点的父亲节点往根节点依次下沉操作)


    public int size() {
        return data.size();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 获取指定索引的父亲节点索引
    public int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 hasn't the parent!");
        return (index - 1) / 2;
    }

    // 获取指定索引的左孩子节点
    public int leftChild(int index) {
        return index * 2 + 1;
    }

    // 获取指定索引的左孩子节点
    public int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.add(e);
        siftUp(data.size() - 1);
    }
    // 元素上浮，防止添加的元素不满足父亲节点大于左右孩子节点，如果不满足，则交换此节点和父亲节点
    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) > 0) {
            swap(index,parent(index));
            index = parent(index);
        }
    }
    // 元素交换，用于元素上浮
    private void swap(int i, int j) {
        if(i < 0 || i > data.size()-1 || j < 0 || j > data.size()-1)
            throw new IndexOutOfBoundsException("The index is out of bounds");
        E temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }

    // 获取堆中的元素（最大值），也就是堆的根节点，剩下的左右子树需要重新融合成一个新的堆,融合过程如下：
    // 取出根节点的最大值后，将堆中最后一个元素取出放到根节点，将根节点与左右孩子中较大的孩子进行交换数值，然后继续往下比较和交换直至满足堆特性
    public E extractMin() {
        E ret = findMin();
        // 将堆中最后一个元素放入根节点并移除堆中最后一个节点
        swap(0,data.size()-1);
        data.remove(data.size()-1);
        // 根节点开始下沉
        siftDown(0);
        return ret;
    }
    // 元素下沉
    private void siftDown(int index) {
        while (leftChild(index) < data.size()) {
            // 找到index索引节点较小者
            int minIndex = leftChild(index);
            // 判断index节点是否存在右孩子，存在则比较，不存在则默认使用左孩子索引
            if (minIndex + 1 < data.size() && data.get(minIndex).compareTo(data.get(minIndex + 1)) > 0) {
                minIndex++; // or leftIndex++ / = rightChild(index);
            }
            // 根节点如果小于左右孩子中较大者，说明堆已经融合完成
            if (data.get(minIndex).compareTo(data.get(index)) >= 0)
                break;

            // 根小于左右孩子较大者则交换两者数值
            swap(index,minIndex);
            index = minIndex;
        }
    }

    // 获取堆中的最小值
    public E findMin() {
        if (data.isEmpty())
            throw new IllegalArgumentException("The MaxHeap is empty!");
        return data.get(0);
    }

    // 将元素e替换最大堆中的最大元素，并保持堆结构稳定
    public E replace(E e) {
        E min = findMin();
        data.set(0,e);
        siftDown(0);
        return min;
    }
}
