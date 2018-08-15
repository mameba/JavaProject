package netease;

import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] time, rate, isSleep;
            int totalTime, everTime, result = 0, max = 0, current = 0;
            if (sc.hasNextLine()) {
                time = format(sc.nextLine());
                totalTime = time[0];
                everTime = time[1];
            } else {
                return;
            }
            if (sc.hasNextLine()) {
                rate = format(sc.nextLine());
            } else {
                return;
            }

            if (sc.hasNextLine()) {
                isSleep = format(sc.nextLine());
            } else {
                return;
            }

            for (int i = 0; i < totalTime; i++) {
                if (isSleep[i] == 1) {
                    result += rate[i];
                }
            }

            for (int j = 0; j <= totalTime - everTime; j++) {
                current = 0;
                for (int k = 0; k < everTime; k++) {
                    if (isSleep[j+k] == 0) {
                        current += rate[j+k];
                    }
                }

                if (current > max) {
                    max = current;
                }
            }
            System.out.println(result+max);
        }

        private static int[] format(String arr) {
            String[] arrays = arr.split(" ");
            int[] num = new int[arrays.length];
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.valueOf(arrays[i]);
            }
            return num;
        }
    }
