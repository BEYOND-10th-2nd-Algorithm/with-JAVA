package dp;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 이친수
public class Silver3_Q2193 {

    static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        DP = new long[N+1];

        // 초기값 설정시 오류 발생
        DP[1] = 1;
        if (N >= 2) DP[2] = 1;

        System.out.println(top(N));
    }

    static long top(int n){

        if (DP[n] == 0){
            DP[n] = top(n-1) + top(n-2);
        }
        return DP[n];
    }
}
