package cn.itcast.day1123Map;

public class Main {

    public static void main(String[] args) {

        LinkedListMap<String,Integer> map = new LinkedListMap<>();
//        System.out.println(map.getSize());
        map.add("hello",1);
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
        System.out.println(map);
    }
}
