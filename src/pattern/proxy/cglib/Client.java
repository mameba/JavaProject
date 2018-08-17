package pattern.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import pattern.proxy.RealSubject;
import pattern.proxy.Subject;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new CglibProxy());
        Subject subject = (Subject) enhancer.create();
        subject.subject();
    }

}
