package 알고리즘스터디_문제List.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 불과 지훈이용 큐 두개를 가지고 BFS를 두번 돌리는게 핵심
 * 불을 먼저 보내고 그 후 지훈이가 갈 수 있는 경로를 탐색해야함에 주의. 순서 중요
 */
public class Bj_4179_불2 {
    static int R,C; //미로 R 행, C 열
    static char[][] map;
    static boolean[][] visited;
    static Queue<Node4179> jihun = new LinkedList<>();
    static Queue<Node4179> fire = new LinkedList<>();
    static int min = -1;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
                if(temp[j] == 'J'){
                    visited[i][j] = true;
                    map[i][j] = '.';
                    jihun.add(new Node4179(i,j));
                }else if(temp[j] == 'F'){
                    visited[i][j] = true;
                    fire.add(new Node4179(i,j));
                }
            }
        }
        int cnt = 0;
        loop :while (!jihun.isEmpty()){
            //fire
            int fs = fire.size();

            for (int s = 0; s < fs; s++) {
                Node4179 cur = fire.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    //map 밖이 거나 이동 할 수 있는 곳(.)이 아니라면 continue
                    if(!isRange(nx,ny) || map[nx][ny] != '.') continue;
                    //이동 가능 한 곳이라면 불 확산.
                    map[nx][ny] = 'F';
                    fire.add(new Node4179(nx, ny));
                }
            }
            //jihun
            int js = jihun.size();

            for (int s = 0; s < js; s++){
                Node4179 cur = jihun.poll();

                for(int i = 0; i < 4; i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if(!isRange(nx,ny)) {
                        min = ++cnt;
                        break loop;
                    }

                    if(visited[nx][ny] || map[nx][ny] != '.') continue ;
                    visited[nx][ny] = true;
                    jihun.add(new Node4179(nx,ny));
                }
            }
            cnt++;
        }
        System.out.println(min == -1 ? "IMPOSSIBLE" : min);
    }

    static boolean isRange(int x, int y) {
        if( x < 0 || x >= R || y < 0 || y >= C) return false;
        return true;
    }
}

class Node4179 {
    int x;
    int y;

    public Node4179(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
