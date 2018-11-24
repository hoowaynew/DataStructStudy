package cn.itcast.day1121Set;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        BSTSet<String> bstSet = new BSTSet<>();
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\a-tale-of-two-cities.txt", words);
//        System.out.println(new File("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\pride-and-prejudice.txt").exists());

        System.out.println(words.size());
//        File file = new File("pride-and-prejudice.txt");
        for (String word : words) {
            bstSet.add(word);
        }
        System.out.println(bstSet.getSize());


    }
}
