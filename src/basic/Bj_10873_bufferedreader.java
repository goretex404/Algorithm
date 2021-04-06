package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_10873_bufferedreader {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int tot = factorial(n);
		System.out.println(tot);

	}
	public static int factorial(int n) {
		if(n<=1) return 1;
		return n*factorial(n-1);
	}

}
