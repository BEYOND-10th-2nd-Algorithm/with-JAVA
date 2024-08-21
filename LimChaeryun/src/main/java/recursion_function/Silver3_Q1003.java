package recursion_function;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 피보나치 함수
public class Silver3_Q1003 {

    static int zeroCount;
    static int oneCount;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] fibo = new int[41][2];

        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for (int i =2; i <= 40; i++){
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo[n][0]).append(" ").append(fibo[n][1]).append("\n");
//
//            fibonacci(n);
//            sb.append(zeroCount).append(" ").append(oneCount).append("\n");
//
//            zeroCount = 0;
//            oneCount = 0;
        }

        System.out.println(sb);
    }

//    static void fibonacci(int n){
//        if (n==0) zeroCount++;
//        else if (n==1) oneCount++;
//        else {
//            fibonacci(n-1);
//            fibonacci(n-2);
//        }
//    }
}
