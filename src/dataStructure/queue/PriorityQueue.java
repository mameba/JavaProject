package dataStructure.queue;

import dataStructure.heap.MaxHeap;

/**
 * Created by zhangcy
 * on 2018/8/21.
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> data;

    public PriorityQueue() {
        data = new MaxHeap<>();
    }

    @Override
    public E deQueue() {
        return data.extractMax();
    }

    @Override
    public void enQueue(E element) {
        data.add(element);
    }

    @Override
    public E getFront() {
        return data.findMax();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }
}
