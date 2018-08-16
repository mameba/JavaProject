package dataStructure.queue;

import dataStructure.array.Array;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue() {
        array = new Array<E>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
    }
    @Override
    public E deQueue() {
        return array.removeFirst();
    }

    @Override
    public void enQueue(E element) {
        array.addLast(element);
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack:");
        result.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if(i != array.getSize() - 1) {
                result.append(",");
            }
        }
        result.append("] tail");
        return result.toString();
    }
}
