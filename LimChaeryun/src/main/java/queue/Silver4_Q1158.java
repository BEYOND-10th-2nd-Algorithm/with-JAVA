package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver4_Q1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int w = 0;
        Queue<Integer> que = new LinkedList<>();

        for(int i =1; i <= N; i++){
            que.offer(i);
        }

        sb = new StringBuilder();

        sb.append("<");

        while(!que.isEmpty()){

            for(int i =1; i <= K-1; i++){
                w = que.poll();
                que.offer(w);
            }

            sb.append(que.poll());

            if(!que.isEmpty()) sb.append(", ");

        }

        sb.append(">");

        System.out.println(sb);
    }
}
