package cn.itcast.day1029Queue;

import java.util.Arrays;

public class DemoMain {

    public static void main(String[] args) {

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();

        System.out.println(arrayQueue.isEmpty());

        for (int i = 0; i < 10; i++) {
            arrayQueue.enqueue(i);
            if (i % 3 == 2) {
                arrayQueue.dequeue();
            }
            System.out.println(arrayQueue);
        }

        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.getFront());

        System.out.println("=====================");
        LoopQueue<Integer> lo = new LoopQueue<>(5);
        System.out.println(lo.getSize());
        System.out.println(lo.getCapacity());
        //System.out.println(lo.getFront());


        for (int i = 0; i < 20; i++) {
            lo.enqueue(i);

            if (i % 3 ==2){
                lo.dequeue();
                System.out.println(lo);
            }
        }



        System.out.println("The front is " + lo.getFront());
        System.out.println(lo);
        System.out.println("The front is " + lo.getFront());
    }
}
