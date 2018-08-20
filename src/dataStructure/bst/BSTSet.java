package dataStructure.bst;

/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<E>();
    }

    @Override
    public void add(E element) {
        bst.add(element);
    }

    @Override
    public void remove(E element) {
        bst.remove(element);
    }

    @Override
    public boolean contains(E element) {
        return bst.contains(element);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
