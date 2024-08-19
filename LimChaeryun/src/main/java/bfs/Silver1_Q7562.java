package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동
public class Silver1_Q7562 {

    static int size;

    // 체스판
    static int[][] board;

    // 나이트의 이동 범위
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

    // 방문 여부
    static boolean[][] visited;



    public static void main(String[] args) throws IOException {




        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            size = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            int[] nowP = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] nextP = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            board = new int[size][size];
            visited = new boolean[size][size];

            bfs(nowP[0], nowP[1]);

            System.out.println(board[nextP[0]][nextP[1]]);
        }
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()){
            int[] start = queue.poll();
            int nowX = start[0];
            int nowY = start[1];

            for (int i =0; i < 8; i++){
                int newX = start[0] + dx[i];
                int newY = start[1] + dy[i];

                if (newX >= 0 && newX < size){
                    if (newY >= 0 && newY < size){

                        if (!visited[newX][newY]){
                            queue.add(new int[]{newX, newY});
                            board[newX][newY] = board[nowX][nowY] + 1;
                            visited[newX][newY] = true;
                        }
                    }
                }
            }
        }
    }

}
