package thread;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class Main {
    public static void main(String[] args) {
        RunnableDemo R1 = new RunnableDemo("Thread-1");
        Thread t1 = new Thread(R1);
        t1.start();

        RunnableDemo R2 = new RunnableDemo("Thread-2");
        Thread t2 = new Thread(R2);
        t2.start();

        RunnableDemo R3 = new RunnableDemo("Thread-3");
        Thread t3 = new Thread(R3);
        t3.start();
    }
}
