package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_Q11726 {

    static long[] DP;
    static int N;
    static int sup = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        DP = new long[N+1];


        DP[0] = 0;
        DP[1] = 1;
        if (N >=2) DP[2] = 2;   // N이 1일때, 벗어남

        System.out.println(topDown(N));
    }

    static long topDown(int n){

        if (n != 0 && DP[n] == 0) DP[n] = topDown(n - 1) + topDown(n - 2);
        return DP[n] % sup;
    }
}
