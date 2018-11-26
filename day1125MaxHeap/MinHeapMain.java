package cn.itcast.day1125MaxHeap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class MinHeapMain {

    public static void main(String[] args) throws IOException {

        MinHeap<Integer> minHeap = new MinHeap<>();

        // 随机生成长度为n的乱序数组
        int n = 1000000;
        Random random = new Random();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE);
        }

        // 将乱序数组依次添加到MinHeap中
        for (Integer integer : arr) {
            minHeap.add(integer);
        }

        // 遍历MinHeap中的元素，确保根节点小于左右孩子的值
        for (int i = 0; i < minHeap.size(); i++) {
            arr[i] = minHeap.extractMin();
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] > arr[i]) {
                System.out.println("index :" + i);
                //throw new IllegalArgumentException("The MinHeap is wrong!");
            }
        }

        System.out.println("The MinHeap test completed!");


        FileWriter file = new FileWriter("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\day1125MaxHeap\\MinHeap.txt");
//        byte[] b = new byte[1024];
        file.write(Arrays.toString(arr));
        file.close();


    }
}
