package cn.itcast.day1027;

public class Array<E> {
    // size用来统计数组元素的个数，size始终指向data数组第一个空位
    private E[] data;
    private int size;

    // 1.默认设置数组容量为10
    public Array() {
        //this.size = 10;
        this(10);
    }

    // 2.由用户传入初始化数组的长度
    public Array(int capacity) {
        data = (E[]) new Object[capacity];  // 强制类型转换
    }

    // 3.获取数组元素的长度
    public int getSize() {
        return size;
    }

    // 4.获取数组的长度
    public int getCapacity() {
        return data.length;
    }

    // 5.判断数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 6.在数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    // 8.获取指定数组索引元素
    public E getElement(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("inquire fail, input indexOutOfBounds!");
        return data[index];
    }

    // 9.修改指定数组索引元素
    public void setElement(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("set fail, input indexOutOfBounds!");
        data[index] = e;
    }

    // 10.在任意位置插入元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("addLast fail, input error!");
        }
        if (size == data.length)
            resize(2 * data.length);
            //throw new IllegalArgumentException("addLast fail, the array is full!");
        for (int i = size - 1; i >= index; i--) {
            //System.out.println(data[i+1]);  // test
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    // 11. 查询数组是否包含某个元素
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i]))
                return true;
        }
        return false;
    }

    // 12.删除指定索引元素并返回，否则返回-1
    public E remove(int index) {
        E flag = null;
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("remove fail, input indexOutOfBounds!");
        flag = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size--;
        data[size] = null;  // java优化，干掉size位置的元素索引，以便由JVM虚拟机进行内存回收

        if(size == data.length/4 && data.length/2 != 0)
            resize(data.length/2);
        return flag;
    }

    // 13.删除第一个元素并返回，否则返回-1
    public E removeFirst() {
        return remove(0);
    }

    // 14.删除第一个元素并返回，否则返回-1
    public E removeLast() {
        return remove(size-1);
    }

    // 15.删除数组重复元素
    public boolean removeRepetion() {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size ; j++) {
                if (data[i].equals(data[j])) {
                    remove(j);
                    flag = true;
                }
            }
        }
        return flag;
    }


    // 16. 覆盖重写toString()方法
    @Override
    public String toString() {
        String str = "数组容量为：" + getCapacity() + ", 数组元素个数为： " + getSize() + "\n[ ";
        int i = 0;
        for (; i < getSize() - 1; i++) {
            str += getElement(i) + ", ";
        }
        str += getElement(i) + " ]";
        return str;
    }

    // 数组调整函数
    public void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
