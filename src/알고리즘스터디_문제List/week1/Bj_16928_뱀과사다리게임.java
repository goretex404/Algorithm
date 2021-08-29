package 알고리즘스터디_문제List.week1;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Bj_16928_뱀과사다리게임 {
    private static class Node implements Comparable<Node> {
        int pos, answer;

        public Node(int pos, int answer) {
            this.pos = pos;
            this.answer = answer;
        }

        @Override
        public int compareTo(Node o) {
            return this.answer-o.answer;
        }
    }

    static int N, M;
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int[] map = new int[101];
    static boolean[] visit = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //사다리의 수 (1 <= N <= 15)
        M = sc.nextInt(); //뱀의 수 ( 1 <= M <= 15 )

        //보드
        for (int i = 1; i <= 100 ; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N; i++) {
            //사다리 map[x] = y
            map[sc.nextInt()] = sc.nextInt();
        }
            //뱀 map[u] = v
        for (int i = 0; i < M; i++) {
            map[sc.nextInt()] = sc.nextInt();
        }

        pq.add(new Node(1, 0));

        System.out.println(bfs());
    }

    private static int bfs() {
        while(!pq.isEmpty()){
            Node n = pq.poll();

            if(n.pos == 100){
                return n.answer;
            }
            //주사위
            for (int i = 1; i <= 6; i++) {
                int nowpos = n.pos + i;
                if(nowpos <= 100){
                    //방문하지 않았으면
                    if(!visit[nowpos]){
                        visit[nowpos] = true;
                        //현재 위치 enqueue & 카운트
                        pq.add(new Node(map[nowpos], n.answer + 1));
                    }
                }
            }
        }
        return -1;
    }
}
