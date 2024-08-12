package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q24479 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int[] order;
    static int cnt = 1;
    static StringBuilder sb = new StringBuilder();
    static int n, m, r;

    public static void main(String[] args) throws IOException {

        //인접리스트로 DFS 구현 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken()); // 시작 정점

        visited = new boolean[n+1];
        order = new int[n+1];

        list = new ArrayList[n+1];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }


        for(int i = 0; i < m; i++) { // 양방향 간선 정보 입력
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        // 인접 정점은 오름차순으로 방문
        for (int i = 0; i < n + 1; i++) {
            Collections.sort(list[i]);
        }

        DFS(r);


        for(int i = 1; i <= n; i++) {
            sb.append(order[i] + "\n");
        }

        System.out.println(sb);
    }


    public static void DFS(int curNode){

        order[curNode] = cnt++;

        visited[curNode] = true; // 현재 정점에 방문 표시를 한다.
        for(int i = 0; i<list[curNode].size(); i++){
            int nextNode = list[curNode].get(i);
            if(!visited[nextNode]) { DFS(nextNode); } //만약 방문하지 않은 노드라면 DFS 탐색
         }

    }

}
