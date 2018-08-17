package dataStructure.stack;

import java.util.Random;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public class Main {

    private static void testStack(Stack stack, int optNum) {
        Long startTime1 = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optNum; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        Long endTime1 = System.nanoTime();
        System.out.println(stack.getClass().getName() + " push time: " + (endTime1 - startTime1)/1000000000.0 + "s");
        Long startTime2 = System.nanoTime();
        for (int j = 0; j < optNum; j++) {
            stack.pop();
        }
        Long endTime2 = System.nanoTime();
        System.out.println(stack.getClass().getName() + " pop time: " + (endTime2 - startTime2)/1000000000.0 + "s");
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        testStack(arrayStack, 100000);
        testStack(linkedListStack, 100000);
    }
}
