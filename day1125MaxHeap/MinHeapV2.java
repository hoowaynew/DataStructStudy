package cn.itcast.day1125MaxHeap;

import java.util.ArrayList;
import java.util.Arrays;

public class MinHeapV2<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MinHeapV2(int capacity){
        data = new ArrayList<>(capacity);
    }

    public MinHeapV2(){
        data = new ArrayList<>();
    }

    public MinHeapV2(E[] arr){
        data = new ArrayList<>(Arrays.asList(arr));
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDown(i);
    }

    // 返回堆中的元素个数
    public int size(){
        return data.size();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty(){
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e){
        data.add(e);
        siftUp(data.size() - 1);
    }

    private void siftUp(int k){

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0 ){
            swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中的最小元素
    public E findMin(){
        if(data.size() == 0)
            throw new IllegalArgumentException("Can not findMin when heap is empty.");
        return data.get(0);
    }

    // 取出堆中最大元素
    public E extractMin(){

        E ret = findMin();

        swap(0, data.size() - 1);
        data.remove(data.size() - 1);
        siftDown(0);

        return ret;
    }

    private void siftDown(int k){

        while(leftChild(k) < data.size()){
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if( j + 1 < data.size() &&
                    data.get(j + 1).compareTo(data.get(j)) < 0 )
                j ++;
            // data[j] 是 leftChild 和 rightChild 中的最大值

            if(data.get(k).compareTo(data.get(j)) <= 0 )
                break;

            swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e){

        E ret = findMin();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    // 元素交换，用于元素上浮
    private void swap(int i, int j) {
        if(i < 0 || i > data.size()-1 || j < 0 || j > data.size()-1)
            throw new IndexOutOfBoundsException("The index is out of bounds");
        E temp = data.get(i);
        data.set(i,data.get(j));
        data.set(j,temp);
    }
}
