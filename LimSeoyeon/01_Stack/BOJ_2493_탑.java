package com.ohgiraffers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static class Pair{
      int first,second;
      Pair(int first, int second){
          this.first=first;
          this.second=second;
      }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());

        int[] arr= new int[N+1];
        int[] res =new int[N+1];
        Stack<Pair> st = new Stack<>();

        stk = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++){
            arr[i]= Integer.parseInt(stk.nextToken());
        }

        for(int i=N; i>=1; i--){
            while(!st.empty()&&st.peek().second<arr[i]){
                res[st.pop().first]=i;
            }
            st.push(new Pair(i,arr[i]));
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
