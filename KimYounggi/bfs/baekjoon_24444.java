import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_24444 {

    static List<List<Integer>> graph = new ArrayList<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        visited = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        bfs(r);

        for (int i = 1; i <= n; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb.toString().trim());
    }

    private static void bfs(int node) {

        int count = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = count++;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next = graph.get(cur).get(i);
                if (visited[next] == 0) {
                    queue.offer(next);
                    visited[next] = count++;
                }
            }
        }
    }
}
