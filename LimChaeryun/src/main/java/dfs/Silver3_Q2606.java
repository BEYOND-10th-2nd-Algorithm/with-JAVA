package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Silver3_Q2606 {

    static List<Integer>[] Node;
    static int[] visit;
    static int visitNode = 1;

    public static void main(String[] args) throws IOException {

        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        Node = new ArrayList[N+1];
        visit = new int[N+1];

        for (int i = 1; i <= N; i++){
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

        for (int i = 1; i <= N; i++) {
            Collections.sort(Node[i]);
        }

        dfs(1);

        for (int i = 1; i <= N; i++){

            // 1번 노트일때를 제외함
            if (visit[i] != 0 && visit[i] != 1){
                count++;
            }
        }

        System.out.println(count);


    }

    static void dfs(int N){
        visit[N] = visitNode++;

        for (int next : Node[N]){

            if (visit[next] == 0){
                dfs(next);
            }
        }
    }

}
