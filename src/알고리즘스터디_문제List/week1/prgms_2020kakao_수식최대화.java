package 알고리즘스터디_문제List.week1;

import java.util.HashSet;
import java.util.LinkedList;

public class prgms_2020kakao_수식최대화 {

    static long maxAnswer;
    static LinkedList<Long> numList;
    static LinkedList<Character> opList, opSetList;
    static HashSet<Character> opSet;

    public static void main(String[] args) {

    }

    public static long solution(String expression){
        //가장 큰 연산의 결과를 담을 변수
        maxAnswer = Long.MIN_VALUE;
        //수식에서 피연산자만 순서대로 담은 리스트
        numList = new LinkedList<Long>();
        //수식에서 연산자만 순서대로 담은 리스트
        opList = new LinkedList<Character>();
        //수식에서 나온 연산자의 종류만 담은 리스트
        opSetList = new LinkedList<Character>();
        //수식에서 나온 연산자 집합
        opSet = new HashSet<Character>();

        //수식에서 연산자와 피연산자 구분
        splitExp(expression);
        return 0;
    }
    public static void splitExp(String exp){
        //String을 char형 배열로 변환
        char[] arr = exp.toCharArray();
        StringBuilder numberStr = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            //연산자일 경우
            if(arr[i] == '*' || arr[i] == '+' || arr[i] == '-'){
                //피연산자 문자열을 숫자로 변환
                long number = Long.valueOf(numberStr.toString());

                //피연산자 리스트에 넣음
                numList.add(number);
                //연산자 순서 리스트에 넣음
                opList.add(arr[i]);
                //수식에 나온 연산자 종류를 파악하기 위해 집합에 넣음
                opSet.add(arr[i]);
                //연산자 이후 나오는 새로운 피연산자 파악하기 위해 초기화
                numberStr = new StringBuilder();
            }else {
                numberStr.append(arr[i]);
            }

            numList.add(Long.valueOf(numberStr.toString()));

            //연산자 종류 리스트로 생성
            opSetList = new LinkedList<>(opSet);

        }
    }
}
