package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * topologicalSort
 * 위상 정렬은 그래프 정렬을 말한다.
 * 위상 정렬이 가능하려면 DAG(Directed Acyclic Graph, 방향성이 있으며 사이클이 없는 그래프)여야 한다
 */
public class 위상정렬연습 {
    static int n;
    static int e;

    public static void main(String[] args) {
        n = 7; // 정점 갯수
        e = 9; // 간선 갯수

        int[] indegree = new int[n + 1]; // 해당 노드를 가리키는 간선 갯수를 담기 위한 배열

        //그래프의 관계를 표현하기 위한 2차원 인접 리스트
        List<List<Integer>> arr = new ArrayList<List<Integer>>();

        for (int i = 0; i < n + 1; i++) {
            arr.add(new ArrayList<Integer>());
        }

        //간선 목록 v1 -> v2
        int[] v1 = {1, 1, 2, 2, 3, 3, 4, 5, 5};
        int[] v2 = {2, 3, 4, 5, 4, 7, 6, 4, 6};

        /**
         *  1. v1 -> v2 인접리스트 생성
         *  2. v2를 가리키는 노드 갯수 indegree 증가
         */
        for (int i = 0; i < e; i++) {
            int c1 = v1[i];
            int c2 = v2[i];

            arr.get(c1).add(c2);
            indegree[c2]++;
        }
        topologicalSort(indegree, arr);
    }

    static void topologicalSort(int[] indegree, List<List<Integer>> arr){
        Queue<Integer> q = new LinkedList<Integer>();
        Queue<Integer> result = new LinkedList<Integer>();

        //큐에 indegree가 0인 노드 담기
        for (int i = 1; i < n + 1; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        /**
         * 1. 큐에서 값을 꺼내며 해당 노드가 가리키는 노드의 indegree를 1 감소
         * 2. 만약 indegree가 0이 된다면 큐에 넣기
         * 3. 큐가 빌때까지 반복
         */
        while (!q.isEmpty()){
            int node = q.poll();
            result.offer(node);

            for(Integer i : arr.get(node)){
                indegree[i]--;

                if(indegree[i] ==0){
                    q.offer(i);
                }
            }
        }
        System.out.println(result);
    }

}
