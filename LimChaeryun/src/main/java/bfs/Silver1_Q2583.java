package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 영역 구하기
public class Silver1_Q2583 {

    static boolean[][] visited;
    static int[][] map;

    static int N, M, K;

    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    static int count;
    static List<Integer> width;
//    static int j;
//    static int[] widt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new int[N][M];
        width = new ArrayList<>();

//        widt = new int[K];
        while (K-- > 0){
            st = new StringTokenizer(br.readLine(), " ");

            int fX = Integer.parseInt(st.nextToken());
            int fY = Integer.parseInt(st.nextToken());
            int sX = Integer.parseInt(st.nextToken());
            int sY = Integer.parseInt(st.nextToken());

            for (int i = fX; i < sX; i++){

                for (int j = fY; j < sY; j++){
                    map[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){

                if (!visited[i][j] && map[i][j] == 0){
                    int areaSize = BFS(i, j);
                    width.add(areaSize);
                    count++;
                }
            }
        }

//        Arrays.sort(widt);
        Collections.sort(width);

        System.out.println(count);
        for (int no : width){
            System.out.print(no + " ");
        }
//        System.out.println();
//        for (int no : widt){
//            System.out.print(no + " ");
//        }

    }

    static int BFS(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        int areaSize = 1;
        que.offer(new int[]{x, y});
//        widt[j] = 1;
        while (!que.isEmpty()){
            int[] poll = que.poll();
            int X = poll[0];
            int Y = poll[1];

            for (int i = 0; i < 4; i++){
                int newX = X + dX[i];
                int newY = Y + dY[i];

                if (newX < 0 || newX >= N || newY < 0 || newY >= M) continue;
                if (!visited[newX][newY] && map[newX][newY] == 0){
                    visited[newX][newY] = true;
                    que.offer(new int[]{newX, newY});
                    areaSize++;
//                    widt[j]++;
                }
            }

        }
//        j++;
        return areaSize;
    }
}
