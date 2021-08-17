package practice;

import java.io.*;
import java.util.StringTokenizer;

/*
 * 백준 10819 차이를 최대로
 * 아직 이해못함 // 완전탐색 기본 문제다 포기하지말자. 
 */
public class BOJ_10819 {

	static int N;
	static int max;
	static int[] nums;
	static boolean[] visited;
	
	static int getMax(int[] arr) {
		int sum = 0;
		for(int i = 0 ; i < N - 1 ;i++) {
			sum += Math.abs(arr[i] - arr[i+1]);
		}
		return sum;
	}
	
	static void func(int depth, int[] selected) {
		if(depth == N) {
			if(max < getMax(selected))
				max = getMax(selected);
			return;
		}
		
		for(int i = 0 ; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
				selected[depth] = nums[i];
				func(depth + 1, selected);
				visited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		nums = new int[N];
		visited = new boolean[N];
		int[] selected = new int[N];
		max = 0;
		
		for(int i = 0 ; i < N ; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, selected);
		
		System.out.println(max);
	}
}
