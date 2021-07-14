package lvUp_test.math;

import java.util.Scanner;

//GCD합
public class bj9613 {
    public static int tc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tc = scanner.nextInt();
        while (tc-- > 0) {
            int n = scanner.nextInt();
            int[] GCD_arr = new int[n];
            for (int i = 0; i < n; i++) {
                GCD_arr[i] = scanner.nextInt();
            }
            long ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    ans += GCDfunc(GCD_arr[i], GCD_arr[j]);
                }
            }
            System.out.println(ans);
        }

    }

    public static int GCDfunc(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return GCDfunc(b, a % b);
        }
    }
}
