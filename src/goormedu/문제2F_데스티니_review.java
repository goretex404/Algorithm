package goormedu;

import java.util.Scanner;

public class 문제2F_데스티니_review {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int n = scanner.nextInt();
        Point2D[] points = new Point2D[n];

        for(int i = 0 ; i < n ; i++)
        {
            int x=  scanner.nextInt();
            int y=  scanner.nextInt();
            points[i] = new Point2D(x, y);
        }

        int min_sqd = Integer.MAX_VALUE;
        int min_cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                //i<j 인 모든 두 점쌍 <points[i], point[j]>에 대하여
                int sqd = points[i].getSquaredDistanceTo(points[j]);
                if(sqd < min_sqd){
                    //현재까지 찾은 거리들 중 가장 작자면, 최소 거리를 갱신한다
                    min_sqd = sqd;
                } else if (sqd == min_sqd){
                    //최소 거리와 같은 거리를 가지는 쌍을 찾는다면
                    //해당 거리의 빈도수를 증가시킨다.
                    min_cnt++;
                }
            }
        }

        double distance = Math.sqrt(min_sqd);
        System.out.printf("%.1f\n", distance);
        System.out.println(min_cnt);


    }
}

class Point2D{
    int x;
    int y;
    public Point2D(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * 2차원 평면 상에서 점 this부터 점 target까지 거리의 제곱을 계산하는 함수
     * @param target
     * @return
     */
    public int getSquaredDistanceTo(Point2D target)
    {
        int dx = Math.abs(target.x - this.x);
        int dy = Math.abs(target.y - this.y);
        return dx * dx + dy * dy;
    }

    public double getDistanceTo(Point2D target)
    {
        double sqd = (double) this.getSquaredDistanceTo(target);
        return Math.sqrt(sqd);
    }

}
