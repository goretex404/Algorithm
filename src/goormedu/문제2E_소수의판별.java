package goormedu;

import java.util.Scanner;

public class 문제2E_소수의판별 {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 주어진 숫자가 소수인지 판별하는 함수
     *
     * @param N
     * @return true   소수라면
     * @return false  소수가 아니라면
     */
    public static boolean isPrime(int N)
    {
        if(N==1){
            return false;
        }else if(N==2){
            return true;
        }else if(N%2 == 0){
            return false;
        }

        //루트N보다 작은 범위만 검사하면된다.
        for(int i = 3; i*i <= N; i+=2){
            //모든 N미만의 홀수 자연수 i에 대해 (짝수는 고려할 필요가 없으므로 i+=2)
            if(N % i == 0){
                //이 범위내에 약수가 존재한다면 소수 일 수 없다.
                return false;
            }
        }
        //약수가 하나도 없었다면 소수.
        return true;
    }

    public static void testCase(int caseIndex)
    {
        int n = scanner.nextInt();
        boolean result = isPrime(n);

        System.out.printf("Case #%d\n", caseIndex);
        if(result)
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
