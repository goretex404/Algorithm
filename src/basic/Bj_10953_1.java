package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_10953_1 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			String str = br.readLine();
			
			int a = str.charAt(0) - 48;
			int b = str.charAt(0) - '0';
			
			if(b==0) {
				break;
			}
			sb.append((b)).append('\n');
		}
		System.out.println(sb);
	}
}
