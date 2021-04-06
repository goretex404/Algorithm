package coteEx;

import java.util.Stack;

/**
 * 학술정보관 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 
 */
public class prgrms_64061 {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		Solution st = new Solution();
		System.out.println(st.solution(board, moves));
	}
}

class Solution {
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> s = new Stack<Integer>();

		// for(int move : moves)
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {
				/*
				 * 해당 칸에 인형이 존재하는경우 아래로 내려가며 탐색해야하므로 행의 값(j)이 증가하며 찾는다. ([0],[0]), ([1],[0]),
				 * ([2],[0]) ... moves배열에 있는 요소를 board[][moves[i-1]] 배열의 '열' 값에 넣어서 비교 배열의
				 * 인덱스는0부터 시작하므로 -1
				 */
				if (board[j][moves[i] - 1] != 0) {
					// 스택이 비어있는 경우 (처음 or 다 터졌을 때) 뽑은 인형 넣기
					if (s.isEmpty()) {
						s.push(board[j][moves[i] - 1]);
					} // 스택이 비어있지 않은 경우 
					else {
						// 스택 상단의 인형과 뽑아 넣는 인형(board[j][moves[i-1]])이 같은지 비교
						if (s.peek() == board[j][moves[i] - 1]) {
							/*
							 * 두 인형이 같다면 터지기 때문에 사라진 인형은 2개가 증가하고 stack 값은 사라져야 하므로 pop & answer + 2가 된다.
							 */
							s.pop();
							answer += 2;
						} else {
							// 스택 상단의 인형과 뽑아 넣은 인형이 같지 않을 경우 stack에 push.
							s.push(board[j][moves[i] - 1]);
						}
					}
					board[j][moves[i] - 1] = 0;
					break;
				}
			}
		}
		return answer;
	}
}
