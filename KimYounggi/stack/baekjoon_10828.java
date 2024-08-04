package com.we4sley.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class baekjoon_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        StringTokenizer st;

        for (int i = 0; i < inputNum; i++) {
            st = new StringTokenizer(br.readLine());
            String input = st.nextToken();

            if (input.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            } else if (input.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (input.equals("size")) {
                System.out.println(stack.size());
            } else if (input.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else if (input.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
