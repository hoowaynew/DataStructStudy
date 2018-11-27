package cn.itcast.day1125MaxHeap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class MinHeapMain {

    public static void main(String[] args) throws IOException {

        MinHeapV2<Integer> minHeapV2 = new MinHeapV2<>();

        int n = 1000000;
        Random random = new Random();
//        MaxHeap<Integer> maxHeap = new MaxHeap<>();

        for (int i = 0; i < n; i++) {
            minHeapV2.add(random.nextInt(Integer.MAX_VALUE));
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = minHeapV2.extractMin();
//            System.out.println(minHeapV2.size());
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] > array[i])
                throw new IllegalArgumentException("MaxHeap is Wrong！");
        }

//        System.out.println(Arrays.toString(array));
        System.out.println("MaxHeap test completed!");


        FileWriter file = new FileWriter("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\day1125MaxHeap\\MinHeap.txt");
//        byte[] b = new byte[1024];
        file.write(Arrays.toString(array));
        file.close();


    }
}
