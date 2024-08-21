import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class baekjoon_10282 {

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static List<Node>[] graph;
    static boolean[] visited;
    static int[] dist;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V + 1];
            dist = new int[V + 1];
            visited = new boolean[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int slave = Integer.parseInt(st.nextToken());
                int master = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                graph[master].add(new Node(slave, cost));
            }
            cnt = 0;
            dijkstra(start);

            int min = -1;

            for (int i = 0; i < dist.length; i++) {
                if (dist[i] < Integer.MAX_VALUE && dist[i] > min) {
                    min = dist[i];
                }
            }
            sb.append(cnt).append(" ").append(min).append("\n");

            cnt = 0;
        }
        System.out.println(sb.toString().trim());
    }

    private static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (!visited[cur.v]) {
                visited[cur.v] = true;
                cnt++;
            }

            for (Node next : graph[cur.v]) {
                if (!visited[next.v] && dist[next.v] > cur.cost + next.cost) {
                    dist[next.v] = cur.cost + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
