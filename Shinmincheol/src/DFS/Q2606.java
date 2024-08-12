package DFS;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q2606 {

    static int cnt;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    static int n,m;

    public static void main(String[] args) {

        //세팅
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());//노드의 수
        m = Integer.parseInt(sc.nextLine());// 간선의 수
        //Scanner 클래스의 nextInt 메소드를 사용할 경우 오류 발생.

        list = new ArrayList[n+1];
        for(int i = 0; i < n+1; i++) list[i] = new ArrayList<>();
        visited = new boolean[n+1];


        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[u].add(v);
            list[v].add(u);
        }


        DFS(1);
        System.out.println(cnt-1); //1번 컴퓨터에 의해 감염된 컴퓨터의 수를 구하는 것이므로 -1


    }

    static void DFS(int curNode) {

        visited[curNode] = true; // 노드에 방문 표시
        cnt++; //윔 바이러스에 걸린 컴퓨터 수 추가
        for(int i=0; i<list[curNode].size(); i++) {
            int nextNode = list[curNode].get(i);
            if(!visited[nextNode]) DFS(nextNode);
        }
    }
}
