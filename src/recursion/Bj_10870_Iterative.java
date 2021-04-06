package recursion;

import java.util.Scanner;

public class Bj_10870_Iterative {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int result = fibonacci(num);
		System.out.println(result);
	}

	public static int fibonacci(int num) {
	int one=1,two=1,result=0;
		if (num == 1)
			return 0;
		if (num == 2)
			return 1;

		if (num >= 2) {
			for (int i = 2; i < num; i++) {
				result = one + two;
				one = two;
				two = result;
			}
		}
		return result;

	}
}
