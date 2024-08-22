package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 단지 번호 붙이기
public class Silver1_Q2667 {

    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static boolean[][] visited;
    static List<Integer> apt;
    static int count;
    static int[][] map;

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        apt = new ArrayList<>();
        map = new int[N][N];

        for (int i = 0; i < N; i++){
            String line = br.readLine();
            char[] charArray = line.toCharArray();

            for (int j = 0; j < N; j++){
                map[i][j] = Character.getNumericValue(charArray[j]);
            }

        }

        for (int i =0; i < N; i++){

            for (int j = 0; j < N; j++){

                if (!visited[i][j] && map[i][j] == 1){
                    int width = BFS(i, j);
                    apt.add(width);
                    count++;
                }
            }
        }

        Collections.sort(apt);

        System.out.println(count);
        for (int size : apt) System.out.println(size);
    }

    static int BFS(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        int areaSize = 1;
        que.offer(new int[]{x, y});

        while (!que.isEmpty()){
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++){
                int newX = nowX + dX[i];
                int newY = nowY + dY[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) continue;
                if (!visited[newX][newY] && map[newX][newY] == 1){
                    visited[newX][newY] = true;
                    areaSize++;
                    que.offer(new int[]{newX, newY});
                }
            }
        }

        return areaSize;
    }
}
