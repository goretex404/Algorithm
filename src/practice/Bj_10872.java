package practice;

import java.util.Scanner;


/**
 * 재귀함수 / 팩토리얼
 * 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
 *
 */
public class Bj_10872 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		int tot = factorial(n);
		System.out.println(tot);

	}
	public static int factorial(int n) {
		if(n<=1) return 1; 			//0! , 1! == 1
		return n*factorial(n-1); 
	}

}
