package goormedu;

import java.util.Scanner;

//sliding window method.
public class 문제2J_승부조작 {
    public static Scanner scanner = new Scanner(System.in);

    public static boolean isWinnable(int[] data, int n, int k) {

        int winCount = 0;
        long sum = 0;

        for(int i = 0 ; i+k-1<n; i++){
            for(int j = i; j<i+k-1; j++){
                sum += data[j];
            }
            if(sum%2 == 0){
                winCount++;
                break;
            }
        }
        if(winCount > 0)
        {
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        boolean result = isWinnable(data, n, k);

        if(result)
        {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
