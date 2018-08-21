package dataStructure.map;

import dataStructure.bst.BST;

/**
 * Created by zhangcy
 * on 2018/8/20.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        private Node left, right;

        public Node(K key, V value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value) {
            this(key, value, null, null);
        }

        public Node() {
            this(null, null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;
    private int size;

    @Override
    public void add(K key, V value) {

        add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null) {
            size++;
            return new Node(key, value);
        }
        if(key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if(key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        return node;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return get(key) != null;
    }

    @Override
    public V get(K key) {

        return get(root, key).value;
    }

    private Node get(Node node, K key) {
        if(node == null)
            return null;
        if(node.key.equals(key))
            return node;
        else if(key.compareTo(node.left.key) < 0)
            return get(node.left, key);
        else
            return get(node.right, key);
    }

    @Override
    public void set(K key, V newValue) {
        Node cur = get(root, key);
        if(cur == null)
            throw new IllegalArgumentException("BSTMap set  failed. key is not exists.");
        cur.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
