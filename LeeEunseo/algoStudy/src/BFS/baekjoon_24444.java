package BFS;


import java.io.*;
import java.util.*;

// N개 노드, M개 엣지의 무방향 그래프
// 노드 : 1~N
// 노드 R 부터 BFX로 노드 방문할 때 노드의 방문 순서 출력
public class baekjoon_24444 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count = 0;

    private static void BFS(int R) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(R); // 시작 노드를 큐에 넣기
        count++;
        visited[R] = true;  // 시작 노드 방문
        order[R] = count;

        while (!q.isEmpty()) {  // 큐가 빌 때까지 반복

            int currNode = q.poll();

            for (int i = 0; i < graph[currNode].size(); i++) {
                int nextNode = graph[currNode].get(i);

                if (!visited[nextNode]) {   // 다음 노드를 방문하지 않았으면
                    q.offer(nextNode);  // 다음 노드 큐에 넣기
                    count++;
                    visited[nextNode] = true;
                    order[nextNode] = count;
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(st.nextToken());   // 노드 수
        int M = Integer.parseInt(st.nextToken());   // 엣지 수
        int R = Integer.parseInt(st.nextToken());   // 시작 노드

        // 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];
        order = new int[N + 1];

        // 주어진 정보로 그래프 생성
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]); // graph를 오름차순으로 정렬
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bw.write("0\n");
            } else {
                bw.write(order[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
