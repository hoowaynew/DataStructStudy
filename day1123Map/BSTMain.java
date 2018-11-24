package cn.itcast.day1123Map;

public class BSTMain {

    public static void main(String[] args) {
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        bstMap.add("hello",1);
        bstMap.add("hi",2);
        bstMap.add("java",3);
        bstMap.add("python",4);
        bstMap.set("hi",100);
        System.out.println(bstMap.getSize());
        System.out.println(bstMap.get("hi"));

        System.out.println();
        String key = bstMap.removeMin();
        System.out.println(key + ":" + bstMap.get(key));
        System.out.println(bstMap.contains(key));
    }
}
