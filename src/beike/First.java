package beike;

import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/18.
 */
public class First {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int min = 10000, result = 0;
        int[] a = new int[num];
        for (int i = 0; i < num; i++) {
            a[i] = scanner.nextInt();
            result += a[i];
            if(a[i] < min)
                min = a[i];
        }
        System.out.println(result - min);
    }

//    private static void sum(double data, int num) {
//        double result = 0;
//        for (int i = 0; i < num; i++) {
//            result = result + data;
//            data = Math.sqrt(data);
//        }
//        System.out.printf("%.2f", result);
//    }

}