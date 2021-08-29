package 알고리즘스터디_문제List.week1;

import java.io.*;
import java.util.ArrayList;

public class Bj_16637_괄호추가하기 {
    static int ans;
    static ArrayList<Character> operators;
    static ArrayList<Integer> nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수식의 길이
        int N = Integer.parseInt(br.readLine());
        //수식
        String input = br.readLine();

        operators = new ArrayList<>();
        nums = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                operators.add(c);
                continue;
            }

            //getNumericValue() = char형을 숫자형태 그대로 반환
            nums.add(Character.getNumericValue(c));
        }

        ans = Integer.MIN_VALUE;
        dfs(nums.get(0), 0);

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int result, int opIdx) {
        //주어진 연산자의 갯수를 초과했을 경우.
        if(opIdx >= operators.size()){
            ans = Math.max(ans, result);
            return;
        }

        //괄호가 없는 경우
        int res1 = calc(operators.get(opIdx), result, nums.get(opIdx + 1));
        dfs(res1, opIdx + 1);
        //괄호가 있는 경우 *
        if(opIdx + 1 < operators.size()){
            //result의 오른쪽에 있는 값을 연산함
            int res2 = calc(operators.get(opIdx+1), nums.get(opIdx + 1), nums.get(opIdx + 2));

            //현재 result와 방금 구한 괄호 값을 연산한 결과와 괄호 오른쪽에 존재하는 연산자의 인덱스를 넘김.
            dfs(calc(operators.get(opIdx),result,res2),opIdx+2);
        }
    }

    //연산
    public static int calc(char operators, int a, int b){
        switch (operators){
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
        }
        return -1;
    }
}
