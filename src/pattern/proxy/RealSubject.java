package pattern.proxy;

/**
 * Created by zhangcy on 2018/8/13.
 */
public class RealSubject implements Subject{

    public void subject () {
        System.out.println("real subject is executing.");
    }
}
