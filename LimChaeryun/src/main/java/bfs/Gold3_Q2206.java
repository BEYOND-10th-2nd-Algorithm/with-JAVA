package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold3_Q2206 {

    static int[][] map;
    static int[][][] checked;
    static boolean[][][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M;
    static boolean destroyed;
    static int count;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        checked = new int[N][M][2];
        destroyed = false;
        map = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i =0; i < N; i++){
            String line = br.readLine();

            for (int j = 0; j < M; j++){
                map[i][j] = line.charAt(j) - '0';
            }
        }

        count = 1;
        bfs(0, 0);


        System.out.println(checked[N-1][M-1][0]);
//        System.out.println(count);
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()){
            int[] start = queue.poll();
            int nowX = start[0];
            int nowY = start[1];

            if (!destroyed){
                visited[nowX][nowY][0] = true;
            } else {
                visited[nowX][nowY][1] = true;
            }
            for (int i =0; i < 4; i++){

                int newX = start[0] + dx[i];
                int newY = start[1] + dy[i];

                if (newX >= 0 && newX < N){
                    if (newY >= 0 && newY < M){

                        count++;

                        // 벽이 아닐때
                        if (map[newX][newY] == 0){
                            // 부순 벽이 없을때
                            if (!destroyed && !visited[newX][newY][0]){
                                queue.add(new int[]{newX, newY});
                                checked[newX][newY][0] = checked[nowX][nowY][0] + 1;
                                visited[newX][newY][0] = true;
                            }
                            // 부순 벽이 있을때
                            else if (destroyed && !visited[newX][newY][1]){
                                queue.add(new int[]{newX, newY});
                                checked[newX][newY][1] = checked[nowX][nowY][1] + 1;
                                visited[newX][newY][1] = true;
                            }

                            // 벽일때
                        } else if (map[newX][newY] == 1){

                            // 부순 벽이 없을 때 부수기
                            if (!destroyed){
                                queue.add(new int[]{newX, newY});
                                checked[newX][newY][1] = checked[nowX][nowY][0] + 1;
                                visited[newX][newY][1] = true;
                                destroyed = true;
                            }
                        }
                    }
                }

            }
        }

    }
}
