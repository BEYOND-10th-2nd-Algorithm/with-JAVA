package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_24479 {

    static ArrayList<Integer>[] arr;    // 그래프를 저장할 ArrayList 배열 선언
    static boolean[] visited;   // 한 노드가 이미 방문한 노드임을 저장할 boolean 배열 선언
    static BufferedWriter bw;   // BufferedWriter가 main, dfsR 함수에서 둘다 필요하므로 전역 변수로 선언

    static int[] visitedOrder;  // 노드의 방문 순서를 저장하기 위한 배열
    static int order;   // 노드의 방문 순서를 카운트하기 위한 변수

    public static void dfsR(int node) throws IOException {
        visited[node] = true;
        order++;
        visitedOrder[node] = order;

        for (int i = 0; i < arr[node].size(); i++) {
            int kid = arr[node].get(i); // 자식 노드 찾기

            if (!visited[kid]) {
                dfsR(kid);  // 자식 노드의 자식 노드 호출 위함
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeNum = Integer.parseInt(st.nextToken());    // 노드 수
            int edgeNum = Integer.parseInt(st.nextToken());    // 엣지 수
            int first = Integer.parseInt(st.nextToken());  // 시작 노드

            arr = new ArrayList[nodeNum + 1];   // 노드 번호가 1 이상인 정수(0번 인덱스는 사용하지 않을 계획)

            // ArrayList 초기화
            for (int i = 1; i <= nodeNum; i++) {
                arr[i] = new ArrayList<>();
            }

            visited = new boolean[nodeNum + 1];
            visitedOrder = new int[nodeNum + 1];
            order = 0;

            // 노드 연결 관계 입력 받기
            // 이 부분에서 계속 틀렸는데 어쩌다 고쳤는지 모르겠다...
            for (int i = 1; i <= edgeNum; i++) {
                st = new StringTokenizer(br.readLine());

                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                arr[parent].add(child);
                arr[child].add(parent); // 무방향 그래프
            }



            for (int i = 1; i <= nodeNum; i++) {
                Collections.sort(arr[i]);   // ArrayList를 오름차순으로 정렬
            }

            bw = new BufferedWriter(new OutputStreamWriter(System.out));

            dfsR(first);  // 시작 노드에서 DFS 시작

            // 노드 번호 당 호출 순서 출력
            for (int i = 1; i <= nodeNum; i++) {
                if (!visited[i]) {
                    bw.write("0\n");
                } else {
                    bw.write(visitedOrder[i] + "\n");
                }
            }

            bw.flush();
            bw.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
