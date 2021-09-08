package 알고리즘스터디_문제List.week3;

import java.io.BufferedReader;
import java.util.Scanner;

/**
 * 구간합
 */
public class Bj_16507_어두운건무서워 {
    static int[][] dp;
    static int R, C, Q, r1, c1, r2, c2;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        Q = sc.nextInt();
        dp = new int[R + 1][C + 1];

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                //dp[i][j] = dp[1][1] ~ dp[i][j] 까지의 합
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + sc.nextInt();
            }
        }

        for (int i = 0; i < Q; i++) {
            r1 = sc.nextInt();
            c1 = sc.nextInt();
            r2 = sc.nextInt();
            c2 = sc.nextInt();
            //더한 셀의 수
            int cnt = (r2 - r1 + 1) * (c2 - c1 + 1);
            //구간 합
            int sum = dp[r2][c2] - dp[r1 - 1][c2] - dp[r2][c1 - 1] + dp[r1 - 1][c1 - 1];
            System.out.println(sum/cnt);
        }
    }

}
