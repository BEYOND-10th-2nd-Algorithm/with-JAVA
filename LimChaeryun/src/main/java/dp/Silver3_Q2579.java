package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3_Q2579 {
    static int[] arr;
    static long[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        DP = new long[N+1];

        for (int i = 1; i < arr.length; i++){
            int line = Integer.parseInt(br.readLine());

            arr[i] = line;
        }

        DP[1] = arr[1];
        if (N >= 2) DP[2] = DP[1] + arr[2];
        // 점화식은 3번 계단부터 적용
        // 한 계단 전의 개념은 연달아 세 번 밟을 수 없음에 유의
        for (int i = 3; i <= N; i++){

            // 가능 상황 1. 직전 계단에서 올라오는 경우 - 연달아 밟지 않아야 하므로 i-3 -> i-1 로 이동해야함
            // 가능 상황 2. 두 계단 전에서 올라오는 경우 - i-2 전의 상황을 고려하지 않아도 됨
            // 1번 : DP[i-3] + arr[i-1] vs 2번 : DP[i-2]를 비교해서 더 큰 값과 현재 계단의 값을 더하면 최적값 누적
            DP[i] = Math.max(DP[i-2], DP[i-3] + arr[i-1]) + arr[i];

        }

        System.out.println(DP[N]);
    }
}
