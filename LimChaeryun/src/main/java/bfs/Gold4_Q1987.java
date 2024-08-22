package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 알파벳 - 알파벳 지나기
public class Gold4_Q1987 {

    static boolean[][] visited;
    static char[][] map;
    static int[] dX = {1, 0, -1, 0};
    static int[] dY = {0, 1, 0, -1};

    static int X, Y;
    static int count;
    static int[][] mapCount;

    static List<Character>[] cr;
    static int co;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        visited = new boolean[X][Y];
        map = new char[X][Y];
        mapCount = new int[X][Y];
        cr = new ArrayList[26];

        for (int i =0; i < cr.length; i++){
            cr[i] = new ArrayList<>();
        }

        for (int i = 0; i < X; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            char[] charArray = line.toCharArray();

            for (int j = 0; j < Y; j++){
                map[i][j] = charArray[j];
            }
        }

        for (int i = 0; i < 4; i++){

            if (i == 0 || i == 3){
                int x = dX[i];
                int y = Y-1 + dY[i];

                // BFS를 통해, 인접 리스트 만들기 (1 -> 1, 2, 3 | 2 -> 5, 6, 7 ... 처럼)
                if (!visited[x][y] && !cr[map[0][Y-1]].contains(map[x][y])){
                    cr[map[0][Y-1]].add(map[x][y]);
                    visited[0][Y-1] = true;
                    BFS(x, y);
                    visited = new boolean[X][Y];
                }
            }
        }

        System.out.println(count);
//        System.out.println(Arrays.stream(mapCount).flatMapToInt(Arrays::stream).max().orElseThrow());
//        System.out.println(co);
//        System.out.println(max());
    }


    static void BFS(int x, int y){
        Queue<int[]> que = new LinkedList<>();
        visited[x][y] = true;
        que.offer(new int[]{x, y});

        while (!que.isEmpty()){
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++){
                int newX = nowX + dX[i];
                int newY = nowY + dY[i];

                if (newX < 0 || newX >= X || newY < 0 || newY >= Y) continue;
                if (!visited[newX][newY] && map[nowX][nowY] != map[newX][newY] && !cr[map[nowX][nowY]].contains(map[newX][newY])){
                    visited[newX][newY] = true;
                    que.add(new int[]{newX, newY});
                    cr[map[nowX][nowY]].add(map[newX][newY]);
//                    mapCount[newX][newY] = mapCount[nowX][nowY] + 1;
//                    System.out.println(map[newX][newY]);
//                    count++;
                }
            }
        }


    }

    static void DFS(int x, int y){

    }

//    static int max(){
//        int max = 0;
//        for (int[] arr : mapCount){
//            for (int num : arr){
//                if (num > max) max = num;
//            }
//        }
//
//        return max;
//    }
}
