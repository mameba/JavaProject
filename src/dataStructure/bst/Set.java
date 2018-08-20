package dataStructure.bst;

/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public interface Set<E> {

    void add(E element);
    void remove(E element);
    boolean contains(E element);
    int getSize();
    boolean isEmpty();
}
