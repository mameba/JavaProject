package beike.test;


import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/18.
 */
public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double data;
        int num;
        double result;
        while(sc.hasNext()){
            data = sc.nextInt();
            num = sc.nextInt();
            result = 0;
            int i = 0;
            while(i < num){
                result += data;
                data = Math.sqrt(data);
                i ++;
            }
            System.out.printf("%.2f", result);
        }
    }
}
