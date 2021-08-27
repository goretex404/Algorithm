package 알고리즘스터디_문제List;

import java.util.LinkedList;
import java.util.Queue;

public class prgms_2021kakao_거리두기확인하기 {
    class Point {
        public Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
        int row, col, dist;
    }
    int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};

    boolean bfs(String[] place, int row, int col){
        boolean[][] visited = new boolean[5][5];

        Queue<Point> q = new LinkedList<>();
        visited[row][col] = true;
        q.add(new Point(row,col,0));

        while(!q.isEmpty()){
            Point curr = q.remove();

            if(curr.dist > 2) continue;
            //거리두기 실패
            if(curr.dist != 0 && place[curr.row].charAt(curr.col) == 'P'){
                return false;
            }

            for(int i = 0; i<4; i++){
                int nr = curr.row + D[i][0];
                int nc = curr.col + D[i][1];
                if(nr < 0 || nr > 4 || nc < 0 || nc > 4) continue;
                if(visited[nr][nc]) continue;
                if(place[nr].charAt(nc) == 'X') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr,nc,curr.dist+1));
            }
        }
        return true;
    }
    boolean check(String[] place){
        for(int r = 0 ; r < 5; r++){
            for(int c = 0 ; c< 5; c++){
                if(place[r].charAt(c) == 'P'){
                    if (!bfs(place, r, c)) return false;
                }
            }
        }
        return true;
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0; i<5; i++){
            if(check(places[i]))
                answer[i] = 1;
            else
                answer[i] = 0;
        }
        return answer;
    }
}
