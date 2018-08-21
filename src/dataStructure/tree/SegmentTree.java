package dataStructure.tree;

/**
 * 线段树
 * Created by zhangcy
 * on 2018/8/21.
 */
public class SegmentTree<E> {

    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger) {

        this.merger = merger;

        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }

        tree = (E[]) new Object[arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {

        if(l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l , mid);
        buildSegmentTree(rightTreeIndex, mid+1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public E get(int index) {
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("SegmentTree get failed. index is illegal.");
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return 2*index + 1;
    }

    private int rightChild(int index) {
        return 2*index + 2;
    }

    /**
     * 查询线段树给定区间的元素操作结果
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL, int queryR) {
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length)
            throw new IllegalArgumentException("SegmentTree query failed. index is illegal.");
        return query(0, 0 , data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

         if(l == queryL && r == queryR)
             return tree[treeIndex];
         int mid = l + (r - l) / 2;
         int leftTreeIndex = leftChild(treeIndex);
         int rightTreeIndex = rightChild(treeIndex);

         if(queryL >= mid + 1)
             return query(rightTreeIndex, mid + 1, r, queryL, queryR);
         else if(queryR <= mid)
             return query(leftTreeIndex, l, mid, queryL, queryR);

         E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
         E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
         return merger.merge(leftResult, rightResult);
    }

    public void set(int index, E element) {
        if(index < 0 || index >= data.length)
            throw new IllegalArgumentException("SegmentTree set failed. index is illegal.");
        data[index] = element;
        set(0, 0, data.length - 1, index, element);
    }

    /**
     * 在以treeIndex为根的线段树中更新index的值为e
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {

        if(l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if(index >= mid + 1)
            set(rightTreeIndex, mid + 1, r, index, e);
        else
            set(leftTreeIndex, l, mid, index, e);
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if(tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");
            if(i != tree.length - 1)
                res.append(",");
        }
        res.append(']');
        return res.toString();
    }
}
