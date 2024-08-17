package com.we4sley.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];
        int[][] graph = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        int cnt = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) continue;
            dfs(visited, graph, i);
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void dfs(boolean[] visited, int[][] graph, int node) {
        visited[node] = true;

        for (int i = 0; i < graph[node].length; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                dfs(visited, graph, i);
            }
        }
    }
}
