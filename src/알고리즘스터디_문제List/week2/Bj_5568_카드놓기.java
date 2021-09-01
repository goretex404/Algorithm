package 알고리즘스터디_문제List.week2;


import java.io.*;
import java.util.HashSet;

public class Bj_5568_카드놓기 {
    /**
     * 상근이는 카드 n(4 ≤ n ≤ 10)장을 바닥에 나란히 놓고 놀고있다. 각 카드에는 1이상 99이하의 정수가 적혀져 있다.
     * 상근이는 이 카드 중에서 k(2 ≤ k ≤ 4)장을 선택하고, 가로로 나란히 정수를 만들기로 했다. 상근이가 만들 수 있는 정수는 모두 몇 가지일까?
     * 예를 들어, 카드가 5장 있고, 카드에 쓰여 있는 수가 1, 2, 3, 13, 21라고 하자. 여기서 3장을 선택해서 정수를 만들려고 한다.
     * 2, 1, 13을 순서대로 나열하면 정수 2113을 만들 수 있다. 또, 21, 1, 3을 순서대로 나열하면 2113을 만들 수 있다.
     * 이렇게 한 정수를 만드는 조합이 여러 가지 일 수 있다.
     * n장의 카드에 적힌 숫자가 주어졌을 때, 그 중에서 k개를 선택해서 만들 수 있는 정수의 개수를 구하는 프로그램을 작성하시오.
     * <p>
     * 첫째 줄에 n이, 둘째 줄에 k가 주어진다. 셋째 줄부터 n개 줄에는 카드에 적혀있는 수가 주어진다.
     * <p>
     * 첫째 줄에 상근이가 만들 수 있는 정수의 개수를 출력한다.
     */

    public static int N, K;
    public static String card[];
    public static boolean visited[];
    //HashSet을 통해 중볶 값을 방지
    public static HashSet<String> hs = new HashSet<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        //카드 갯수
        N = Integer.parseInt(br.readLine());
        //선택되는 카드 갯수
        K = Integer.parseInt(br.readLine());

        //선택한 카드의 숫자를 문자열로 담는 배열
        card = new String[N];

        for (int i = 0; i < N; i++) {
            card[i] = br.readLine();
        }
        //한 루프 내에서 자기 자신 방문을 막기위한 배열
        visited = new boolean[N];
        selCard(K, "");

        sb.append(hs.size());

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();

    }

    public static void selCard(int n, String cardValue) {
        if (n == 0) {
            hs.add(cardValue);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                selCard(n - 1, cardValue + card[i]);
                visited[i] = false;
            }
        }
    }
}
