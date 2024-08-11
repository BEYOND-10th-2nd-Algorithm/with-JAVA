package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class baekjoon_24479 {
    // 1 : 4 -> 2
    // 2 : 3 -> 4
    // 3 : 2 -> 4
    // 4 : 1 -> 2 -> 3
    // 5 :

    // 문제 잘못 이해 함!
    // dfs 호출 될 때마다 해당 노드 번호를 출력하는 줄 알았는데,
    // 그게 아니라 각 노드의 호출 순서를 출력하는 문제였다! \oㅁ0/!!

    static ArrayList<Integer>[] arr;    // 그래프를 저장할 ArrayList 배열 선언
    static boolean visited[];   // 한 노드가 이미 방문한 노드임을 저장할 boolean 배열 선언
    static BufferedWriter bw;   // BufferedWriter가 main, dfsR 함수에서 둘다 필요하므로 전역 변수로 선언함

    static int visitedOrder[];  // 노드의 방문 순서를 저장하기 위한 배열
    static int order;   // 노드의 방문 순서를 카운트 하기 위한 배열

    public static void dfsR(int node) throws IOException {
        // 노드를 방문했음을 저장
        visited[node] = true;
        order++;    // visitedOrder[node] = order++ 하면 안 됨! 후위 연산자이므로 visitedOrder[node]에 증가되지 않은 값이 들어감
        visitedOrder[node] = order;


        // 자식 노드를 방문하기
            // 노드의 ArrayList에 있는 자식 노드들을 방문
        for (int i = 0; i < arr[node].size(); i++) {

            int kid = arr[node].get(i); // 자식 노드 찾기
            // 자식 노드가 없으면 ( 이건 해당 노드의 값이 어쨌든 들어가야 함. 난 5를 넣지 않으니까 안 됨)

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

            // visited, visitedOrder 배열 선언, 할당
            visited = new boolean[nodeNum + 1]; // 노드가 0이 아니라 1부터 시작함
            visitedOrder = new int[nodeNum + 1];
            order = 0;

            // 다음 줄 입력 받아 ArrayList 배열에 넣기
            for (int i = 1; i <= edgeNum; i++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st2.nextToken());
                int child = Integer.parseInt(st2.nextToken());
                arr[parent].add(child);
//                System.out.println("arr[parent].add(child) : " + arr[parent].get(child));
                // arr[i]는 1부터 시작하지만 ArrayList의 인덱스는 0부터 시작함! arr[1].get(0)~ arr[i].get
//                System.out.println("arr[parent] : " + arr[parent]); // 레퍼런스 변수명으로 출력
                arr[child].add(parent);
//                System.out.println("arr[child].add(parent) : " +arr[child].get(parent));
//                System.out.println("arr[child] : " + arr[child]);

            }

            for (int i = 1; i <= nodeNum; i++) {
                Collections.sort(arr[i]);   // ArrayList를 오름차순으로 정렬
            }
            System.out.println("arr 출력\n");
            for (int i = 1; i <= nodeNum; i++) {
                System.out.println(arr[i]);;
            }

            bw = new BufferedWriter(new OutputStreamWriter(System.out));


            dfsR(first);

            for (int i = 1; i <= nodeNum; i++) {
                // 해당 노드에 방문한 적이 없으면 0 출력
                if (!visited[i]) {
                    bw.write("0\n");
                } else {
                    // 노드 방문 순서 출력
                    bw.write(visitedOrder[i] + "\n");   // bw.write는 String 필요
                }
            }


            bw.flush(); // 잊지 말기!!
            bw.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
