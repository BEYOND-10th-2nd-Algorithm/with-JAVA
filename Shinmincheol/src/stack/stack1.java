package stack;

import java.util.Scanner;
import java.util.Stack;

class stack1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(solution(str));

    }
    public static boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();


        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);
            if (ch == ')') {
                if (stack.isEmpty()) {
                    answer = false;
                    return answer;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        if(!stack.isEmpty()){
            answer = false;
            return answer;
        }

        return answer;
    }

}
