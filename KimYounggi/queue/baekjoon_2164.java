import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class baekjoon_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < inputNum; i++) {
            queue.add(i + 1);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}