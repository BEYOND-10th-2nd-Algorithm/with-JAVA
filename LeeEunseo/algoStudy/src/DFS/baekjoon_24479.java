package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 해결해야 할 점 : 오름차순, 방문할 수 없는 경우 0 처리

public class baekjoon_24479 {
    // 1 : 4 -> 2
    // 2 : 3 -> 4
    // 3 : 2 -> 4
    // 4 : 1 -> 2 -> 3
    // 5 :

    static ArrayList<Integer>[] arr;    // 그래프를 저장할 ArrayList 배열 선언
    static boolean visited[];   // 한 노드가 이미 방문한 노드임을 저장할 boolean 배열 선언

    public static void dfsR(int node) throws IOException {
        // 노드를 방문했음을 저장
        visited[node] = true;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 방문한 노드 출력
        bw.write(node + "\n");
        bw.flush();


        // 자식 노드를 방문하기
            // 노드의 ArrayList에 있는 자식 노드들을 방문
        for (int i = 0; i < arr[node].size(); i++) {

            int kid = arr[node].get(i); // 자식 노드 찾기

            // 자식 노드가 이미 방문한 노드가 아니면
            if (!visited[kid]) {
                dfsR(kid);  // 자식 노드의 자식 노드 호출 위함
            }
        }
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            // 첫 줄 입력 받아 노드 수, 간선 수, 첫 번째 노드 저장
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st1.nextToken());
            int edgeNum = Integer.parseInt(st1.nextToken());
            int first = Integer.parseInt(st1.nextToken());
            System.out.println(nodeNum + " " + edgeNum + " " + first);

            arr = new ArrayList[nodeNum + 1];  // ArrayList 배열 선언, 할당
            // ArrayList 배열 초기화
            for (int i = 1; i <= nodeNum; i++) {
                arr[i] = new ArrayList<>();
            }

            // visited 배열 선언, 할당
            visited = new boolean[nodeNum + 1];

            // 다음 줄 입력 받아 ArrayList 배열에 넣기
            for (int i = 1; i <= edgeNum; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st2.nextToken());
                int child = Integer.parseInt(st2.nextToken());
                arr[parent].add(child);
                arr[child].add(parent);

            }

            //ArrayList 값 확인용
            for (int i = 1; i <= nodeNum; i++) {
                System.out.print("노드 " + i + " : ");
                for (int j = 0; j < arr[i].size(); j++) {
                    System.out.print(arr[i].get(j) + " ");
                }
                System.out.println("");
            }

            dfsR(first);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
