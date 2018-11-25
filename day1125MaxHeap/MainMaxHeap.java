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
            if (array[i-1] < array[i])
                throw new IllegalArgumentException("MaxHeap is Wrong！");
        }

//        System.out.println(Arrays.toString(array));
        System.out.println("MaxHeap test completed!");
//        System.out.println(array[99999]);

        FileWriter file = new FileWriter("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\day1125MaxHeap\\MaxHeap.txt");
//        byte[] b = new byte[1024];
        file.write(Arrays.toString(array));
        file.close();
    }
}
