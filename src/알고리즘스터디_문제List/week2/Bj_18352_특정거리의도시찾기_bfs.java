package 알고리즘스터디_문제List.week2;

import java.util.*;

public class Bj_18352_특정거리의도시찾기_bfs {
    /**
     * 최단거리가 K인 모든 도시의 번호를 한줄에 하나씩 오름차순 출력
     * 간선의 비용은 모두 1이다.
     */
    static int n, m , k , x;
    static int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        x = sc.nextInt();

        dist = new int[n+1];
        visited = new boolean[n+1];
        //인접리스트 초기화
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
           int u = sc.nextInt();
           int v = sc.nextInt();
           graph.get(u).add(v);
        }
        //거리배열 초기화
        Arrays.fill(dist,INF);

        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        dist[x] = 0;
        while (!q.isEmpty()){
            int curr = q.poll();
            for(int i : graph.get(curr)) {
                if(dist[i] == INF){
                    dist[i] = dist[curr] + 1;
                    q.offer(i);
                }
            }
        }
        List<Integer> result = solve(n, k);
        for(int i : result){
            System.out.println(i);
        }
    }
    private static List<Integer> solve(int n, int k){
        List<Integer> result = new ArrayList<>();
        boolean check = false;
        for (int i=1; i<=n; i++){
            if(dist[i] == k){
                result.add(i);
                check = true;
            }
        }
        if(!check) {
            result.add(-1);
        }
        return result;
    }
}
