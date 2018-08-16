package dataStructure.stack;

import dataStructure.array.Array;

/**
 * Created by zhangcy on 2018/8/16.
 */
public class ArrayStack<E> implements Stack<E> {

    Array<E> array;

    public ArrayStack() {
        array = new Array<>();
    }

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
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
    public void push(E element) {
        array.addLast(element);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.get(array.getSize() - 1);
    }

    public int capacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Stack：" );
        result.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            result.append(array.get(i));
            if(i != array.getSize() - 1) {
                result.append(",");
            }
        }
        result.append("] top");
        return result.toString();
    }
}
