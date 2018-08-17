package dataStructure.queue;

import java.util.DoubleSummaryStatistics;
import java.util.Random;

/**
 * Created by zhangcy
 * on 2018/8/16.
 */
public class Main {

    /*
    * 对传进来的队列进行入队和出队时间消耗的测试
    * @param queue队列 optNum 对队列进行多少次入队和出队测试
    *
    * */
    private static void testQueue(Queue queue, int optNum) {
        Long startTime1 = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < optNum; i++) {
            queue.enQueue(random.nextInt(Integer.MAX_VALUE));
        }
        Long endTime1 = System.nanoTime();
        System.out.println(queue.getClass().getName()+"入队耗时：" + (endTime1 - startTime1) / 100000000.0 + "s");
        Long startTime2 = System.nanoTime();
        for (int j = 0; j < optNum; j++) {
            queue.deQueue();
        }
        Long endTime2 = System.nanoTime();
        System.out.println(queue.getClass().getName()+"出队耗时：" + (endTime2 - startTime2) / 1000000000.0 + "s"); ;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue();
        LoopQueue loopQueue = new LoopQueue();
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        testQueue(arrayQueue, 100000);
        testQueue(loopQueue, 100000);
        testQueue(linkedListQueue, 100000);

    }
}
