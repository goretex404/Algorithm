package goormedu;

import java.util.Scanner;

public class 문제2A_도토리키재기 {
    public static final Scanner scanner = new Scanner(System.in);
    /**
     * 생일이 m월인 가장 큰 키의 도토리를 찾는 함수
     * @param height  각 도토리의 키
     * @param month   각 도토리의 출생 월
     * @param n   도토리의 수
     * @param m   찾고자 하는 달
     * @return    month[k] == m인 가장 큰 height[k]
     */

    // 내 풀이 정상 동작하지만 바로 return을 해주는 것 보다 변수를 설정해주는 게
    // 가독성 및 실수를 줄이기 더 좋아보인다.
    public static int getMaximumHeight(int[] height, int[] month, int n, int m)
    {
        //오름차순으로 정렬되어있으므로 역순 진행
        for(int i=n-1; i>=0; i--){
            //m월 도토리 찾으면 바로 return하고 종료
			if(month[i]==m){
				return height[i];
			}
		}
		return -1;
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] height = new int[n];
        int[] month = new int[n];

        for(int i = 0 ; i < n ; i ++)
        {
            height[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            month[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();

        int answer = getMaximumHeight(height, month, n, m);

        System.out.println(answer);
    }
}
