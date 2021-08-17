package practice;

/*
 * 1,2,3 더하기 재귀함수 ver
 * */

import java.util.Scanner;

public class Bj_9095 {
    public static int result(int sum, int goal) {
        if (sum > goal) {
            return 0;
        }
        if (sum == goal) {
            return 1;
        }
        int now = 0;
        for (int i = 1; i <= 3; i++) {
            now += result(sum + i, goal);
        }
        return now;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            System.out.println(result(0, n));
        }
    }
}
