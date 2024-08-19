package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 우선순위 큐
public class Silver1_Q11286 {
    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> {
            int absCompare = Integer.compare(Math.abs(o1), Math.abs(o2));
            if (absCompare == 0){
                return Integer.compare(o1, o2);
            }
            return absCompare;
        });

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        while (N-- > 0){
            arr.add(Integer.parseInt(br.readLine()));
        }

        for (int x : arr){
            if (x == 0 && que.isEmpty()){
                sb.append(0).append("\n");
            } else if (x == 0){
                sb.append(que.poll()).append("\n");
            } else {
                que.offer(x);
            }
        }

        System.out.println(sb);


    }
}
