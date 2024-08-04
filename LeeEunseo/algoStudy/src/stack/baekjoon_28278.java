package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_28278 {
    public static void main(String[] args) {
        try {
            // BufferReader : 개행 문자만 인식, String 반환, 공백도 String으로 인식, 예외 처리 필수
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Stack<Integer> stack = new Stack<>();
            int num = Integer.parseInt(br.readLine());  // 첫 줄 : 명령의 수 N 받기

            for(int i = 0; i < num; i++){
                String input = br.readLine();   // 명령 받기
                String[] strArray = input.split(" ");   // 공백 기준으로 String 쪼개기

                switch(strArray[0]){
                    case "1" :
                        stack.push(Integer.parseInt(strArray[1]));
                        break;   //push X
                    case "2" :
                        if(!stack.isEmpty()){   //pop
                            System.out.println(stack.peek());
                            stack.pop();
                        }else{
                            System.out.println("-1");
                        }
                        break;
                    case "3" :
                        System.out.println(stack.size());
                        break;
                    case "4" :
                        System.out.println(stack.isEmpty() ? 1 : 0);
                        break;
                    case "5" :
                        System.out.println(stack.isEmpty() ? -1 : stack.peek());
                }
            }

        } catch (IOException e) { // 예외 처리 필수
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
