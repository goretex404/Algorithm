package goormedu;

import java.util.Scanner;

public class 문제1J_합구하기3 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 1부터 N까지의 자연수의 합을 계산하는 함수
     * @param i
     * @return
     * (1이상 1이하의 모든 자연수의 합) + (1이상 2이하의 모든 자연수의 합) + ... +(1이상 N이하의 모든 자연수의 합)
     * 메소드로 분리된 2중for문 이다..?
     */
    public static int getRangeSumFromOne(int i) {
        int loop_sum = 0;

        for(int j=1; j<=i; j++){
            loop_sum += j;
        }
        return loop_sum;

    }

    public static long getAnswer(int N)
    {
        int total_sum = 0;
        for(int i=1; i<=N; i++){
            total_sum += getRangeSumFromOne(i);
        }
        return total_sum;
    }


    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();

        long answer = getAnswer(n);

        System.out.println(answer);
    }
}
