package 알고리즘스터디_문제List.week2;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj_18352_특정거리의도시찾기_dijkstra {
    /**
     * 최단거리가 K인 모든 도시의 번호를 한줄에 하나씩 오름차순 출력
     * 간선의 비용은 모두 1이다.
     */
    public static int INF = Integer.MAX_VALUE;
    public static int N,M,K,X;
    PriorityQueue pq = new PriorityQueue();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //도시의 개수 (Node)
        M = sc.nextInt(); //도로의 갯수 (edge)
        K = sc.nextInt(); //거리의 정보
        X = sc.nextInt(); //출발 도시의 번호

        int[][] graph = new int[N+1][N+1];
        int[] dist = new int[N+1];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i==j) graph[i][j] = 0;
                else graph[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u][v] = 1;
        }
    }
}
