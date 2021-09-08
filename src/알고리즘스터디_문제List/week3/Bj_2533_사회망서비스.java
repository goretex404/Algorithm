package 알고리즘스터디_문제List.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Bj_2533_사회망서비스 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static int[][] dp;
    static int N;
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        //1번 노드부터 , parent는 없음. 시작
        dp(1, -1);

        bw.write(String.valueOf(Math.min(dp[1][0],dp[1][1])));

        bw.flush();
        br.close();
        bw.close();
    }

    static void dp(int cur, int parent) {
        dp[cur][0] = 0; // 현재노드 얼리어답터가 아닌경우
        dp[cur][1] = 1; // 현재노드 얼리어답터인 경우

        for (int next : list.get(cur)) {
            //next와 parent가 같으면 단말노드이다.
            if(next != parent){
                dp(next, cur);
                dp[cur][0] += dp[next][1];
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}
