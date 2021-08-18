package goormedu;

import java.util.Scanner;

public class 문제2I_정주행 {
    public static final Scanner scanner = new Scanner(System.in);

    public static boolean isConsecutive(int[] data, int n){
        //에피소드 넘버 1~1000000
        int min = 1000001;
        int max = 0;

        for(int i =0; i<n; i++){
            if(data[i]<min){
                min = data[i];
            }
            if(data[i]>max){
                max = data[i];
            }
        }

        if(max == min+n-1){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        boolean result = isConsecutive(data, n);

        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
