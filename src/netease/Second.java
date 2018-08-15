package netease;

import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/11.
 */
public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] times = new int[m], results = new int [m];
        for (int j = 0; j < m; j++) {
            times[j] = sc.nextInt();
        }
        int k = 0;
        while (k < m) {
            int cur = times[k], temp = 0, l = 0;

            while (temp < cur && l <= n) {
                temp += nums[l];
                l++;
            }

            if (l <= n) {
                results[k] = l;
            }
            k++;
        }

        for (int o = 0; o < results.length; o++) {
            System.out.println(results[o]);
        }
    }
}
