package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 주유소 - 서브태스크
public class Silver3_Q13305 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());

        int[] dist = new int[N -1];
        int[] cost = new int[N];

        String[] line = br.readLine().split(" ");

        for (int i = 0; i < line.length; i++){
            dist[i] = Integer.parseInt(line[i]);
        }

        String[] costLine = br.readLine().split(" ");

        for (int i = 0; i < costLine.length; i++){
            cost[i] = Integer.parseInt(costLine[i]);
        }

        long sum = 0;
        int minCost = cost[0];

        for (int i = 0; i < N-1; i++){

            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (long) minCost * dist[i];
        }

        System.out.println(sum);
    }
}
