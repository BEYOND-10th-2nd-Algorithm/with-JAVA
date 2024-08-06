import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class pgm_process {
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        System.out.println(solution(priorities, location));

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (!queue.isEmpty()) {
            int max = Collections.max(queue);

            if (queue.peek() != max) {
                queue.add(queue.poll());

                if (location == 0) {
                    location = queue.size() - 1;
                } else {
                    location--;
                }
            } else {
                answer++;

                if (location == 0) {
                    break;
                } else {
                    queue.poll();
                    location--;
                }
            }
        }
        return answer;
    }
}