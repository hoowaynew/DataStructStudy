package cn.itcast.day1202UnionFind;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int n  =2000000;
        int size = 2000000;
        UF1 uf1 = new UF1(size);
//        System.out.println("UF1 consume: " + UFTest(uf1,n) + " !");
//
//        UF2 uf2 = new UF2(size);
//        System.out.println("UF2 consume: " + UFTest(uf2,n) + " !");

        UF3 uf3 = new UF3(size);
        System.out.println("UF3 consume: " + UFTest(uf3,n) + " !");

        UF4 uf4 = new UF4(size);
        System.out.println("UF4 consume: " + UFTest(uf4,n) + " !");

        UF5 uf5 = new UF5(size);
        System.out.println("UF5 consume: " + UFTest(uf5,n) + " !");

        UF6 uf6 = new UF6(size);
        System.out.println("UF6 consume: " + UFTest(uf6,n) + " !");

    }

    private static double UFTest (UnionFind uf, int count) {

        int size = uf.getSize();
        Random random = new Random();

        long start = System.nanoTime();

        for (int i = 0; i < count; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a,b);
        }

        for (int i = 0; i < count; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a,b);
        }

        long end = System.nanoTime();
        return (end - start) / 1000000000.0;
    }
}
