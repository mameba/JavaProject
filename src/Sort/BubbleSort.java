package Sort;

import java.util.Arrays;

/**
 * Created by zhangcy on 2018/8/10.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {4,5,6,3,2,1};
        System.out.println("排序数组：" + Arrays.toString(arr));
        System.out.println(Arrays.toString(new BubbleSort().bubbleSort(arr)));
    }

    private int[] bubbleSort(int[] a) {
        int max;
        for (int i = 0, len = a.length; i < len - 1; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if (a [j+1] < a[j]) {
                    max = a[j];
                    a[j] = a[j+1];
                    a[j+1] = max;
                }
            }
        }

        return a;
    }
}
