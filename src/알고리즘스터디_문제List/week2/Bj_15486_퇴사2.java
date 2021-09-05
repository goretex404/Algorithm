package 알고리즘스터디_문제List.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_15486_퇴사2 {
    /**
     * DP
     */
    static int[] T, P;
    static int N;
    static int max;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        T = new int[N + 2];
        P = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //1일부터 계산 +1 , 수익을 받는 날 +1
        DP = new int[N + 2];

        for (int i = 1; i < N + 2; i++) {
            //현재까지의 최대 수익
            if (max < DP[i]) max = DP[i];
            //현재 일 + 소요일
            int day = i + T[i];
            //회사에 있는 날 이내이면
            if (day < N + 2) {
                DP[day] = Math.max(DP[day], max + P[i]);
            }

        }

        System.out.println(max);
    }
}
