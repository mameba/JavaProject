package beike.test;

import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/18.
 */
public class First {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double data;
        int num;
        while (scanner.hasNext()) {

            data = scanner.nextInt();
            num = scanner.nextInt();
            sum(data, num);
        }
    }

    private static void sum(double data, int num) {
        double result = 0;
        for (int i = 0; i < num; i++) {
            result = result + data;
            data = Math.sqrt(data);
        }
        System.out.printf("%.2f", result);
    }
}
