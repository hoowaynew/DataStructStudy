package cn.itcast.day1101LinkList;

public class DemoMain {
    public static void main(String[] args) {
        LinkList<Integer> list = new LinkList<>();
        for (int i = 0; i < 5; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
        list.add(100,2);
        System.out.println(list);
        list.addLast(110);
        System.out.println(list);

        System.out.println(list.getElement(4));
        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        System.out.println(list);
        System.out.println(list.contains(110));
    }
}
