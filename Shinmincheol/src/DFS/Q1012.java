package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1012 {

    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};  //상하좌우 표현
    static int m,n;

    public static void main(String[] args) throws IOException {

        // 조건 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수


        for (int c = 0; c < t; c++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 배추밭 가로길이
            n = Integer.parseInt(st.nextToken()); // 배추밭 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추 위치 개수

            map = new int[n][m];
            visited = new boolean[n][m];


            int cnt = 0; //필요한 배추흰지렁이의 개수
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x_pos = Integer.parseInt(st.nextToken());
                int y_pos = Integer.parseInt(st.nextToken());
                map[y_pos][x_pos] = 1;
            }


            // 어떻게 연결되었는지를 확인
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        DFS(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void DFS(int y, int x){

        visited[y][x] = true; //해당 위치를 방문처리한다.
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(!visited[ny][nx] && map[ny][nx] == 1){
                    DFS(ny,nx);
                }
            }
        }
    }
}

