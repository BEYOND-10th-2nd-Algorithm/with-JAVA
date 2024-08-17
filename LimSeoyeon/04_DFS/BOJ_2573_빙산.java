import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int N,M;
    static int[][] howMuchMelt;
    static int []dy = { 0,0,-1,1 };
    static int []dx = { -1,1,0,0 };

    static void DFS(int y, int x, boolean melt) {
        visited[y][x] = true;
        if (melt) {
            for (int i = 0; i < 4; i++) {
                int nextY = dy[i] + y;
                int nextX = dx[i] + x;
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
                if (graph[nextY][nextX] == 0) {
                    howMuchMelt[y][x] += 1;
                }
            }
        }
        for (int i = 0; i < 4; i++) {
            int nextY = dy[i] + y;
            int nextX = dx[i] + x;
            if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
            if (graph[nextY][nextX] > 0 && !visited[nextY][nextX]) {
                DFS(nextY, nextX, melt);
            }
        }
    }

    static void init(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = false;
                howMuchMelt[i][j] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        //배열 선언
        graph = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];
        howMuchMelt = new int[N + 1][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int i = 0;

        while(true){
            //1. 시간 흐르게 하기. 변수 초기화
            i++;
            boolean allMelted = true;
            init();

            //2.빙산 녹이기
            //2-1. 빙산 녹게 하기 위해 DFS 돌려 howMuchMelt 업데이트
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] > 0 && !visited[j][k]) {
                        DFS(j, k,true);
                        break;
                    }
                }
            }
            //2-2. 빙산 높이에서 howMuchMelt 정보 빼기. 이때 0보다 작아지면 안되므로 예외처리.
            for (int k = 0; k < N; k++) {
                for (int j = 0; j < M; j++) {
                    graph[k][j] -= howMuchMelt[k][j];
                    if (graph[k][j] < 0) {
                        graph[k][j] = 0;
                    }
                }
            }
            //3. 결과값 확인하기
            //3-1. 전부 다 녹아버렸는지 여부 확인
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k]>0) {
                        allMelted = false;
                        break;
                    }
                }
                if (!allMelted) break;
            }
            //3-1-1.다 녹았으면 0 출력
            if (allMelted) {
                System.out.println(0);
                System.exit(0);
            }

            //3-2.그 외-> 빙산 둘로 나위어 졌는지 여부 확인
            // 아까 melt하면서 visited 정보 사용했으므로 다시 초기화
            init();
            boolean check = false;

            //3-2-1. 처음 방문한 빙산 위치에서 DFS 돌려서 visited 정보 업데이트
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k]!=0) {
                        DFS(j, k,false);
                        check = true;
                        break;
                    }
                }
                if (check)break;
            }

            // 3-2-2. 빙산인데 visited되지 않았으면 빙산이 나뉘어진것이므로 해당 초 (i) 출력
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k]> 0 &&!visited[j][k]) {
                        System.out.println(i);
                        System.exit(0);
                    }

                }
            }
            //끝나지 않았다면 다시 탐색.
        }
    }
}
