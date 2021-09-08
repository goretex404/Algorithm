package 알고리즘스터디_문제List.week3;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Bj_2143_두배열의합 {
    static int T, N, M;
    static int[] A, B;
    static int ap, bp; // a, b 포인터
    static long ans;

    static ArrayList<Integer> sumA, sumB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        //A배열 부분 합
        sumA = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int tmp = A[i];
            sumA.add(tmp);
            for (int j = i + 1; j < N; j++) {
                tmp += A[j];
                sumA.add(tmp);
            }
        }

        //B배열 부분 합
        sumB = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            int tmp = B[i];
            sumB.add(tmp);
            for (int j = i + 1; j < M; j++) {
                tmp += B[j];
                sumB.add(tmp);

            }
        }
        //투포인터 사용을 위해 만든 부분 합을 오름차순 정렬
        sumA.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        sumB.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        //투포인터
        int sumASize = sumA.size();
        int sumBSize = sumB.size();
        ap = 0;
        bp = sumBSize - 1;
        ans = 0;

        while (ap < sumASize && bp >= 0){
            int aTmp = sumA.get(ap);
            int bTmp = sumB.get(bp);
            int aCnt = 0;
            int bCnt = 0;
            //A부분합 + B부분합 = T이면
            if (aTmp + bTmp == T) {
                //일치하는 값의 부분배열을 찾으면 a포인터 증가 & 카운트
                while (ap < sumASize && sumA.get(ap) == aTmp) {
                    ap++;
                    aCnt++;
                }//일치하는 값의 부분배열을 찾으면 b포인터 감소 & 카운트
                while (bp >= 0 && sumB.get(bp) == bTmp) {
                    bp--;
                    bCnt++;
                }
                ans += (long) aCnt*(long) bCnt;
            } else if (aTmp + bTmp > T){
                bp--;
            } else { // aTmp + bTmp < T
                ap++;
            }
        }
        bw.write(String.valueOf(ans));

        bw.flush();
        br.close();
        bw.close();
    }
}
