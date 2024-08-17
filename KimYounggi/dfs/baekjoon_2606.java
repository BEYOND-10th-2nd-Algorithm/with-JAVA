package com.we4sley.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_2606 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cNUm = Integer.parseInt(br.readLine());
        int edge = Integer.parseInt(br.readLine());

        boolean[] visited = new boolean[cNUm + 1];
        int[][] graph = new int[cNUm + 1][cNUm + 1];

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph[u][v] = graph[v][u] = 1;
        }

        dfs(visited, graph, 1);

        System.out.println(cnt);
    }

    private static void dfs(boolean[] visited, int[][] graph, int node) {
        visited[node] = true;

        for (int i = 0; i < graph[node].length; i++) {
            if (!visited[i] && graph[node][i] == 1) {
                cnt++;
                dfs(visited, graph, i);
            }
        }
    }
}