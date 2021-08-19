package 알고리즘스터디_문제List;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * 문자열을 거꾸로 출력하는 문제는 대부분 Stack을 활용하면 된다.
 * 태그 내부에 있는 문자열은 그대로 출력 태그 밖에 있는 문자열만 뒤집어야한다.
 * 공백 주의
 */
public class Bj_17413_단어뒤집기 {
    //스택에 들어있는 문자를 모두 출력시키는 함수
    private static void printStack(BufferedWriter bw, Stack<Character> stack) throws IOException {
        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        //태그 내부인지 확인을 위한 flag
        boolean tag = false;

        //문자열 역순으로 바꿔줄 Stack 생성
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            //'<'일 경우
            if (s.charAt(i) == '<') {
                tag = true;
                //스택 비우기
                printStack(bw, stack);
                //'<' 출력
                bw.write(s.charAt(i));
            } else if (s.charAt(i) == '>') { //'>'일 경우
                tag = false;
                bw.write(s.charAt(i));
            } else if (tag) { //태그 내부일 경우 바로 출력
                bw.write(s.charAt(i));
            } else { // 태그 바깥의 경우
                if(s.charAt(i)==' '){ // 공백
                    printStack(bw,stack);
                    bw.write(s.charAt(i));
                } else {
                    stack.push(s.charAt(i));
                }

            }

        }
        //마지막으로 stack에 push된 단어 전부 출력
        printStack(bw,stack);

        //flush
        bw.flush();
        bw.close();
        br.close();
    }
}
