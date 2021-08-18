package goormedu;

import java.util.Scanner;

public class 문제2H_픽셀수세기_review {
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * 왼쪽 아래 좌표가 (x,y)인 픽셀이 반지름 R인 원에 포함되는가?
     * @param x
     * @param y
     * @param R
     * @return  포함된다면 true, else false
     */
    public static boolean isInside(long x, long y, long R)
    {
        long sqd = x*x + y*y; //거리의 제곱
        if(sqd < R*R) // 반지름의 제곱
        {
            return true;
        }
        return false;

    }

    public static void testCase(int caseIndex) {
        long R = scanner.nextLong();

        long sum = 0; //칸의 수가 정수형 범위를 넘어간다.
        long y = R;

        for(long x = 0; x<=R; x++){
            long height = 0;
            for(;y>=0; y--){
                if(isInside(x,y,R)){ // true면
                    //위에서 부터 내려오다가
                    //가장 최초로 원 안에 포함된 픽셀(x,y)
                    //이 그룹의 높이는 (y+1)이 된다.
                    height = (y+1);
                    break;
                }
            }
            sum += height;
        }

        System.out.printf("#%d\n", caseIndex);
        System.out.printf("%d\n", sum*4); // 모든 사분면의 픽셀수
    }

    public static void main(String[] args) throws Exception {
        int caseSize = scanner.nextInt();

        for (int caseIndex = 1; caseIndex <= caseSize; caseIndex += 1) {
            testCase(caseIndex);
        }
    }
}
