package 알고리즘스터디_문제List;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_20207_달력 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());

        //높이 값만 저장하는 배열
        int arr[] = new int[367];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.valueOf(st.nextToken());
            int end = Integer.valueOf(st.nextToken());

            for (int day = start; day <= end; day++) {
                arr[day]++;
            }
        }
        int row = 0, col = 0, result = 0;

        for (int i = 1; i < 367; i++) {
            //일정이 있는 날 이라면 = arr[i] > 0
            if (arr[i] > 0) {
                col++; // 가로 길이 증가(연속된 일정)
                row = Math.max(row, arr[i]); // 현재 저장되어있는 높이 (겹친 일정)와 배열에 저장된 높이를 비교하여 큰 값 저장
                System.out.printf("day = %d, col = %d , row = %d \n",i,col,row);
            }else if(arr[i] == 0){ // 일정이 없는 부분에서 (0인 부분에서) 넓이 계산
                result += (col*row); // 코팅 지 넓이 계산 후 합산
                // 다음 코팅지 계산을 위해 초기화
                col = 0;
                row = 0;
            }

        }
        System.out.println(result);
    }
}
