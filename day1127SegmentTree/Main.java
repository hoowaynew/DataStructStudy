package cn.itcast.day1127SegmentTree;

public class Main {

    public static void main(String[] args) {

        Integer[] nums = {-2, 1, 0, 4, -2, 5, -6, 7, 2};

        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);

        System.out.println(segmentTree);

        System.out.println(segmentTree.query(1,4));

        segmentTree.set(2,5);
        System.out.println(segmentTree);
        System.out.println(segmentTree.query(0,2));
    }
}
