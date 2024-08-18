package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* 연결 요소의 개수*/
public class baekjoon_11724 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count = 0;

    private static void BFS(int R) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(R); // 시작 노드를 큐에 넣기
        visited[R] = true;  // 시작 노드 방문


        while (!q.isEmpty()) {  // 큐가 빌 때까지 반복

            int currNode = q.poll();

            for (int i = 0; i < graph[currNode].size(); i++) {
                int nextNode = graph[currNode].get(i);

                if (!visited[nextNode]) {   // 다음 노드를 방문하지 않았으면
                    q.offer(nextNode);  // 다음 노드 큐에 넣기
                    visited[nextNode] = true;
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 노드 수
        int M = Integer.parseInt(st.nextToken());   // 엣지 수

        // 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        // 주어진 정보로 그래프 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }


        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                BFS(i);
                count++;
            }
        }

        System.out.println(count);

        br.close();
    }
}
