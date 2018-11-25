package cn.itcast.day1123Map;

public class BSTMain {

    public static void main(String[] args) {
        BSTMap<String,Integer> bstMap = new BSTMap<>();
        bstMap.add("hello",222);
        bstMap.add("hey",2);
        bstMap.add("java",3);
        bstMap.add("python",4);
        bstMap.set("hey",10);
        System.out.println(bstMap.getSize());
        System.out.println(bstMap.get("hey"));

        Integer rem = bstMap.remove("hello");
        System.out.println(rem);

        System.out.println(bstMap.getSize());
    }
}
