package 알고리즘스터디_문제List.week2;


import java.io.*;
import java.util.StringTokenizer;

/**
 * two pointer
 */
public class Bj_14921_용액합성하기 {
    static int N; //2<=N<=100,000
    static int[] liq;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        liq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N - 1;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        while (left < right){
            sum = Math.abs(liq[left] + liq[right]);
            if(sum < min || sum == 0) {
                min = sum;
                ans = liq[left]+liq[right];
            }
            if(liq[left]+liq[right] < 0) {
                left++;
            }else {
                right--;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
        br.close();
        bw.close();

    }
}
