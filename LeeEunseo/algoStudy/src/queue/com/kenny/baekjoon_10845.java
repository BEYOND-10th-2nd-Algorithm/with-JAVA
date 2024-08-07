package queue.com.kenny;

import java.io.*;
import java.util.*;

public class baekjoon_10845 {
    public static void main(String[] args) throws IOException { // try-catch문 대신 이렇게 해도 됨
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> arr = new ArrayList<>();
        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String input = br.readLine();
            String [] strArray = input.split(" ");

            switch (strArray[0]){
                case "push" :
                    queue.offer(Integer.parseInt(strArray[1]));
                    break;
                case "pop" :
                    if (!queue.isEmpty()) {
                        bw.write(queue.peek() + "\n");
                        queue.poll();
                    } else {
                        bw.write("-1\n");
                    }
                    break;
                case "size" :
                    bw.write(queue.size() + "\n");
                    break;
                case "empty" :
                    if(queue.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    break;
                case "front" :
                    if(queue.isEmpty()) bw.write("-1\n");
                    else bw.write(queue.peek() + "\n");
                    break;
                case "back" :
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        arr.addAll(queue);
                        bw.write(arr.get(arr.size()-1) + "\n");
                    }
                    break;
            }
            bw.flush(); //flush 없으면 출력이 안 됨
        }
    }
}

// 문제 1 : JAVA에는 Queue의 값을 꺼내오는 메소드가 없어서 back 구현 못 함. 이럴 때 직접 메소드를 만들거나 할 줄 알아야 하는데...
// 문제 2 : linked list가 뭔지 잘 이해하지 못한 상태에서 하느라 헤맸다
// 문제 3: bw.write도 String을 반환한다는 걸 잊고 integer
