package dataStructure.queue;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public interface Queue<E> {

    E deQueue();
    void enQueue(E element);
    E getFront();
    int getSize();
    boolean isEmpty();
}
