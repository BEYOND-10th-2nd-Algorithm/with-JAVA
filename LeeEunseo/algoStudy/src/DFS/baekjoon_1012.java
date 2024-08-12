package DFS;

import java.io.*;
import java.util.StringTokenizer;

public class baekjoon_1012 {

    static int[][] graph;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseNum = Integer.parseInt(br.readLine());  // 테스트 케이스 수
        System.out.println("caseNum : " + caseNum);

        // 테스트 케이스 마다 반복
        for (int a = 0; a < caseNum; a++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int width = Integer.parseInt(br.readLine());    // 가로 길이
            int height = Integer.parseInt(br.readLine());   // 세로 길이
            int cabbageNum = Integer.parseInt(br.readLine());   // 배추 개수

            System.out.println("가로 : " + width + "세로: " + height + "배추 수: " + cabbageNum);

            graph = new int[width + 1][height + 1];

            // 2차원 배열 graph 0으로 초기화
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    graph[i][j] = 0;
                }
            }

            // 2차원 배열 확인용
            System.out.println("=====배추 심기 전=====");
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    System.out.println(graph[i][j]);
                }
            }

            // 2차원 배열에 값 넣기
            for (int j = 1; j <= cabbageNum; j++) { // 인덱스 1부터 시작하기 위해
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                graph[x][y] = 1;    // 배추가 있는 위치를 1로 변경
            }

            // 2차원 배열 확인용
            System.out.println("=====배추 심은 후=====");
            for (int i = 1; i < graph.length; i++) {
                for (int j = 1; j < graph.length; j++) {
                    System.out.println(graph[i][j]);
                }
            }
        }

    }
}
