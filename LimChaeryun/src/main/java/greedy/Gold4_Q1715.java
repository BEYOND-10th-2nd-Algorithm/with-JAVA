package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Gold4_Q1715 {

    static int N;
    static int max;

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0){
            int card = Integer.parseInt(br.readLine());
            queue.offer(card);
        }

        while (!queue.isEmpty()){

            // size가 1일때, 추가로 더해지는 오류 범실
            if (N!=1 && queue.size() == 1){
                queue.poll();
            } else {
                Integer min1 = queue.poll();
                Integer min2 = queue.poll();

                int sum = min1 + min2;

                max += sum;

                if (queue.isEmpty()) continue;

                queue.offer(sum);

            }


        }

        System.out.println(max);

    }

}
