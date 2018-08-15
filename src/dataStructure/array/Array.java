package dataStructure.array;

/**
 * Created by zhangcy
 * on 2018/8/15.
 */
public class Array<E> {

    //当前数组大小
    private int size;

    //当前数组
    private E[] data;

    /**
     * 生成一个默认容量为10的数组
     */
    public Array() {
        this(10);
    }

    /**
     * 生成一个指定容量大小的数组
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 在数组指定位置添加元素
     * @param index 位置  element 元素
     */
    public void add(int index, E element) {
        if(size == data.length)
            throw new IllegalArgumentException("add false.array is full.");
        if(index < 0 || index > size) {
            throw new IllegalArgumentException("add false.index is illegal.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i+1] = data [i];
        }
        size ++;
        data[index] = element;
    }

    /**
     * 在数组开始添加元素
     * @param element 元素
     */
    public void addFirst(E element) {
        add(0, element);
    }

    /**
     * 在数组末尾添加元素
     * @param element 元素
     */
    public void addLast(E element) {
        add(size, element);
    }

    /**
     * 判断数组中是否存在指定元素
     * @param element 元素
     * @return boolean true存在 false不存在
     *
     */
    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if(data[i] == element) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找数组中是否包含指定元素，如果有返回元素所在下标，否则返回-1
     * @param element 元素
     * @return int 元素所在位置
     */
    public int find(E element) {
        for (int i = 0; i < size; i++) {
            if(data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回指定下表的元素
     * @param index 下标
     * @return int 元素
     */
    public E get(int index) {
        if (index < 0 || index > size){
            throw new IllegalArgumentException("get failed. index is illegal.");
        }
        return data[index];
    }

    /**
     * 查询数组容量
     * @return int 数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 查询当前数组大小
     * @return int 当前数组大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 查询数组是否为空
     * @return boolean true数组为空 false数组不为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 移除指定位置的元素，并返回移除元素值
     * @param index 下标
     * @return int 元素值
     */
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed. index is illegal.");
        }
        E element = data[index];
        System.arraycopy(data, index + 1, data, index, size - index);
        size--;
        return element;
    }

    /**
     * 移除指定元素
     * @param element
     */
    public void removeElement(E element) {
        int index = find(element);
        if(index != -1) {
            remove(index);
        }
    }

    /**
     * 移除数组第一个元素，并返回移除元素值
     * @return int 元素值
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 移除数组最后一个元素，并返回移除元素值
     * @return int 元素值
     */
    public E removeLast() {
        return remove(size);
    }

    /**
     * 设置数组指定位置的元素值
     * @param index element
     */
    public void set(int index, E element) {
        if(index < 0 || index > size ) {
            throw new IllegalArgumentException("set failed. index is illegal.");
        }
        data[index] = element;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("Array size:%d, capacity:%d\n", size, data.length));
        result.append('[');
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if(i != size -1)
                result.append(",");
        }
        result.append(']');
        return result.toString();
    }
}
