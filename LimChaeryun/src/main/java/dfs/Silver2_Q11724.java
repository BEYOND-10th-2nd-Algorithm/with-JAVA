package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Silver2_Q11724 {

    static ArrayList<Integer>[] Node;
    static boolean[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Node = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i=1; i <= N; i++){
            Node[i] = new ArrayList<>();
        }

        while (M > 0){
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node[A].add(B);
            Node[B].add(A);

            M--;

        }


        for (int i = 1; i <= N; i++){

            if (!visited[i]){
                dfs(i);
                count++;
            }

        }

        System.out.println(count);
    }

    static void dfs(int N){

        visited[N] = true;

        for (int next : Node[N]){

            if (!visited[next]){
                visited[next] = true;
                dfs(next);
            }


        }

    }
}
