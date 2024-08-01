import java.util.Stack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str = scanner.next();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch>='A' && ch<='Z'){
                System.out.print(ch);
            }
            else if(ch=='('){
                st.push(ch);
            }

            else if(ch==')'){
                while (!st.empty()&& st.peek()!='('){
                    System.out.print(st.pop());
                }
                st.pop();
            }
            else{
                if(st.empty()||st.peek()=='('){
                    st.push(ch);
                }
                else if(ch=='*' || ch=='/'){
                    while(!st.empty()&&st.peek()!='('){
                        if(st.peek()=='*' || st.peek()=='/'){
                            System.out.print(st.pop());
                        }
                        else break;
                    }
                    st.push(ch);
                }
                else{ // ch 가 + or -
                    while(!st.empty()&&st.peek()!='('){
                        System.out.print(st.pop());
                    }
                    st.push(ch);
                }
            }

        }

        while(!st.empty()){
            System.out.print(st.pop());
        }

    }

}
