package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 컴퓨터 : 100 이하의 양의 정수
// 각 컴퓨터는 1번부터 차례로 번호 매김
// 컴퓨터 쌍의 수

public class baekjoon_2606 {

    static ArrayList<Integer>[] arr;  // 그래프를 저장할 ArrayList 배열
    static boolean visited[];   // 해당 노드를 방문했는지 저장할 boolean 배열
    static int cnt;

    public static void dfsR(int node) {
        visited[node] = true;
        cnt++;

        for (int i = 0; i < arr[node].size(); i++) {
            int kid = arr[node].get(i); // 자식 노드 찾기

            if (!visited[kid]) {
                dfsR(kid);  // 자식 노드의 자식 노드 호출 위함
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeNum = Integer.parseInt(br.readLine());   // 노드 수 (컴퓨터 수)
        int edgeNum = Integer.parseInt(br.readLine());  // 엣지 수 (직접 연결되어 있는 컴퓨터 번호 쌍의 수)


        arr = new ArrayList[nodeNum + 1];   // 노드 번호는 1번부터 시작함
        // 노드: 1 ~ 7 이면 ArrayList[8]

        // ArrayList 초기화 (0은 비워 둠 = null)
        for (int i = 1; i <= nodeNum; i++) {
            arr[i] = new ArrayList<>();
        }

        visited = new boolean[nodeNum + 1]; // 노드 배열과 인덱스를 맞추기 위해 1 추가 (0은 비우고 1부터 시작)

        // 엣지 입력 받기
        for (int i = 1; i <= edgeNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            arr[parent].add(child);
            arr[child].add(parent); // 무방향 그래프

        }



        cnt = 0;
        dfsR(1);

        bw.write(Integer.toString(cnt - 1));  // 1번 제외


        bw.flush();
        bw.close();


    }
}
