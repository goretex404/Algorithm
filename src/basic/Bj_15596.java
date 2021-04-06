package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj_15596 {
	//제출 시 class name = Test 로 수정
	public static long sum(int[] a) {
		int result = 0;
		for(int i=0; i<a.length; i++) {
			result += a[i];			
		}
		return result;
	}
}
