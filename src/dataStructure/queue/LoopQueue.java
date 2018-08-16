package dataStructure.queue;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public class LoopQueue<E> implements Queue<E> {

    private int size;
    private E[] data;
    private int front, tail;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }

    public LoopQueue() {
        this(10);
    }
    @Override
    public E deQueue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("deQueue failed.");
        }
        E element = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;
        if(size == getCapacity()/4 && getCapacity()/2 != 0) {
            resize(getCapacity() / 2);
        }
        return element;
    }

    @Override
    public void enQueue(E element) {
        if((tail+1) % data.length == front)
            resize(getCapacity() * 2);
        data[tail] = element;
        tail = (tail + 1) % data.length;
        size ++;
    }

    @Override
    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("getFront failed. loopQueue is empty.");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return tail == front;
    }

    private int getCapacity() {
        return data.length - 1;
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i+front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LoopQueue: size: %d, capacity:%d\n", size, getCapacity()));
        result.append("front [");
        for (int i = front; i != tail ; i = (i+1) % data.length) {
            result.append(data[i]);
            if(i != (tail-1) % data.length)
                result.append(",");
        }
        result.append("] tail");
        return result.toString();
    }
}
