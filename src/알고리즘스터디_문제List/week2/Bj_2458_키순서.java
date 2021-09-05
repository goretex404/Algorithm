package 알고리즘스터디_문제List.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 플로이드와샬 응용문제
 */
public class Bj_2458_키순서 {
    static int N, M; // N : 학생 수 , M : 키를 비교한 횟수
    static int a, b; // input 받는 학생 a,b
    static int[][] dist;
    static int INF = 9876543;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //배열 초기화
        dist = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dist[i][j] = INF;
            }
        }

        //입력
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            //자신의 키 순서를 아는 경우 배열 1로 갱신
            dist[a][b] = 1;
        }

        floyd();

        ans = 0;
        for (int i = 1; i <= N; i++) {
            dist[i][i] = 0;
            boolean chk = true;
            for (int j = 1; j <= N; j++) {
                if (Math.min(dist[i][j],dist[j][i])==INF){
                    chk = false;
                    break;
                }
            }
            if(chk) ans++;
        }

        bw.write(ans +"\n");
        bw.flush();
        br.close();
        bw.close();

    }
    //특정 학생과 모든 학생과의 거리 체크 - 플로이드 와셜
    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <=N; i++) {
                for (int j = 1; j <= N; j++) {
                    //dist[i][j]보다 작은 값이 나올 경우 갱신
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}
