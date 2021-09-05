package 알고리즘스터디_문제List.week2;

import java.util.Stack;

public class prgms_2020kakao_괄호변환 {

    static int pos;
    static boolean isCorrect(String str){
        boolean ans = true;
        int left = 0, right = 0;
        Stack<Character> stack = new Stack<Character>();

        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                left++;
                stack.push('(');
            } else { // ')' 의 경우
                right++;
                //스택이 비어있다면 짝이 안맞는 경우이다.
                if(stack.empty()) ans = false;
                else stack.pop();
            }
            //left == right 일 때
            if(left == right){
                //현재 위치 저장
                pos = i + 1;
                return ans;
            }
        }
        return true;
    }
    static String solution(String p) {
        /*step 1*/
        if(p.isEmpty()) return p;

        /*step 2*/
        boolean correct = isCorrect(p);
        //isCorrect에서 저장한 pos까지가 올바른 문자열
        String u = p.substring(0, pos);
        String v = p.substring(pos, p.length());

        /*step 3*/
        if(correct) {
            //step 3-1
            return u + solution(v);
        }
        /*step4*/
        //4-1 ~ 4-3
        String answer = "(" + solution(v) + ")";
        //4-4
        for(int i = 1; i<u.length()-1; i++){
            if(u.charAt(i) == '(')
                answer += ")";
            else
                answer += "(";
        }
        //4-5
        return answer;
    }

    public static void main(String[] args) {
        String str = "()))((()";
        System.out.print(solution(str));
    }
}
