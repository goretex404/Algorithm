package goormedu;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class 문제3D_피보나치나머지 {
    public static final Scanner scanner = new Scanner(System.in);
    public static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static final int MAX_N = 100000000;
    public static int[] FIBONACCI_TABLE;

    /**
     * 피보나치 수열의 1~n번째 항을 배열에 저장하여 반환해주는 함수
     * 단, 항의 가장 뒤 8자리만을 저장한다. %100000000
     * @param n
     * @return fibo[i] = 피보나치 수열의 i번째 항
     */
    public static int[] makeFibonacciTable(int n){
        int[] fibo = new int[n+1];
        fibo[1] = 0;
        fibo[2] = 1;
        for (int i = 3 ; i <= n ; i++) {
            fibo[i] = (fibo[i-1]+fibo[i-2] % 100000000);
        }
        return fibo;
    }

    /**
     * 피보나치 수열의 n번째 항을 반환하는 함수
     * 단, 항의 가장 뒤 8자리만을 반환
     * @param n
     * @return
     */
    public static int getFibo(int n){
        int answer = 0;

        answer = FIBONACCI_TABLE[n];

        return answer;
    }

    public static void main(String[] args) throws IOException {
        //가능한 모든 범위에 대한 피보나치 수열의 값을 계산해두자.
        FIBONACCI_TABLE = makeFibonacciTable(MAX_N);

        //TC를 반복 수행
        int caseSize = scanner.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            int n = scanner.nextInt();
            int answer = getFibo(n);
            writer.write(String.valueOf(answer) + "\n");
        }

        //불필요한 배열은 가능하면 할당 해제해주는 습관을 가지자
        FIBONACCI_TABLE = null;

        writer.flush();
        writer.close();
    }
}
