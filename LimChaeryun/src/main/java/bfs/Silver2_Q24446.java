package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Silver2_Q24446 {

    static ArrayList<Integer>[] Node;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Node = new ArrayList[N+1];
        for (int i=0; i<N+1; i++){
            Node[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node[A].add(B);
            Node[B].add(A);
        }

        for (int i =0; i < N+1; i++){
            Collections.sort(Node[i]);
        }

        BFS(R);


    }

    static void BFS(int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        while (!que.isEmpty()){
            int curNode = que.poll();
            System.out.println(curNode);
            for (int i=0; i<Node[curNode].size(); i++){
                int next = Node[curNode].get(i);
                if (!visited[next]){
                    que.offer(next);
                    visited[next]=true;
                }
            }
        }
    }


}
