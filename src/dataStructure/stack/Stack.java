package dataStructure.stack;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();
}
