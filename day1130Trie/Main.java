package cn.itcast.day1130Trie;

public class Main {

    public static void main(String[] args) {

        Trie t = new Trie();
//        t.add("hi");
//        t.add("hello");
//        t.add("hey");
//        System.out.println(t.contains("hello"));
//        System.out.println(t.isEmpty());
//        System.out.println(t.getSize());
//        System.out.println(t.isPrefix("hi"));

        t.addRecur("hi");
        t.addRecur("hi");
        t.addRecur("hello");
//        t.add("hi");
//        t.add("hi");
        System.out.println(t.contains("hello"));
        System.out.println(t.isEmpty());
        System.out.println(t.getSize());
        System.out.println(t.isPrefix("he"));
    }
}
