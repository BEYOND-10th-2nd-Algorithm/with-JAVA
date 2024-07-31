package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver4_Q28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());

        while (N > 0){
            st = new StringTokenizer(br.readLine());

            int input = Integer.parseInt(st.nextToken());

;           switch (input){
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    if (!stack.empty()){
                        sb.append(stack.pop()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    if (!stack.empty()){
                        sb.append(0).append("\n");
                    } else {
                        sb.append(1).append("\n");
                    }
                    break;

                case 5:
                    if (!stack.empty()){
                        sb.append(stack.peek()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }

            N--;
        }

        System.out.println(sb);
    }
}

/**
 * 명령은 총 다섯 가지이다.
 *
 * 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
 * 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
 * 3: 스택에 들어있는 정수의 개수를 출력한다.
 * 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
 * 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
 *
 * 첫째 줄에 명령의 수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
 *
 * 둘째 줄부터 N개 줄에 명령이 하나씩 주어진다.
 *
 * 출력을 요구하는 명령은 하나 이상 주어진다.
 */

