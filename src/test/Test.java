package test;

import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/23.
 */
public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        if(a == 1 || a == 2)
            System.out.println(1);
        else {
            String b = "1", c = "1", sum = "0";
            for(int i = 3; i <= a; i++) {
                sum = add(b, c);
                b = c;
                c = sum;
            }
            System.out.println(sum);
        }
    }

    private static String add(String a, String b) {
        char[] res = new char[a.length() + 1];
        if(b.length() > a.length()) {
            String c = b;
            b = a;
            a = c;
        }
        int flag = 0;
        for (int i = a.length(); i > 0 ; i++) {
            int aa = (int)(a.charAt(i - 1));
            if(b.length() >= i) {
                int bb = (int)(b.charAt(i - 1));
                res[i - 1] = (char) ((aa + bb + flag) % 10);
                if(aa + bb > 9)
                    flag = 1;
                else
                    flag = 0;
            } else {
                res[i - 1] = (char) ((aa + flag) % 10);
                if(aa + flag > 9)
                    flag = 1;
                else
                    flag = 0;
            }

        }
        return res.toString();
    }
}
