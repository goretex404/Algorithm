package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * DP
 *       1 2 3 4 5 6 7 8 9 10
 *    1  1 1 1 1 1 1 1 1 1 1
 *    2  0 1 1 2 2 3 3 4 4 5
 *    5  0 0 0 0 1 1 2 2 3 4
 *  tot    2 2 3 4 5 6 7 8 10
 *
 *  메모리제한 4MB로 1차원 배열로해야한다.
 */
public class Bj_2293_동전1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }

        //
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = coin[i]; j <= k; j++) {
                dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[k]);

        br.close();
    }
}
