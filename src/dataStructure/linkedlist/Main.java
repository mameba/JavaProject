package dataStructure.linkedlist;

/**
 * Created by zhangcy
 * on 2018/8/17.
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(3, 666);
        System.out.println(linkedList);

        linkedList.remove(3);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
