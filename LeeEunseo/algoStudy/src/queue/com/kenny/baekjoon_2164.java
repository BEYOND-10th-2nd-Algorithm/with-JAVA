package queue.com.kenny;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2164{
    public static void main(String[] args) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int input = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<Integer>();

            int front = 0;

            // 작은 순으로 큐에 넣기
            for (int i = 1; i <= input; i++) {
                queue.offer(i);
            }

            while(queue.size() > 1) {
                queue.poll(); // 맨 위에 있는 카드 큐에서 빼기
                front = queue.peek();   // 맨 위에 있는 카드 확인
                queue.poll();   // 맨 위에 있는 카드 큐에서 빼기
                queue.offer(front); // 뺀 카드 큐에 넣기
            }
            System.out.println(queue.peek());

        } catch (IOException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
