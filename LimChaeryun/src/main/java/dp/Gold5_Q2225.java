package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 합분해
public class Gold5_Q2225 {

    static long[][] DP;
    static long sup = 1000000000;
    static int N, K;

    /* 점화식 -> DP[N][K] = DP[N-1][K] + DP[N][K-1] */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        K = Integer.parseInt(line[1]);

        DP = new long[N+1][K+1];

        for (int i = 0; i <= N; i++){
            DP[i][0] = 0;
            DP[i][1] = 1;
        }

        for (int i = 0; i <= K; i++){
            DP[1][i] = i;
        }

        dp();

        System.out.println(DP[N][K]);
    }

    // 출력문에 %를 하면 왜 틀리지.?
    static void dp(){

        for (int i = 2; i <= N; i++){
            for (int j = 2; j <= K; j++){
                DP[i][j] = (DP[i-1][j] + DP[i][j-1]) % sup;

            }
        }
    }
}
