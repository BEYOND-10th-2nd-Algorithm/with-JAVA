package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 평범한 배낭
public class Gold5_Q12865 {

    static int[][] DP;
    static int[] W;     // 각 물건의 무게
    static int[] V;     // 각 물건의 가치

    static int N, K;    // 물품 수, 버틸 수 있는 무게

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        W = new int[N];
        V = new int[N];

        DP = new int[N][K+1];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");

            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dp(N-1, K));


    }

    static int dp(int n, int k){
        if (n < 0) return 0;

        if (DP[n][k] == 0){

            if (W[n] > k){
                DP[n][k] = dp(n-1, k);
            } else {
                DP[n][k] = Math.max(dp(n-1, k), dp(n-1, k-W[n]) + V[n]);
            }
        }

        return DP[n][k];
    }
}
