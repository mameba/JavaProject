package dataStructure.linkedlist;

/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public class LinkedList<E> {

    private class Node {
        public E element;
        public Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this(element, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return element.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("linkedlist add failed. index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node (element, prev.next);
        size ++;
    }

    public E get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("linkedlist get failed. index is illegal.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E element) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("linkedlist set failed. index is illegal. ");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.element = element;
    }

    public boolean contains(E element) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if(cur.element.equals(element))
                return true;
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("linkedlist remove failed. index is illegal.");
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        size --;
        return temp.element;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Node cur = dummyHead.next; cur!=null ; cur=cur.next) {
            result.append(cur.element + "->");
        }
        result.append("NULL");
        return result.toString();
    }
}
