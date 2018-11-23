package cn.itcast.day1121Set;

import java.util.ArrayList;

public class LinkListSet<E> implements MySet<E> {

    LinkList<E> linkList;

    public LinkListSet() {
        linkList = new LinkList<>();
    }

    @Override
    public void add(E e) {
        if(!linkList.contains(e))
            linkList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkList.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return linkList.contains(e);
    }

    @Override
    public int getSize() {
        return linkList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public String toString() {
        return "LinkListSet{" +
                "linkList=" + linkList +
                '}';
    }

    // test
    public static void main(String[] args) {
        LinkList<String> linkList = new LinkList<>();
//        linkList.addFirst("hi");
        linkList.addFirst("hello");
//        linkList.addFirst("java");
        System.out.println(linkList);
        linkList.remove("hello");
        System.out.println(linkList);
//        System.out.println(linkList);
        LinkListSet<Integer> linkListSet = new LinkListSet<>();
//        linkListSet.add("hello");
//        linkListSet.add("hello");
//        linkListSet.add("hi");
//        linkListSet.add("java");
////        linkListSet.add("hi");
//        for (int i = 0; i < 1000; i++) {
//            linkListSet.add(i);
//        }
//        System.out.println(linkListSet);
//
//
//        BSTSet<Integer> bstSet = new BSTSet<>();
//        for (int i = 0; i < 1000; i++) {
//            bstSet.add(i);
//        }
//        System.out.println(bstSet);
    }
}
