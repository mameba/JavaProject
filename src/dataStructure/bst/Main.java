package dataStructure.bst;

/**
 * Created by zhangcy
 * on 2018/8/19.
 */
public class Main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] num = {5, 3, 4, 2, 8};
        for (int i = 0; i < num.length; i++) {
            bst.add(num[i]);
        }
        bst.preOrder();
        System.out.println("");
        bst.preOrderNR();
        System.out.println("");
        bst.inOrder();
        System.out.println("");
        bst.postOrder();
        System.out.println("");
        bst.levelOrder();
    }
}
