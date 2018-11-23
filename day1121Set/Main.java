package cn.itcast.day1121Set;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BSTSet<Integer> integerBSTSet = new BSTSet<>();
        FileOperation fileOperation = new FileOperation();
        ArrayList<String> words = new ArrayList<>();
        fileOperation.readFile("a-tale-of-two-cities.txt", words);
        System.out.println(words.size());
//        File file = new File("pride-and-prejudice.txt");


    }
}
