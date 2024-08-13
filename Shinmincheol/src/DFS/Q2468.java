package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 안전 영역 */
public class Q2468 {

    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static int maxCnt;
    static int n;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0}; //상하좌우 표현

    public static void main(String[] args) throws IOException {

        // 안전 영역의 "최대" 개수 구하기
        // 높이는 1 이상 100이하의 정수이다.
        // 100이상의 물이 내린다면 다 잠겨서 안전 영역의 개수가 0이 된다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        visited = new boolean[n][n];
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int h = 0; h <= 100; h++) {

            cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] > h && !visited[i][j]) {
                        DFS(i, j, h);
                        cnt++;
                    }
                }
            }

            maxCnt = Math.max(cnt, maxCnt);
            visited = new boolean[n][n]; // 방문 배열 역시 초기화시켜줘야함.

        }



        System.out.println(maxCnt);

    }

    public static void DFS(int x, int y, int h){

        visited[x][y] = true; // 탐색 지점을 방문처리한다.
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >=0 && nx < n && ny <n){
                if(!visited[nx][ny] && map[nx][ny] > h){
                    DFS(nx, ny, h);
                }
            }
        }
    }
}
