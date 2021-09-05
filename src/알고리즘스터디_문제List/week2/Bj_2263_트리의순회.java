package 알고리즘스터디_문제List.week2;

import java.io.*;
import java.util.StringTokenizer;

/**
 * inorder   = left -> root -> right
 * postorder = left -> right -> root
 * preorder  = root -> left -> right
 *
 * postorder에서 root index를 찾고
 * inoder에서 postorder에서 찾은 root index로 왼쪽 오른쪽(자식노드)을 찾아 낼 수 있다.
 *
 *
 TC =
 7
 4 2 7 5 1 3 6
 4 7 5 2 6 3 1
 */
public class Bj_2263_트리의순회 {
    static int N;
    static int[] inOrder = new int[100000];
    static int[] postOrder = new int[100000];
    static int[] pos = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        //inorder root들의 인덱스 정보를 가진 배열
        for (int i = 0; i < N; i++) {
            pos[inOrder[i]] = i;
        }

        preorder(0,N-1,0,N-1);

    }
    static void preorder(int is, int ie, int ps, int pe) {
        //종료 조건
        if(is>ie || ps>pe) return;
        //postOrder의 마지막 값은 root
        int root = postOrder[pe];

        System.out.print(root+" ");

        //inorder의 root index
        int inRoot = pos[root];
        //postorder의 왼쪽 자식 수
        int left = inRoot-is;

        //inorder의 왼쪽 자식, postorder의 왼쪽 자식의 인덱스를 param으로 재귀
        preorder(is,inRoot-1,ps,ps+left-1);
        //inorder의 오른쪽 자식, postorder의 오른쪽 자식의 인덱스 param으로 재귀
        preorder(inRoot+1,ie,ps+left,pe-1);
    }
}
