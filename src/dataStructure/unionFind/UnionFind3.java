package dataStructure.unionFind;

/**
 * Created by zhangcy
 * on 2018/8/23.
 */
public class UnionFind3 implements UF{

    private int[] parent;
    private int[] sz;  //sz[i]表示以i为根的集合中元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        sz = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 查找元素p所对应的集合编号
     * @param p
     * @return
     */
    private int find(int p) {

        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("UnionFind2 find failed. p is illegal.");
        while(p != parent[p])
            p = parent[p];
        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if(pRoot == qRoot)
            return;

        if (sz[pRoot] < sz[qRoot]) {
            parent[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        } else {
            parent[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        }
    }
}
