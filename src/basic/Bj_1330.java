package basic;

import java.util.Scanner;

public class Bj_1330 {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int a,b;
		a = sc.nextInt();
		b = sc.nextInt();
		
		if(a>b)
			System.out.println(">");
		else if (a == b)
			System.out.println("==");
		else
			System.out.println();
		
	}

}
