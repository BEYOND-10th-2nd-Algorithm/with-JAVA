import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static int [][] DP;

    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        //배열 선언
        graph = new int[N][M];
        visited = new boolean[N*M];
        DP = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j=0; j<M; j++){
                graph[i][j]= Integer.parseInt(st.nextToken());
                DP[i][j]=-1;
            }
        }
        System.out.println(dfs(0,0));
    }
    static int dfs(int y, int x) {
        if(DP[y][x]!=-1){
            return DP[y][x];
        }
        if(y==N-1 && x==M-1){
            return 1;
        }
        DP[y][x]=0;
        for(int i=0; i<4; i++){
            int nextY = y+dy[i];
            int nextX = x+dx[i];
            if(nextY<0|| nextX<0|| nextY>=N || nextX>=M) continue;
            if(graph[nextY][nextX]<graph[y][x]){
                DP[y][x] +=dfs(nextY,nextX);
            }
        }
        return DP[y][x];
    }
}
