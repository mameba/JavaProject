package pattern.chain.chain;

/**
 * Created by zhangcy
 * on 2018/8/14.
 */
public abstract class ChainHandler {

    public void execute (Chain chain) {
        handlerProcess();
        chain.process();
    }

    protected abstract void handlerProcess ();
}
