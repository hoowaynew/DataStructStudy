package cn.itcast.day1029Stack;

public class DemoMain {
    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        System.out.println(arrayStack.getSize());
        System.out.println(arrayStack.isEmpty());

        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }
        System.out.println(arrayStack);

        arrayStack.pop();
        System.out.println(arrayStack);

        System.out.println(arrayStack.peek());

        System.out.println(arrayStack.getSize());

        System.out.println(arrayStack.isEmpty());
    }
}

