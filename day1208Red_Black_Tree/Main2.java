package cn.itcast.day1208Red_Black_Tree;

import java.util.ArrayList;
import java.util.Random;

public class Main2 {

    public static void main(String[] args) {

        int n = 200000;
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            list.add(rand.nextInt(Integer.MAX_VALUE));
        }

        // Test BST
        long start = System.nanoTime();
        BST<Integer, Integer> bst = new BST<>();
        for (Integer integer : list) {
            bst.add(integer,null);
        }
        long end = System.nanoTime();
        System.out.println("BST test: " + (end-start)/1000000000.0 + "s");

        // Test AVL
        start = System.nanoTime();
        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer integer : list) {
            avl.add(integer,null);
        }
        end = System.nanoTime();
        System.out.println("AVL test: " + (end-start)/1000000000.0 + "s");

        // Test RBTree
        start = System.nanoTime();
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer integer : list) {
            rbTree.add(integer,null);
        }
        end = System.nanoTime();
        System.out.println("RBTree test: " + (end-start)/1000000000.0 + "s");
    }
}
