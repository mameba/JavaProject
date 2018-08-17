package dataStructure.queue;


/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public class LinkedListQueue<E> implements Queue<E>{

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

    private Node front, tail;
    private int size;

    public LinkedListQueue() {
        front = null;
        tail = null;
        size = 0;
    }

    @Override
    public E deQueue() {
        if(front == null)
            throw new IllegalArgumentException("LinkedListQueue deQueue failed. LinkedListQueue is empty.");
        Node temp = front;
        front = front.next;
        temp.next = null;
        if(front == null)
            tail = null;
        size -- ;
        return temp.element;
    }

    @Override
    public void enQueue(E element) {
        if(front == null) {
            front = new Node(element);
            tail = front;
        }else {
            tail.next = new Node(element);
            tail = tail.next;
        }
        size--;
    }

    @Override
    public E getFront() {
        if(front == null)
            throw new IllegalArgumentException("LinkedListQueue getFront failed. LinkedListQueue is empty.");
        return front.element;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Queue: front ");
        Node cur = front;
        while (front != null) {
            result.append(front + "->");
            front = front.next;
        }
        result.append("NULL tail");
        return result.toString();
    }
}
