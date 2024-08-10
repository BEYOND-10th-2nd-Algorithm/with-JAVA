package DFS;

/*
*   재귀를 이용한 깊이 우선 탐색
*   입력1(노드 수) : 5
*   출력 : 1 2 4 3 5
*
*     1
*   /   \
*   2   3
*   |   |
*   4   5
*
*/

import java.util.ArrayList;
import java.util.Scanner;

public class sample {
    static ArrayList<Integer>[] graph;  // 그래프를 저장할 ArrayList 배열 선언
    static boolean[] visited;   // 한 노드가 이미 방문한 노드인지 저장할 boolean 배열 선언 (기본값 false)


    public static void dfs(int Node){
        // 해당 노드를 방문했다고 저장
        visited[Node] = true;
        // 방문한 노드 자신을 출력
        System.out.print(Node + " ");

        // 해당 노드의 자식 노드를 방문
        for (int i = 0; i < graph[Node].size(); i++) {
            // 해당 노드의 ArrayList 배열에 있는 자식 노드들을 방문한다
            // ex) 노드 1 : 2 -> 3 인 경우 2, 3을 차례로 방문

            int neighbor = graph[Node].get(i);  // 노드의 ArrayList 배열에서 자식 노드를 가져온다.

            if(!visited[neighbor]){
                // 자식 노드의 자식 노드를 방문하기 위해 dfs 재귀 호출
                dfs(neighbor);
            }


        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 노드 수 입력 받기
        System.out.print("노드 수: ");
        int nodeNum = sc.nextInt();

        // ArrayList 배열 할당
        graph = new ArrayList[nodeNum + 1];
        // boolean 배열 할당
        visited = new boolean[nodeNum + 1];

        // 노드가 1부터 시작하므로 graph[0]은 비워둔다.
        // 노드가 1부터 시작하므로 visited의 0번째 인덱스는 비운다
        // visited[] = [ ][true][true][false][false] 이런 식.

        // ArrayList 배열의 각 요소 초기화
        for (int i = 1; i <= nodeNum; i++) {
            graph[i] = new ArrayList<>();
        }

        // ArrayList 배열에 그래프를 저장
        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(1);
        graph[2].add(4);
        graph[3].add(1);
        graph[3].add(5);
        graph[4].add(2);
        graph[5].add(3);

        // 노드 1부터 시작하므로 1 전달
        dfs(1);

    }
}


