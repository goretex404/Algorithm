package lvUp_test.math;

import java.util.Scanner;

//최대공약수와 최소공배수
public class bj2609 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int LCM = (a*b)/GCD(a,b);
        System.out.println(GCD(a,b));
        System.out.println(LCM);
    }
    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }else {
            return GCD(b, a%b);
        }
    }
}
