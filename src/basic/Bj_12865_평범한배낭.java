package basic;

import java.util.Scanner;

public class Bj_12865_평범한배낭 {
    static int N, K;
    static int[] V = new int[100];
    static int[] W = new int[100];
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();
        K = sc.nextInt();
        for (int i = 1; i <= N; i++) {
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if(j < W[i])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]]+V[i]);
            }

        }
        System.out.println(dp[N][K]);
    }

}
