package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

// 파도반 수열 f(n) = f(n-2) + f(n-3)
public class Silver3_Q9461 {

    // 테스트 케이스 갯수
    static int T;

    // 메인
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        DP = new long[101];
        DP[1] = DP[2] = DP[3] = 1;

        T = Integer.parseInt(br.readLine());

        while (T-- > 0){
            int n = Integer.parseInt(br.readLine());

            topDown(n);
            sb.append(DP[n]).append("\n");
        }

        System.out.println(sb);

    }


    /* 탑 다운 방식*/
    static long[] DP;

    static long topDown(int n){
            if (DP[n] == 0) {
                DP[n] = topDown(n-2) + topDown(n-3);
            }
            return DP[n];
    }

    /* 바텀 업 방식*/
}
