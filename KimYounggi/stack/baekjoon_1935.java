package com.we4sley.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class baekjoon_1935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputNum = Integer.parseInt(br.readLine());
        String command = br.readLine();

        Stack<Double> stack = new Stack<Double>();
        int[] arr = new int[inputNum];

        for (int i = 0; i < inputNum; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) >= 'A' && command.charAt(i) <= 'Z') {
                stack.push((double) arr[command.charAt(i) - 'A']);
            } else {
                double d1 = stack.pop();
                double d2 = stack.pop();
                double d3 = 0.0;
                switch (command.charAt(i)) {
                    case '+':
                        d3 = d2 + d1;
                        stack.push(d3);
                        break;
                    case '-':
                        d3 = d2 - d1;
                        stack.push(d3);
                        break;
                    case '*':
                        d3 = d2 * d1;
                        stack.push(d3);
                        break;
                    case '/':
                        d3 = d2 / d1;
                        stack.push(d3);
                        break;
                }
            }
        }
        System.out.printf("%.2f", stack.pop());
    }
}
/*
* 5
ABC*+DE/-
1
2
3
4
5
* */