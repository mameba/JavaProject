package beike.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/18.
 */
public class Second {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start, end;
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNext()) {
            start = scanner.nextInt();
            end = scanner.nextInt();
            for (int i = start; i <= end ; i++) {
                int a, b, c;
                a = i / 100;
                b = i / 10 % 10;
                c = i % 10;
                if(a*a*a + b*b*b + c*c*c == i)
                    list.add(i);
            }
            if(list.isEmpty())
                System.out.println("no");
            else {
                for (Integer aList : list) {
                    System.out.print(aList + " ");
                }
            }
        }
    }
}
