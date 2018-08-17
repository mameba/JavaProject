package pattern.proxy.dynamic;

import pattern.proxy.RealSubject;
import pattern.proxy.Subject;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Subject subject = (Subject) java.lang.reflect.Proxy.newProxyInstance(Client.class.getClassLoader(), new Class[]{Subject.class}, new JdkProxy(new RealSubject()));
        subject.subject();
    }
}
