package stack;

import java.util.Scanner;
import java.util.Stack;

public class Q17413 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean flag = false;

        Stack<Character> stack = new Stack<>();
        StringBuilder st = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            stack.push(ch);

            //<가 나올 경우
            if(ch == '<'){
                stack.pop(); // 순서상 확인전에 push하기 때문에 일단 <를 비운다.
                while(!stack.isEmpty()){ //이전에 저장된 스택을 모두 비워서 출력한다.
                    st.append(stack.pop());
                }
                st.append('<');
                flag = true;
            }

            else if(ch == '>'){
                st.append(stack.pop());
                flag = false;
            }

            else if(ch == ' ' && !flag){ // 공백이 나오고 <>안에 포함되지 않을 경우
                stack.pop();
                while(!stack.isEmpty()){
                    st.append(stack.pop());
                }
                st.append(' ');
            }

            else if(flag){ // <> 안에 포함될 경우
                st.append(stack.pop());
            }

            //문자열의 끝일 경우 현재 스택에 저장된 값 모두 방출
            else if(i == str.length()-1){
                while(!stack.isEmpty()){
                    st.append(stack.pop());
                }
            }

        }
        System.out.println(st.toString());

    }
}
