package recursion;

import java.util.Scanner;

public class Bj_10870_recursuion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int result = fibonacci(num);
		System.out.println(result);
	}
	
	public static int fibonacci(int num) {
		
		if(num == 0) return 0;
		if(num == 1) return 1;
		
		return fibonacci(num-1) + fibonacci(num-2);
	}
}
