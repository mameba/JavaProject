package pattern.chain.chain;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangcy
 * on 2018/8/14.
 */
public class Client {

    static class ChainHandlerA extends ChainHandler {

        @Override
        protected void handlerProcess() {
            System.out.println("chainHandlerA is execute.");
        }
    }

    static class ChainHandlerB extends ChainHandler {

        @Override
        protected void handlerProcess() {
            System.out.println("chainHandlerB is execute.");
        }
    }
    static class ChainHandlerC extends ChainHandler {

        @Override
        protected void handlerProcess() {
            System.out.println("chainHandlerC is execute.");
        }
    }

    public static void main(String[] args) {
        List<ChainHandler> handlers = Arrays.asList(
                new ChainHandlerA(),
                new ChainHandlerB(),
                new ChainHandlerC()
        );
        Chain chain = new Chain(handlers);
        chain.process();
    }
}
