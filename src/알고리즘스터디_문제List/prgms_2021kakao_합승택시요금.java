package 알고리즘스터디_문제List;

public class prgms_2021kakao_합승택시요금 {
    static int[][] dist;
    public static void main(String[] args) {
        int n = 6, s = 4 , a = 6, b = 2;
        int[][] fares = {{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41},{5,1,24},{4, 6, 50},{2, 4, 66},{2, 3, 22},{1, 6, 25}};

        System.out.print(solution(n, s, a, b, fares));
    }
    static int solution(int n, int s, int a, int b, int[][] fares) {

        dist = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(i==j)
                    dist[i][j] = 0;
                else
                    dist[i][j] = 20000001; //200 * 100000 + 1;
            }
        }

        //그래프 입력 값 초기화.
        for(int i =0; i<fares.length; i++){
            //양방향 요금이 동일하다.
            dist[fares[i][0]][fares[i][1]] = fares[i][2];
            dist[fares[i][1]][fares[i][0]] = fares[i][2];
        }

        //floyd
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(dist[i][j] > dist[i][k] + dist[k][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            answer = Math.min(answer, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return answer;
    }
}
