package basic;

import java.util.Scanner;

public class Bj_11404_플로이드 {
    static int[][] route = new int[101][101]; // edges
    static int N; // 도시의 개수

    static {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                //비용 INF로 초기화
                route[i][j] = Integer.MAX_VALUE;
                //자기 자신의 경우 비용은 0
                if (i == j) {
                    route[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int busNum = sc.nextInt();
        for (int i = 0; i < busNum; i++) {
            int a = sc.nextInt(); // 시작 도시
            int b = sc.nextInt(); // 도착 도시
            int c = sc.nextInt(); // 비용

            //경로가 하나가 아닐 수 있다는 조건.
            route[a][b] = Math.min(c, route[a][b]);
        }

        floyd();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(route[i][j] == Integer.MAX_VALUE ? 0 : route[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * 최단경로(비용) 계산
     */
    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    //거쳐가는 경로 중 하나라도 INF라면 (끊겨있다면) 기존 값이 더 작을 수 밖에 없으므로 skip
                    if (route[i][k] == Integer.MAX_VALUE || route[k][j] == Integer.MAX_VALUE) continue;
                    ;
                    //가장 작은 경로 값 적용
                    route[i][j] = Math.min(route[i][j], route[i][k] + route[k][j]);
                }
            }
        }
    }
}
