package dataStructure.heap;

import dataStructure.array.Array;

/**
 * Created by zhangcy
 * on 2018/8/20.
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 给出一个节点的索引求其父结点的索引
     * @param index
     * @return 父结点索引
     */
    private int parent(int index) {
        if(index == 0)
            throw new IllegalArgumentException("MaxHeap parent failed. index is 0.");
        return (index - 1) / 2;
    }

    /**
     * 给出一个节点索引返回其左孩子的节点索引
     * @param index
     * @return 左孩子节点索引
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }


    /**
     * 给出一个节点索引返回其右孩子的节点索引
     * @param index
     * @return 右孩子节点索引
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E element) {
        data.addLast(element);
        SiftUp(data.getSize() - 1);
    }

    private void SiftUp(int k) {

        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 找出最大堆中的最大值
     * @return
     */
    public E findMax() {
        if(data.isEmpty())
            throw new IllegalArgumentException("MaxHeap getMax failed. Current maxHeap is empty.");
        return data.get(0);
    }

    /**
     * 移除最大值并返回
     * @param
     * @return
     */
    public E extractMax() {
        E ret = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {

        while(leftChild(k) < data.getSize()) {

            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }

            if(data.get(k).compareTo(data.get(j)) >= 0)
                break;
            data.swap(k, j);
            k = j;
        }
    }
}
