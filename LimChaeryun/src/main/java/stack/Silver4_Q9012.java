package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver4_Q9012 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String temp = "";
        boolean isValid;
        Stack<Character> stack;

         while (T-- > 0){
             stack = new Stack<>();
             temp = br.readLine();
            isValid = true;

             for (char word : temp.toCharArray()){

                 if (word == '('){
                     stack.push(word);
                 } else {

                     if (stack.isEmpty()){
                         sb.append("NO\n");
                         isValid = false;
                         break;
                     }

                     stack.pop();
                 }
             }

             if (!isValid) continue;

             if (!stack.isEmpty()){
                 sb.append("NO\n");
             }

             if (isValid && stack.isEmpty()) sb.append("YES\n");

         }

        System.out.println(sb);
    }
}
