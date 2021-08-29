package 알고리즘스터디_문제List.week1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_20207_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //일정의 갯수
        int N = Integer.valueOf(st.nextToken());

        //높이 값만 저장하는 배열
        int arr[] = new int[367];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            //시작 일자
            int start = Integer.valueOf(st.nextToken());
            //마지막 일자
            int end = Integer.valueOf(st.nextToken());

            for (int day = start; day <= end; day++) {
                //N번 반복하며 날짜 별 arr 높이 증가
                arr[day]++;
            }
        }

        int y = 0;
        int x = 0;
        int result = 0;

        for (int i = 1; i < 367; i++) {
            //일정이 있는 날 = arr[i] > 0
            if (arr[i] > 0) {
                x++; // 가로 길이 증가(연속된 일정)
                y = Math.max(y, arr[i]); // 저장되어있는 높이와 배열에 저장된 높이를 비교하여 큰 값 저장
            } else if (arr[i] == 0) { // 일정이 없는 부분에서 arr[i] <= 0 넓이 계산
                result += (x * y); // 코팅지 넓이 계산 후 합산
                // 다음 계산을 위해 초기화
                x = 0;
                y = 0;
            }
        }
        System.out.println(result);
    }
}
