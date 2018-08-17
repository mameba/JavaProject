package pattern.chain;

/**
 * Created by zhangcy
 * on 2018/8/14.
 */
abstract class Handler {

    private Handler successor;

    public Handler getSuccessor() {
        return successor;
    }

    void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    protected abstract void handlerProcessor();

    void execute() {
        handlerProcessor();
        if (successor != null) {
            successor.execute();
        }
    }
}
