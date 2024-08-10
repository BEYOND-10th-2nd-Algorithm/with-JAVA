package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Gold4_Q3078 {
    public static void main(String[] args) throws IOException {

        Queue<String> que = new LinkedList<>();
        List<String> list = new ArrayList<>();
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            list.add(st.nextToken());
            que.offer(list.get(i));
        }
        // 이중포문을 돌려서 같으면 count ++;
        for (int i = 0; i < list.size(); i++){

            for (int j = 0; j < K; j++){

            }
        }
    }
}
