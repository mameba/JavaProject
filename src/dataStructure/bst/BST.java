package dataStructure.bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        private Node left, right;
        private E element;

        public Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void remove(E element) {
        root = remove(root, element);
    }

    private Node remove(Node node, E element) {
        if(node == null)
            return null;
        if(element.compareTo(node.element) < 0) {
            node.left = remove(node.left, element);
            return node;
        } else if (element.compareTo(node.element) > 0) {
            node.right = remove(node.right, element);
            return node;
        } else {
            if(node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }

            if(node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            return successor;
        }
    }

    private Node removeMin(Node node) {

        if(node.left == null)
            return node.right;
        else
            node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {

        if(node.left == null)
            return node;
        else
            return minimum(node.left);
    }


    public boolean contains(E element) {
        return contains(root, element);
    }

    /**
     *
     * @param node element
     */
    private boolean contains(Node node, E element) {
        if(node == null)
            return false;
        if(element.compareTo(node.element) == 0) {
            return true;
        } else if (element.compareTo(node.element) > 0) {
            return contains(node.right, element);
        } else {
            return contains(node.left, element);
        }
    }

    public void add (E element) {

        root = add(root, element);
    }

    /**
     * 向以node为根结点的二叉搜索树中添加元素 递归
     * @param node element
     * @return Node 返回插入结点后的二叉树的根结点
     **/
    private Node add(Node node, E element) {

        if(node == null) {
            size++;
            return new Node(element);
        }
        if (element.compareTo(node.element) < 0 ) {
            node.left = add(node.left, element);
        } else if (element.compareTo(node.element) > 0){
            node.right = add(node.right, element);
        }

        return node;
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if(node == null)
            return;
        System.out.println(node.element);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        preOrderNR(root);
    }

    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            Node curNode = stack.pop();
            System.out.println(curNode.element);
            if(curNode.right != null)
                stack.push(curNode.right);
            if(curNode.left != null)
                stack.push(curNode.left);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if(node == null)
            return;
        inOrder(node.left);
        System.out.println(node.element);
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if(node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.element);
    }

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node curNode = queue.remove();
            System.out.println(curNode.element);
            if(curNode.left != null)
                queue.add(curNode.left);
            if(curNode.right != null)
                queue.add(curNode.right);
        }
    }
}
