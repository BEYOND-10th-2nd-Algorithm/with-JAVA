package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PGM_Level01 {
    public static void main(String[] args) throws IOException {

        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int leftCount = 0, rightCount = 0, count = 0;
        boolean result = true;

        char[] charArray = br.readLine().toCharArray();

        for (char c : charArray) {
            stack.push(c);
        }

        while (!stack.empty()){

            char pop = stack.pop();

            if ((pop == '(' && count == 0) || (rightCount > leftCount)){
                result = false;
                break;
            }

            switch (pop){
                case ')':
                    leftCount++;
                    break;

                case '(':
                    rightCount++;
                    break;
            }

            count++;
        }

        if (leftCount != rightCount){
            result = false;
        }

        System.out.println(result);
    }
}
