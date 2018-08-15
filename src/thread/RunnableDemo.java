package thread;

/**
 * Created by zhangcy on 2018/8/13.
 */
public class RunnableDemo implements Runnable{

    private String threadname;

    public RunnableDemo (String name) {
        threadname = name;
        System.out.println("Creating thread:" + threadname);
    }

    public void run() {
        System.out.println("Running thread:" + threadname);
        try {
            for (int i = 0; i < 4; i++) {
                System.out.println("Thread: " + threadname + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread：" + threadname + " interrupted.");
        }
        System.out.println("Thread:" + threadname + " exiting.");
    }
}
