package com.we4sley.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class baekjoon_2667 {

    static List<Integer> apart = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] graph = new int[input][input];
        boolean[][] visited = new boolean[input][input];

        for (int i = 0; i < input; i++) {
            String str = br.readLine();
            for (int j = 0; j < input; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (visited[i][j]) continue;
                if (graph[i][j] == 1) {
                    dfs(graph, visited, i, j);
                    apart.add(cnt);
                    cnt = 0;
                }
            }
        }

        System.out.println(apart.size());
        Collections.sort(apart);

        for (int i = 0; i < apart.size(); i++) {
            System.out.println(apart.get(i));
        }
    }

    private static void dfs(int[][] graph, boolean[][] visited, int row, int column) {
        cnt++;

        visited[row][column] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        for (int k = 0; k < 4; k++) {
            if ((row + dx[k]) < 0 || (row + dx[k] > graph.length - 1 || (column + dy[k]) < 0) || (column + dy[k] > graph.length - 1)) {
                continue;
            }
            if (!visited[row + dx[k]][column + dy[k]] && graph[row + dx[k]][column + dy[k]] == 1) {
                dfs(graph, visited, row + dx[k], column + dy[k]);
            }
        }
    }
}
