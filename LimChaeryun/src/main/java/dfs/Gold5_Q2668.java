package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold5_Q2668 {

    static ArrayList<Integer> arr;
    static boolean[] visited;
    static int[] num;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        num = new int[N+1];

        for(int i = 1; i <= N; i++){
            int add = Integer.parseInt(br.readLine());

            num[i] = add;
        }

        arr = new ArrayList<>();
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++){
            // i번 방문체크
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
//        visited = new boolean[N+1];
//        num = new int[N+1];

        Collections.sort(arr);
        System.out.println(arr.size());
        for (int result : arr){
            System.out.println(result);
        }
    }

    static void dfs(int start, int end) {

        if (!visited[num[start]]) {
            visited[num[start]] = true;
            dfs(num[start], end);
            visited[num[start]] = false;
        }
        if (num[start] == end) arr.add(end);

    }
}
