package practice;

import java.util.Scanner;

public class Bj_1629_곱셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a,b,c;
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();

        System.out.print(POW(a,b,c));
    }

    private static long POW(long a, long b, long c) {
        if(b==1) return a%c;
        long val = POW(a, b/2, c);
        val = val * val % c;
        if(b%2 == 0) return val;

        return val * a % c;

    }
}
