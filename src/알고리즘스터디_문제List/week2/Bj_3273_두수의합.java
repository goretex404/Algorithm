package 알고리즘스터디_문제List.week2;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_3273_두수의합 {
    public static int N, X;
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            //수열의 크기
            N = Integer.valueOf(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            arr = new int[N];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //투포인터 사용을 위해 오름차순 정렬
            Arrays.sort(arr);

            X = Integer.valueOf(br.readLine());
            int cnt = 0;
            int left = 0;
            int right = N - 1;
            int sum = 0;

            while (left < right) {
                sum = arr[left] + arr[right];
                if (sum == X) {
                    cnt++;
                }
                if (sum <= X) {
                    left++;
                } else {
                    right--;
                }
            }

            bw.write(cnt+"\n");
            bw.flush();
            br.close();
            bw.close();
        }
    }
}
