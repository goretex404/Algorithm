package 알고리즘스터디_문제List.week3;


import java.io.*;
import java.util.Scanner;

/**
 * 가장 처음에 상근이는 트리의 루트에 있는 빌딩 앞에 서있다.
 * 현재 빌딩의 왼쪽 자식에 있는 빌딩에 아직 들어가지 않았다면, 왼쪽 자식으로 이동한다.
 * 현재 있는 노드가 왼쪽 자식을 가지고 있지 않거나 왼쪽 자식에 있는 빌딩을 이미 들어갔다면,
 * 현재 노드에 있는 빌딩을 들어가고 종이에 번호를 적는다.
 * 현재 빌딩을 이미 들어갔다 온 상태이고, 오른쪽 자식을 가지고 있는 경우에는 오른쪽 자식으로 이동한다.
 * 현재 빌딩과 왼쪽, 오른쪽 자식에 있는 빌딩을 모두 방문했다면, 부모 노드로 이동한다.
 * <p>
 * inorder로 BST를 입력받고 출력하는 문제
 * inorder left -> root -> right
 */
public class Bj_9934_완전이진트리 {

    static int level;
    static StringBuffer[] ans;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        level = Integer.parseInt(br.readLine());

        //2^level 만큼 노드 값을 담아 줄 배열 생성
        arr = new int[(int) Math.pow(2, level) - 1];

        //input을 " "로 구분하여 배열에 저장
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        ans = new StringBuffer[level];
        for (int i = 0; i < level; i++)
            ans[i] = new StringBuffer();

        bst(0, arr.length - 1, 0);

        //출력
        for (int i = 0; i < level; i++) {
            bw.write(ans[i].toString() + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void bst(int start, int end, int floor) {
        //base condition
        if (floor == level) return;

        //현재 위치 root 저장
        int mid = (start + end) / 2;
        ans[floor].append(arr[mid] + " ");

        //left 노드 순회
        bst(start, mid - 1, floor + 1);

        //right 노드 순회
        bst(mid + 1, end, floor + 1);
    }

}
