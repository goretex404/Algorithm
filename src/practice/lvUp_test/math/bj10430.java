package practice.lvUp_test.math;

import java.util.Scanner;
//나머지
public class bj10430 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        int solv1 = (A + B) % C;
        int solv2 = (A + B) % C; // ((A % C) + (B % C)) % C;
        int solv3 = (A * B) % C;
        int solv4 = (A * B) % C; // ((A % C) * (B % C)) % C;
        System.out.println(solv1);
        System.out.println(solv2);
        System.out.println(solv3);
        System.out.println(solv4);
    }
}
