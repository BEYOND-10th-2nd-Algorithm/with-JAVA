package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold4_Q1987 {

    static int[][] map;
    static boolean[][] ch;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};
    static int max;
    static boolean[] visited;
    static int X, Y;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[X][Y];
        ch = new boolean[X][Y];

        for (int i = 0; i < X; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
//            char[] charArray = line.toCharArray();

            for (int j = 0; j < Y; j++){
                map[i][j] = line.charAt(j) - 'A';
            }
        }


        visited = new boolean[26];

        DFS(0, 0, 1);
        System.out.println(max);

    }

    static void DFS(int x, int y, int length){
        visited[map[x][y]] = true;
        max = Math.max(length, max);

        for (int i =0; i < 4; i++){
            int newX = x + dX[i];
            int newY = y + dY[i];

            if (newX >= 0 && newX < X && newY >= 0 && newY < Y) {
                if (!visited[map[newX][newY]]) {
                    DFS(newX, newY, length + 1);
                    visited[map[newX][newY]] = false;
                }
            }
        }
    }
}
