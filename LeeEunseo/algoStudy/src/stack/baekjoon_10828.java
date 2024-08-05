package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_10828 {
    public static void main(String[] args) {

        //BufferReader : 개행 문자만 인식, String 반환, 공백도 String으로 인식, 예외 처리 필수
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Stack<String> stack = new Stack<>();

            int num = Integer.parseInt(br.readLine());  // 첫 줄 : 명령어 개수 받기

            for(int i=0; i<num; i++){
                String input = br.readLine();
                String[] strArray = input.split(" ");    // 공백 기준으로 String 쪼개기

                switch(strArray[0]){
                    case "push":
                        stack.push(strArray[1]);
                        break;
                    case "pop":
                        // 스택에서 가장 위에 있는 정수를 빼고, 그 정수를 출력
                        // 스택에 정수가 없으면 -1 출력
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                        if(!stack.isEmpty()) stack.pop();
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "empty":
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "top":
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                        break;
                }
            }

        } catch (IOException e) { // 예외 처리 필수
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}


