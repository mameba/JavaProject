package pattern.proxy.dynamic;

import pattern.proxy.RealSubject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by zhangcy
 * on 2018/8/13.
 */
public class JdkProxy implements InvocationHandler{

    private RealSubject realSubject;

    public JdkProxy (RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before");
        Object result;
        try {
            result = method.invoke(realSubject, args);
        } catch (Exception e) {
            System.out.println("ex:" + e);
            throw e;
        } finally {
            System.out.println("after");
        }
        return result;
    }
}
