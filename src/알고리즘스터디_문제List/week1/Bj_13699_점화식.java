package 알고리즘스터디_문제List.week1;

import java.io.*;


public class Bj_13699_점화식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        //0 <= n <= 35 int 자료형 넘어감
        long dp[] = new long[36];
        dp[0] = 1;
        dp[1] = 1;

        //t(n)=t(0)*t(n-1)+t(1)*t(n-2)+...+t(n-1)*t(0)
        for (int i = 2; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }
        sb.append(dp[N]);
        sb.append("\n");
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }



}
