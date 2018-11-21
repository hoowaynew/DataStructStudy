package cn.itcast.day1108BinarySearchTree;

import java.util.ArrayList;
import java.util.Random;

public class DemoMain {

    public static void main(String[] args) {

        BFS<Integer> bfs = new BFS<>();
//        System.out.println(bfs.minimum());
        System.out.println(bfs.getSize());
        System.out.println(bfs.isEmpty());
        int[] arr = {5, 6, 3, 8, 4, 2, 9};
        /*
         *                 5
         *             3      6
         *           2  4       8
         *                        9
         *
         *
         *
         *
         * */
        for (int i = 0; i < arr.length; i++) {
            bfs.add(arr[i]);
        }

//        System.out.println(bfs.contains(6));
        System.out.println("-------前序遍历-------");
        bfs.preOrder();
        System.out.println("-------中序遍历-------");
        bfs.inOrder();
        System.out.println("-------后序遍历-------");
        bfs.posOrder();

        System.out.println("=====================");
        bfs.preOrderNR();

        System.out.println("========toString=======");
        System.out.println(bfs);

        System.out.println("-------层序遍历-------");
        bfs.levelOrder();

       /* System.out.println("-------查找最小值-------");
        System.out.println(bfs.minimum());

        System.out.println("-------查找最大值-------");
        System.out.println(bfs.maxmum());*/
        System.out.println("-------删除二分搜索树最小值-------");
        bfs.removeMin();
        System.out.println(bfs);

        System.out.println("-------删除二分搜索树最大值-------");
        bfs.removeMax();
        System.out.println(bfs);

        System.out.println("-------删除二分搜索树指定元素-------");
        bfs.remove(6);
        System.out.println(bfs);


        System.out.println("-------清空二分搜索树-------");
        bfs.clean();
        System.out.println(bfs);
        System.out.println("===========================");

/*//        ArrayList<Integer> alist = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            bfs.add(rand.nextInt(10000));
        }
        System.out.println(bfs);
        System.out.println("-------查找最小值-------");
        System.out.println(bfs.minimum());

        System.out.println("-------查找最大值-------");
        System.out.println(bfs.maxmum());

        System.out.println("-------前序遍历-------");
        bfs.preOrder();
        System.out.println("-------中序遍历-------");
        bfs.inOrder();
        System.out.println("-------后序遍历-------");
        bfs.posOrder();

        System.out.println("=====================");
        bfs.preOrderNR();

        System.out.println("-------层序遍历-------");
        bfs.levelOrder();*/


    }
}
