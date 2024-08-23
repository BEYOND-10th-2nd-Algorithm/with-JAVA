package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Silver1_Q2468 {

    static int[] count;
    static int[][] arr;
    static boolean[][] visited;
    static int max = 0;

    static int N;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        count = new int[101];

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }

        }

        count = new int[max+1];

        // i는 강수량
        for (int rain = 0; rain < count.length; rain++){
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++){
                for (int j = 0; j < N; j++){

                    if (!visited[i][j] && arr[i][j] > rain){
                        count[rain] += BFS(i, j, rain);
                    }
                }
            }


        }

        System.out.println(Arrays.stream(count).max().getAsInt());
    }

    static int BFS(int x, int y, int rain){

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++){
                int nextX = nowX + dX[i];
                int nextY = nowY + dY[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) continue;
                if (visited[nextX][nextY]) continue;

                if (arr[nextX][nextY] > rain){
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                }
            }

        }
        return 1;
    }
}
