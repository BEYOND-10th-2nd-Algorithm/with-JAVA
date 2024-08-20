import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M;

    static int []dy = { 0,0,-1,1 };
    static int []dx = { -1,1,0,0 };
    static int [][][]dist;
    static boolean [][] arr;

    public static class Pii{
        int first; // y좌표
        int second; // x좌표
        int third; // 벽 부순 개수. 0 or 1

        Pii(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
    public static int BFS() {
        Queue<Pii> q = new LinkedList<>();
        q.offer(new Pii(0,0,0));

        while (!q.isEmpty()) {
            int curY = q.peek().first;
            int curX = q.peek().second;
            int curBroken = q.peek().third;

            q.poll();
            if (curY == N - 1 && curX == M - 1) {
                return dist[curY][curX][curBroken]+1;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
                if (dist[nextY][nextX][curBroken] != 0) continue;
                if (!arr[nextY][nextX]) { //벽 안부셔도 될 때
                    dist[nextY][nextX][curBroken] = dist[curY][curX][curBroken] + 1;
                    q.offer(new Pii(nextY,nextX,curBroken));
                }
                else { // 벽 부셔야 할 때
                    if (curBroken==0) { //지금까지 안부셨으면
                        dist[nextY][nextX][1] = dist[curY][curX][curBroken] + 1;
                        q.offer(new Pii(nextY,nextX,1));
                    }
                }

            }
        }

        return -1;

    }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stk = new StringTokenizer(br.readLine());
             N = Integer.parseInt(stk.nextToken());
             M = Integer.parseInt(stk.nextToken());

            dist = new int[N+1][M+1][2];
            arr = new boolean[N+1][M+1];
            for (int i = 0; i < N; i++) {
                stk = new StringTokenizer(br.readLine());
                String s = stk.nextToken();
                for (int j = 0; j < M; j++) {
                    if (s.charAt(j) == '0') arr[i][j] = false;
                    else arr[i][j] = true;
                    dist[i][j][0]=0;
                    dist[i][j][1]=0;
                }
            }


            System.out.println(BFS());

    }
}
