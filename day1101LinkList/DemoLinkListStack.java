package cn.itcast.day1101LinkList;

import cn.itcast.day1029Stack.ArrayStack;

import java.util.Random;

public class DemoLinkListStack {

    public static void main(String[] args) {

        LinkListStack<Integer> linkListStack = new LinkListStack<>();
       /* for (int i = 0; i < 10; i++) {
            linkListStack.push(i);
        }
        System.out.println(linkListStack);
        linkListStack.pop();
        System.out.println(linkListStack);
        System.out.println(linkListStack.peek());
        System.out.println(linkListStack.getSize());
        System.out.println(linkListStack.isEmpty());*/

        int count = 10000000;
        double time1 = testTime(linkListStack,count);
        System.out.println("The time of LinkListStack : " + time1 + " s!");


        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time2 = testTime(linkListStack,count);
        System.out.println("The time of ArrayStack : " + time2 + " s!");



    }



    public static double testTime(Stack stack, int count) {

        Random rand = new Random();

        long start = System.nanoTime();

        for (int i = 0; i < count; i++) {
            stack.push(rand.nextInt());
        }

        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long end = System.nanoTime();

        double cont = (end-start)/Math.pow(10,9);

        return cont;

    }
}
