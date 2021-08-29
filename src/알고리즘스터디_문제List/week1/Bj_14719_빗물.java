package 알고리즘스터디_문제List.week1;

import java.util.Scanner;

public class Bj_14719_빗물 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int W = sc.nextInt();
        int[] arr = new int[W];
        int answer = 0; //모인 빗물
        for (int i = 0; i < W; i++) {
            arr[i] = sc.nextInt();
        }
        //끝과 끝에는 물이 채워지지 않는 것에 주의
        for (int i = 1; i < W-1; i++){
            int curr = arr[i]; // 현재 벽의 높이
            int leftMax = curr; // 왼쪽 벽 최대 높이
            int rightMax = curr; // 오른쪽 벽 최대높이
            for (int j = i-1; j >= 0; j--) { // 왼쪽 최대 높이의 벽 탐색
                if(arr[j] > curr){
                    leftMax = Math.max(leftMax, arr[j]);
                }
            }
            for (int j = i+1; j < W; j++){ // 오른쪽 최대 높이의 벽 탐색
                if(arr[j] > curr){
                    rightMax = Math.max(rightMax, arr[j]);
                }
            }
            if (Math.min(leftMax, rightMax) > curr) { // 현재 벽 높이보다 높은 벽이 양쪽에 있는 경우
                //leftMax와 rightMax중 작은 벽 높이와 현재 벽의 높이(arr[i])를 뺀 만큼 물이 채워진다.
                answer += (Math.min(leftMax,rightMax) - arr[i]);
            }
        }
        System.out.println(answer);
    }
}
