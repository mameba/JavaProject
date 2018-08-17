package pattern.proxy.staticProxy;

import pattern.proxy.RealSubject;
import pattern.proxy.Subject;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = new Proxy(new RealSubject());
        subject.subject();
    }
}
