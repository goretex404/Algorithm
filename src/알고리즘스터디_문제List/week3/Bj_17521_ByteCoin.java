package 알고리즘스터디_문제List.week3;

import java.util.Scanner;

/**
 * 그리디
 * 비록 초기 현금 W는 그렇게 크지 않지만 최종 현금은 매우 커질 수 있음에 주의하자.
 * long size 필요
 */
public class Bj_17521_ByteCoin {
    static int n;
    static long W;
    static int[] coinValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        W = sc.nextInt();
        coinValue = new int[n];

        for (int i = 0; i < n; i++) {
            coinValue[i] = sc.nextInt();
        }

        long coin = 0;

        //마지막 날 바로 전 날까지 loop
        for (int i = 0; i < n-1; i++) {
            //오늘보다 내일 가치가 더 높으면
            if (coinValue[i] < coinValue[i + 1]) {
                //코인 매입
                coin += W / coinValue[i];
                //잔액(현금)
                W = W % coinValue[i];
            } else { // 낮거나 같으면
                //코인 전량 매도
                W += coin * coinValue[i];
                coin = 0;
            }
        }
        //마지막 날 모두 매도하여 현금화
        W += coin * coinValue[n-1];
        System.out.println(W);
    }
}
