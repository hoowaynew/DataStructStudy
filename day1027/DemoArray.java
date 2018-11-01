package cn.itcast.day1027;

import java.util.Date;

public class DemoArray {
    public static void main(String[] args) {
        Array<Integer> arrs = new Array<>(5);
        System.out.println(arrs.getCapacity());
        System.out.println(arrs.getSize());
        System.out.println(arrs.isEmpty());

        arrs.addLast(100);
        for (int i = 0; i < 5; i++) {
            arrs.addLast(i);
        }
        arrs.add(1,2);
        arrs.addFirst(10);
        arrs.addFirst(01);

        System.out.println(arrs);

        arrs.setElement(1,11);
        System.out.println(arrs);

        System.out.println(arrs.contains(4));

        System.out.println(arrs.remove(8));
        System.out.println(arrs);

        System.out.println("remove first element : " + arrs.removeFirst());
        System.out.println(arrs);

        System.out.println("remove last element : " + arrs.removeLast());
        System.out.println(arrs);

        Date date1 = new Date();
        System.out.println(date1.getTime());
        boolean flag = arrs.removeRepetion();
        System.out.println(arrs + "----" + flag);
        System.out.println(arrs.removeRepetion());
        System.out.println(arrs);
    }
}
