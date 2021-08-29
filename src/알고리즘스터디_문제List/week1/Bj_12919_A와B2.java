package 알고리즘스터디_문제List.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_12919_A와B2 {
    /**
     * 문자열을 바꿀 때는 다음과 같은 두 가지 연산만 가능하다.
     * 1)문자열의 뒤에 A를 추가한다.
     * 2)문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
     * 위 두 가지 규칙으로 인해 A------B는 성립이 불가
     * 문제에서는 첫번째 문자열(s)을 두번째 문자열(t)로 바꾸라고 되어있지만
     * t는 이미 완성되어있다고 볼 수 있기 때문에 t -> s 가 성립하는지 확인하는게
     * 더 간단하다.
     * 첫째 줄에 S가 둘째 줄에 T가 주어진다.
     * (1 ≤ S의 길이 ≤ 49, 2 ≤ T의 길이 ≤ 50, S의 길이 < T의 길이)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine(); // 1 ≤ S ≤ 49
        String t = br.readLine(); // 2 ≤ T ≤ 50

        System.out.println(solution(s, t));
    }
    /**
     * @param s 첫번째 문자열
     * @param t 두번째 문자열
     * @return
     */
    private static int solution(String s, String t) {
        // s와 t 비교
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }

        int ans = 0;
        //마지막 문자가 'A'일 때
        if (t.charAt(t.length() - 1) == 'A') {
            //마지막 문자 삭제시키며 재귀
            ans += solution(s, t.substring(0, t.length() - 1));
        }

        //맨 앞 글자가 'B'일 때
        if (t.charAt(0) == 'B') {
            String str = new StringBuffer(t.substring(1, t.length())).reverse().toString();
            ans += solution(s, str);
        }
        return ans > 0 ? 1 : 0;
    }
}
