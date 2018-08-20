package beike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhangcy
 * on 2018/8/18.
 */
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt(); //社团数量
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            int start, end;
            List<Integer> list = new ArrayList<>();
            start = scanner.nextInt();
            end = scanner.nextInt();
            list.add(i);
            list.add(start);
            list.add(end);
            if(i == 0 || (start > lists.get(i - 1).get(1))) {
                lists.add(list);
            }else {
                for (int j = 0; j < lists.size(); j++) {
                    if(start < lists.get(j).get(1)) {
                        lists.add(j, list);
                        break;
                    }
                }
            }
        }
        for (int j = 0; j < num; j++) {
            List<List<Integer>> curList = new ArrayList<>(lists);
            curList.remove(j);
            if(isValid(curList))
                result.add(j + 1);
        }
        int size = result.size();
        if(size == 0) {
            System.out.println(0);
        }else {
            System.out.println(size);
            for (int i = 0; i < size; i++) {
                System.out.print(result.get(i) + " ");
            }
        }
    }

    private static boolean isValid(List<List<Integer>> lists) {
        if(lists.size() < 2)
            return true;
        for (int i = 0; i < lists.size() - 1; i++) {
            if(lists.get(i + 1).get(1) < lists.get(i).get(2))
                return false;
        }
        return true;
    }
}
