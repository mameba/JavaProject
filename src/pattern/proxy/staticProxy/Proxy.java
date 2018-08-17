package pattern.proxy.staticProxy;

import pattern.proxy.RealSubject;
import pattern.proxy.Subject;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy (RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void subject () {
        System.out.println("before");
        realSubject.subject();
        System.out.println("after");
    }
}
