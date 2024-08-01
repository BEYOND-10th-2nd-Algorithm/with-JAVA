package stack;

import java.util.Scanner;
import java.util.Stack;

public class Q9012 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<testCases; i++){
            String str = sc.nextLine();
            checkVps(str);
        }

    }

    public static void checkVps(String s){
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == ')'){
                if(stack.isEmpty()){
                    System.out.println("NO");
                    return;
                }
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        if(!stack.isEmpty()){
            System.out.println("NO");
            return;
        }

        System.out.println("YES");


    }

}