package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1_Q14889 {

    static boolean[] visited;
    static int[][] map;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int startTeam, linkTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++){
            String[] line = br.readLine().split(" ");;

            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        DFS(0, 0);
        System.out.println(min);


    }

    static void DFS(int dept, int count){
        if ( N / 2 == count){
            checkedTeam();
            return;
        }

        for (int i = dept; i < N; i++){

            if (!visited[i]){
                visited[i] = true;
                DFS(i, count+1);
                visited[i] = false;
            }
        }

    }

    static void checkedTeam(){
        startTeam = 0;
        linkTeam = 0;

        for (int i = 0; i < N; i++){

            for (int j = i+1; j < N; j++){

                if (visited[i]&& visited[j]){
                    startTeam += map[i][j];
                    startTeam += map[j][i];
                } else if (!visited[i]&& !visited[j]){
                    linkTeam += map[i][j];
                    linkTeam += map[j][i];
                }
            }
        }

        int abs = Math.abs(startTeam - linkTeam);

        if (abs == 0){
            System.out.println(0);
            System.exit(0);
        }

        min = Math.min(abs, min);
    }
}
