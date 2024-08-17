package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* 연결 요소의 개수 */
public class Q11724 {

    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {


        // DFS 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의 개수
        int m = Integer.parseInt(st.nextToken()); // 간선의 개수

        list = new ArrayList[n + 1]; // 정점은 1부터 n까지 존재
        for (int i = 0; i <= n; i++) list[i] = new ArrayList<Integer>();

        visited = new boolean[n+1]; // 방문한 노드를 표시


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        for(int i = 1; i <= n; i++){
            if(!visited[i]) {
                DFS(i); //해당 노드를 방문하지 않았다면 탐색 시작
                cnt++; // 해당 노드와 연결된 노드의 탐색이 모두 끝나면 값 증가
            }

        }

        System.out.println(cnt);


    }
    public static void DFS(int curNode){

        visited[curNode] = true; // 현재 노드를 방문 처리한다.
        for(int i=0; i<list[curNode].size(); i++){
            int nextNode = list[curNode].get(i);
            if(!visited[nextNode]) DFS(nextNode);
        }
    }
}
