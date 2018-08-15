package dataStructure.array;

/**
 * Created by zhangcy
 * on 2018/8/15.
 */
public class Test {
    public static void main(String[] args) {
        Array tests = new Array(10);
        for (int i = 0; i < 8; i++) {
            tests.add(i,i);
        }
        System.out.println(tests.get(5));
        System.out.println(tests);
        System.out.println(tests.find(9));
        tests.add(0,100);
        System.out.println(tests);
        tests.remove(1);
        tests.addLast(200);
        tests.contains(200);
        tests.removeElement(6);
        System.out.println(tests);
        tests.addFirst(-1);
        System.out.println(tests);
    }
}
