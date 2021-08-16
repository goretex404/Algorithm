package basic;

import java.util.Scanner;

public class 문제1H_탐색하기3 {
    public static final Scanner scanner = new Scanner(System.in);

    public static int findIndex(int[] data, int n) {
        int answer = 0; // 값은 무조건 발생하기때문에 0번 인덱스로 초기화.
        int sum = 0; //데이터의 합.
        for (int i = 0; i < n; i++) {
            sum += data[i];
        }

        //sum을 n으로 나눠서 avg로 계산 시 부동소수점 오차가 발생 할 수 있다.
        //dx, di를 구하는 부분 처럼 부동소수점이 발생하지 않는 형태의 식으로 변경해 사용하는 습관!
        //결과적으로는 동일한 값을 얻어낼 수 있다.
        for (int i = 0; i < n; i++) {
            int dx = Math.abs(n * data[answer] - sum);
            int di = Math.abs(n * data[i] - sum);
            if (di < dx) {
                answer = i;
            }
        }
        return answer + 1;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        int answer = findIndex(data, n);
        int index = answer - 1;

        System.out.printf("%d %d\n", answer, data[index]);
    }
}
