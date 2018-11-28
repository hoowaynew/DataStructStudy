package cn.itcast.day1127SegmentTree;

public interface Merger<E> {

    E merge(E a, E b);
}
