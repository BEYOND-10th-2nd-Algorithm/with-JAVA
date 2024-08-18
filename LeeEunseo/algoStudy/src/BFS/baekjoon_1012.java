package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 유기농 배추
public class baekjoon_1012 {

    static int[][] map;
    static boolean[][] visited;
    // 오 -> 위 -> 왼 -> 아래
    static int[] dx = {1, 0, -1, 0};    // x축 방향 배열
    static int[] dy = {0, -1, 0, 1};    // y축 방향 배열
    static int count = 0;
    static int N, M;

    private static void BFS(int y, int x) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int curY = curr[0];
            int curX = curr[1];

            for (int i = 0; i < 4; i++) {
                int dirx = curX + dx[i];
                int diry = curY + dy[i];

                if (dirx >= 0 && diry >= 0 && dirx < M && diry < N) {
                    if (!visited[diry][dirx] && map[diry][dirx] == 1) {
                        q.add(new int[]{diry, dirx});
                        visited[diry][dirx] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());    // 테스트 케이스의 수

        for (int q = 0; q < T; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int K = Integer.parseInt(st.nextToken());   // 배추 수

            // 초기화
            map = new int[N][M];
            visited = new boolean[N][M];

            // 주어진 정보로 맵 생성
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;  // 배추가 심어진 위치 = 1 표시
            }

            // 디버깅을 위한 맵 출력
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }

            count = 0;  // 안 해주면 이전 결과에 더해져서 나옴
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        BFS(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }
}
