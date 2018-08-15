package pattern.chain;

/**
 * Created by zhangcy on 2018/8/14.
 */
public class Client {

    private static class HandlerA extends Handler {

        @Override
        protected void handlerProcessor() {
            System.out.println("handlerA is execute.");
        }
    }

    private static class HandlerB extends Handler {

        @Override
        protected void handlerProcessor() {
            System.out.println("handlerB is execute.");
        }
    }

    private static class HandlerC extends Handler {

        @Override
        protected void handlerProcessor() {
            System.out.println("handlerC is execute.");
        }
    }

    public static void main(String[] args) {
        Handler handlerA = new HandlerA();
        Handler handlerB = new HandlerB();
        Handler handlerC = new HandlerC();
        handlerA.setSuccessor(handlerB);
        handlerB.setSuccessor(handlerC);

        handlerA.execute();
    }
}
