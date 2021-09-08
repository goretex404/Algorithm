package 알고리즘스터디_문제List.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj_1967_트리의지름 {
    static LinkedList<Node>[] tree;
    static int n;
    static int max, max_idx;
    static int[] dist;
    static boolean[] visited;

    static class Node{
        int node, dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            tree[i] = new LinkedList<>();
        }
        //간선정보
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, weight));
            tree[child].add(new Node(parent, weight));
        }

        //가장 긴 길이의 노드 탐색
        visited = new boolean[n + 1];
        visited[1] = true;
        dfs(1, 0);

        //위에서 탐색한 max노드를 root로 재탐색
        visited = new boolean[n + 1];
        visited[max_idx] = true;
        dfs(max_idx, 0);

        System.out.print(max);

        br.close();
    }

    public static void dfs(int idx, int dist) {
        if(max < dist){
            max = dist;
            max_idx = idx;
        }
        for (Node n : tree[idx]) {
            if (!visited[n.node]) {

                visited[n.node] = true;
                dfs(n.node, dist + n.dist);
            }
        }
    }



}
