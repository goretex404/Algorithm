package 알고리즘스터디_문제List.week1;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  첫째줄 N = TC
 *  두 번 째 줄 부터
 *  작업시간 , 선행 작업 갯수, 선행작업들 순서로 입력된다.
 *  위상정렬
 */
public class Bj_2056_작업 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            arr.add(new ArrayList<>());
        }

        int[] indegree = new int[N + 1];
        int[] time = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            int preCase = Integer.parseInt(st.nextToken());
            for (int j = 0; j < preCase; j++) {
                int temp = Integer.parseInt(st.nextToken());
                arr.get(temp).add(i);

                indegree[i]++;
            }
        }

        bw.write(String.valueOf(topologicalSort(N, arr, indegree, time)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int topologicalSort(int N, ArrayList<ArrayList<Integer>> arr, int[] indegree, int[] time) {
        Queue<Integer> q = new LinkedList<>();
        
        int[] result = new int[N+1]; //각각의 소요 작업시간을 저장하는 배열
        for (int i = 1; i <= N; i++) {
            result[i] = time[i];
            
            //indegree가 0인 작업을 enqueue
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()){
            int now = q.poll();
            
            for(int next : arr.get(now)){
                indegree[next]--;
                
                result[next] = Math.max(result[next], result[now] + time[next]);

                //새롭게 indegree가 0이 된 작업을 큐에 넣음.
                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= N ; i++) {
            ans = Math.max(ans,result[i]);

        }
        return ans;
    }
}
