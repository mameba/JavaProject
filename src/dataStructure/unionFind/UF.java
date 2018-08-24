package dataStructure.unionFind;

/**
 * Created by zhangcy
 * on 2018/8/22.
 */
public interface UF {

    int getSize();
    boolean isConnected(int p, int q);
    void unionElement(int p, int q);
}
