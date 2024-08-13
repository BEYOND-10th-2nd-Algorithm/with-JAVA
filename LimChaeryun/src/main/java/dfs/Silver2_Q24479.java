package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Silver2_Q24479 {


    static List<Integer>[] Node;
    
    // 원래는 이렇게 해서 방문 기록을 했는데, 기본적으로 방문하지 않은 곳은 0으로 해야하기 때문에 타입을 변경
    // int는 자동으로 0으로 초기화됨
    // static boolean[] visit;
    
    static int[] visit;
    static int visitNode = 1;

    // 이렇게 되면 빌더가 필요 없어짐
//    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Node = new ArrayList[N+1];
        visit = new int[N+1];

        for (int i = 1; i <= N; i++) {
            Node[i] = new ArrayList<>();
        }

        while (M > 0){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            Node[A].add(B);
            Node[B].add(A);

            M--;
        }

        // 원래 stream을 사용해서 dfs에서 하려고 했으나, 백준은 자바 11을 사용해서 안되는듯..
        for (int i = 1; i <= N; i++){
            Collections.sort(Node[i]);
        }

        dfs(R);
        
        
//        sb.append(0);
//        System.out.print(sb);

        // 노드 최대 출력을 <로 해놔서 실패
        for (int i = 1; i <= N; i++){
            System.out.println(visit[i]);
        }

//        System.out.println(sb);
    }

    static void dfs(int N){
        // 방문순서 저장
        visit[N] = visitNode++;
//        sb.append(N).append("\n");


        // 정렬 두 가지 방법 시도..
        // Node[N].stream().sorted().collect(Collectors.toList())
        // Node[N].stream().sorted().toList()

        for (int next : Node[N]){

            if (visit[next] == 0){
                dfs(next);
            }
        }
    }

















    // === 기존 코드 === //
//    static boolean[][] Node;
//    static boolean[] visit;
//    static StringBuilder sb = new StringBuilder();
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//
//
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int R = Integer.parseInt(st.nextToken());
//
//        Node = new boolean[N+1][N+1];
//        visit = new boolean[N+1];
//
//        while (M > 0){
//            int A = Integer.parseInt(st.nextToken());
//            int B = Integer.parseInt(st.nextToken());
//
//            Node[A][B] = true;
//            Node[B][A] = true;
//            M--;
//        }
//
//        dfs(R);
//        sb.append(0);
//        System.out.println(sb);
//
//    }
//
//    static void dfs(int N){
//        visit[N] = true;
//
//        for (int i = 1; i < Node.length; i++){
//
//            if (Node[N][i] && !visit[i]){
//                visit[i] = true;
//                sb.append(i).append("\n");
//
//                dfs(i);
//            }
//        }
//    }


}
