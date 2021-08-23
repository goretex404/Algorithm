package goormedu;

import java.util.Scanner;

public class 문제3E_색종이 {
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        int tc = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= tc; caseIndex++){
            //각 테스트 케이스에 대하여
            int n = sc.nextInt();

            //색종이 정보를 입력 받는다.
            Paper[] papers = new Paper[n];
            for(int i = 0; i < n; i++){
                int leftX = sc.nextInt();
                int bottomY = sc.nextInt();
                papers[i]  = new Paper(leftX,bottomY);
            }

            //색종이들이 덮은 영역의 넓이를 계산한다.
            int answer = getCoveredArea(papers, n);

            System.out.println(answer);
        }

    }

    private static int getCoveredArea(Paper[] papers, int n) {
        int answer = 0; // 색종이들이 덮은 영역의 총 넓이
        //도화지의 모든 격자에 대해
        //board[r][c] := <r,c> 격자를 덮은 색종이의 범위
        int[][] board = new int[100][100];

        for(Paper p : papers){
            //모든 색종이 p에 대해
            for(int row = p.bottomRow; row <= p.topRow; row++){
                for(int col = p.leftColumn; col <= p.rightColumn; col ++){
                    //이 색종이가 덮은 모든 위치 <row, col>에 대해
                    //한번 씩 board[row][col]의 값을 1 증가시킨다.
                    board[row][col] += 1;
                }
            }
        }

        //도화지에 존재하는 모든 격자에 대하여
        for(int row = 0; row<100; row++){
            for(int col = 0; col < 100; col++){
                if(board[row][col] > 0){
                    //한개 이상의 색종이가 덮은 격자의 수를 계산한다.
                    answer += 1;
                }
            }
        }

        //각 격자의 넓이는 1이므로, 격자의 수가 곧 넓이.
        return answer;
    }
}

class Paper{
    int leftColumn; // 가장 왼쪽 격자의 열 번호
    int rightColumn; // 가장 오른쪽 격자의 열 번호
    int topRow; // 가장 위쪽 격자의 행 번호
    int bottomRow; // 가장 아래쪽 격자의 행 번호
    Paper(int xPos, int yPos){
        //가로 세로 크기가 각각 10인 정사각형 모양의 색종이
        this.leftColumn = xPos;
        this.rightColumn = this.leftColumn + 9;
        this.bottomRow = yPos;
        this.topRow = this.bottomRow + 9;
    }
}


