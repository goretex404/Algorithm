package 알고리즘스터디_문제List.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 그리디
 * 현재 도시의 가격이 다음 도시의 가격보다 낮으면 다음도시와 다다음 도시까지의 이동거리만큼 주유
 */
public class Bj_13305_주유소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //도시의 개수
        int n = Integer.parseInt(br.readLine());

        long[] dist = new long[n - 1];
        long[] gas = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gas.length; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        //초기 값, 첫 도시에서 다음 도시까지는 무조건 이동이 가능해야한다
        long ans = dist[0] * gas[0];

        int now = 0;
        int next = now + 1;

        while (next < n - 1){
            //현재 도시가 다음 도시보다 저렴하면
            if(gas[now] < gas[next]){
                //다음 도시 거리만큼 주유
                ans += gas[now] * dist[next];
            }else {
                //다음 도시에서 주유
                ans += gas[next] * dist[next];
                //도시 이동
                now = next;
            }
            next++;
        }
        System.out.print(ans);
    }
}
