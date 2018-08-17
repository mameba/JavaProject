package Sort;

import java.util.Arrays;

/**
 * Created by zhangcy
 * on 2018/8/10.
 */
public class QuickSort {

    private static int num = 0;

    public static void main(String[] args) {
        int[] arr = {9,12,5,45,67,23};
        System.out.println(Arrays.toString(arr));
        QuickSort slut = new QuickSort();
        System.out.println(Arrays.toString(slut.sort(arr, 0, arr.length - 1)));

    }

    private int[] sort (int[] a, int left, int right) {
        int temp;
        int i = left, j = right;

        if (left < right) {
            temp = a[left];

            while (i != j) {
                while (i < j && a[j] > temp)
                    --j;
                if (i < j) {
                    a[i] = a[j];
                    ++i;
                }
                while (i < j && a[i] < temp)
                    ++i;
                if (i < j) {
                    a[j] = a[i];
                    --j;
                }
            }

            a[i] = temp;
            ++num;
            System.out.println("第" + num + "次快排：" + Arrays.toString(a));
            sort(a,left,i-1);
            sort(a,i+1,right);
        }

        return a;
     }
}
