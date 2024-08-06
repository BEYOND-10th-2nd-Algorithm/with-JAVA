import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class baekjoon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());

        Queue<Integer> queue = new LinkedList<Integer>();
        List<Integer> arr = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < inputNum; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            switch (input) {
                case "push":
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        sb.append(queue.poll()).append("\n");
                        break;
                    }
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1").append("\n");
                        break;
                    } else {
                        sb.append("0").append("\n");
                        break;
                    }
                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        sb.append(queue.peek()).append("\n");
                        break;
                    }
                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1").append("\n");
                        break;
                    } else {
                        arr.addAll(queue);
                        sb.append(arr.get(arr.size() - 1)).append("\n");
                        break;
                    }
            }
        }
        System.out.println(sb.toString());
    }
}