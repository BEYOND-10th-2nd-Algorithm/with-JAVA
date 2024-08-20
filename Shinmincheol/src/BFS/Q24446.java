package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//백준 24446번 알고리즘 수업 - 너비 우선 탐색 3
public class Q24446 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] depth;
    static Queue<Integer> q;
    static int n;
    static int m;
    static int r;
    static StringBuilder sb;

    static void BFS(int startNode){

        q.offer(startNode);
        visited[startNode] = true; // 시작 정점을 큐에 넣고 방문처리한다.
        depth[startNode] = 0; // 깊이를 저장한다.

        while(!q.isEmpty()){
            int curNode = q.poll();
            for(int i=0; i<graph[curNode].size(); i++){
                int nextNode = graph[curNode].get(i);
                if(!visited[nextNode]){
                    q.offer(nextNode);
                    visited[nextNode] = true;
                    depth[nextNode] = depth[curNode] + 1;
                }

            }

        }

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken()); // 정점의 수
        m = Integer.parseInt(st.nextToken()); // 간선의 수
        r = Integer.parseInt(st.nextToken()); // 시작 정점

        graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) graph[i] = new ArrayList<>();

        visited = new boolean[n+1];
        depth = new int[n+1];

        Arrays.fill(depth , -1);
        q = new LinkedList<>();



        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u].add(v);
            graph[v].add(u);
        }

        BFS(r);


        for(int i=1; i<n+1; i++){
            sb.append(depth[i]).append("\n");
        }

        sb.deleteCharAt(sb.length()-1);

        System.out.println(sb);

    }
}
