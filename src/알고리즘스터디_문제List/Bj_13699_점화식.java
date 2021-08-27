package 알고리즘스터디_문제List;

import java.io.*;


public class Bj_13699_점화식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(br.readLine());
        long dp[] = new long[36];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < 36; i++) {
            for (int j = 0; j < i; j++) {
                // i-1-j인  이유 ?
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
