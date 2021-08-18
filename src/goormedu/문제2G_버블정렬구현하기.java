package goormedu;

import java.util.Scanner;

public class 문제2G_버블정렬구현하기 {
    public static final Scanner scanner = new Scanner(System.in);

    public static void bubbleSort(int[] data, int n)
    {
        int temp = 0;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 1; j<n-i; j++){
                if(data[j-1]>data[j]){
                    temp = data[j];
                    data[j] = data[j-1];
                    data[j-1] = temp;
                }
            }

        }
    }

    public static void main(String[] args) throws Exception {
        int n = scanner.nextInt();
        int[] data = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            data[i] = scanner.nextInt();
        }

        bubbleSort(data, n);

        for(int i = 0 ; i < n ; i++)
        {
            if( i > 0 )
            {
                System.out.print(" ");
            }
            System.out.print(data[i]);
        }
    }
}
