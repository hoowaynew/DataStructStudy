package cn.itcast.day1125MaxHeap;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class MainMaxHeap {

    public static void main(String[] args) throws IOException {

        int n = 1000000;
        Random random = new Random();
        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] array = new int[n];
        for (int i = 0; i < maxHeap.size(); i++) {
            array[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] < array[i])
                throw new IllegalArgumentException("MaxHeap is Wrong！");
        }

//        System.out.println(Arrays.toString(array));
        System.out.println("MaxHeap test completed!");
//        System.out.println(array[99999]);

//        FileWriter file = new FileWriter("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\day1125MaxHeap\\MaxHeap.txt");
////        byte[] b = new byte[1024];
//        file.write(Arrays.toString(array));
//        file.close();

        int timeHeapify = measureTime(true);
        int timeNotHeapify = measureTime(false);
        System.out.println("timeHeapify: " + timeHeapify);
        System.out.println("timeNotHeapify: " + timeNotHeapify);


        System.out.println("===============");
        Integer[] array1 = new Integer[n];

        for (int i = 0; i < n; i++) {
            array1[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxHeap<Integer> maxHeap1 = new MaxHeap<>(array1, true);
        for (int i = 0; i < n; i++) {
            array1[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < array1.length; i++) {
            if (array1[i - 1] < array1[i]) {
                System.out.println(array1[i-1] + "--" + array1[i]);
                throw new IllegalArgumentException("MaxHeap is Wrong！");
            }
        }
        System.out.println("new MaxHeap test completed!");
    }

    // 测试heapify和常规添加的效率区别
    public static int measureTime(boolean isHeapify) {
        int n = 1000000;
        Integer[] array = new Integer[n];
        long start = System.nanoTime();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }

//        System.out.println(Arrays.toString(array));
        MaxHeap<Integer> maxHeap = new MaxHeap<>(array, isHeapify);

        long end = System.nanoTime();
        return (int) (end - start) / 1000000;
    }
}
