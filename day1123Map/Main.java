package cn.itcast.day1123Map;

import cn.itcast.day1121Set.BSTSet;
import cn.itcast.day1121Set.FileOperation;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        LinkedListMap<String,Integer> map = new LinkedListMap<>();
        BSTSet<String> bstSet = new BSTSet<>();
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\a-tale-of-two-cities.txt", words);
//        System.out.println(new File("D:\\IdeaProject\\DataStructure\\Demo02Array\\DynamicArray\\src\\cn\\itcast\\pride-and-prejudice.txt").exists());
        System.out.println(words.size());
//        File file = new File("pride-and-prejudice.txt");
        for (String word : words) {
            bstSet.add(word);
        }

        for (String word : words) {
            if(!map.contains(word)) {
                map.add(word,1);
            } else {
                map.set(word,map.get(word) + 1);
            }
        }
        System.out.println(map.get("project"));
        System.out.println(map.getSize());

        System.out.println(bstSet.getSize());




//        System.out.println(map.getSize());
/*        map.add("hello",1);
        map.add("hi",1);
        map.add("java",2);
        map.add("hello",3);
        System.out.println(map);
        System.out.println(map.contains("java"));
        System.out.println(map.isEmpty());
        System.out.println(map.get("hello"));
        System.out.println(map.set("java", 100));

        Integer remo = map.remove("java");
        Integer hi = map.remove("hi");
        System.out.println(map);
        Integer hello = map.remove("hello");
        System.out.println(remo);
        System.out.println(hi);
        System.out.println(hello);
        System.out.println(map);*/
    }
}
