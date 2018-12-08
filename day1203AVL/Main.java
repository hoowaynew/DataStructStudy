package cn.itcast.day1203AVL;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        AVL<String, Integer> avl = new AVL<>();
        FileOperation fileOperation = new FileOperation();
        ArrayList<String> list = new ArrayList<>();
        fileOperation.readFile("pride-and-prejudice.txt", list);
        Collections.sort(list);
//        System.out.println(list.size());
        long start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            avl.add(list.get(i), 0);
        }
        long end = System.currentTimeMillis();
        System.out.println(avl.getSize() + " words!\r\nconsume: " + (end - start) + "ms!");
        System.out.println("Is BST: " + avl.isBST());
        System.out.println("Is Balance: " + avl.isBalanced());

        long startRemove = System.nanoTime();
        for (String str : list) {
            avl.remove(str);
        }
        long endRemove = System.nanoTime();
        System.out.println("remove consume :" + (endRemove - startRemove)/1000000000.0);
//        AVLTree<String, Integer> avl = new AVLTree<>();
//        FileOperation fileOperation = new FileOperation();
//        ArrayList<String> list = new ArrayList<>();
//        fileOperation.readFile("pride-and-prejudice.txt",list);
////        System.out.println(list.size());
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < list.size(); i++) {
//            avl.add(list.get(i),0);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(avl.getSize() + " words!\r\nconsume: " + (end - start) + "ms!");
//        System.out.println("Is BST: " + avl.isBST());
//        System.out.println("Is Balance: " + avl.isBalanceTree());

    }


}
