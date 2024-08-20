package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 적록색약 */
public class Q10026 {

    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0}; //상하좌우
    static int n;
    static char[][] map;
    static boolean[][] visited;
    static int cntA; // 일반인
    static int cntB; // 적록색약
    static char before;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        // 맵 설정
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    DFS_A(i,j,map[i][j]);
                    cntA++;
                }
            }
        }



        visited = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j]){
                    DFS_B(i,j,map[i][j]);
                    cntB++;
//                    if(before == 'B' || map[i][j] == 'B') cntB++; // 이전에 if문에 의해 한번 걸러진 상태
//                    before = map[i][j];
                }
            }
        }


        System.out.println(cntA + " " + cntB);

    }

    public static void DFS_A(int y, int x, char check){

        visited[y][x] = true; // 방문 표시
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(nx>=0 && ny>=0 && nx < n && ny < n){
                if(!visited[ny][nx] && map[ny][nx] == check){
                    DFS_A(ny,nx,map[ny][nx]);
                }
            }
        }
    }


    public static void DFS_B(int y, int x, char check){

        visited[y][x] = true; // 방문 표시
        for(int k = 0; k < 4; k++){
            int nx = x + dx[k];
            int ny = y + dy[k];
            //check가 blue일 경우
            if(check == 'B'){
                if(nx>=0 && ny>=0 && nx < n && ny < n){
                    if(!visited[ny][nx] && map[ny][nx] == check){
                        DFS_A(ny,nx,map[ny][nx]);
                    }
                }
            }else{
                if(nx>=0 && ny>=0 && nx < n && ny < n){
                    if(!visited[ny][nx]){
                        DFS_B(ny,nx,map[ny][nx]);
                    }
                }
            }


        }
    }



}
