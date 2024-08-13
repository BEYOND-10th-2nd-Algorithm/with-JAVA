import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] graph;
    static boolean[] visited;
    static int N;
    static boolean[] res;

    static boolean dfs(int node, int st) {
        if(visited[node]){
            if(node==st) return true;
            else return false;
        }
        visited[node] = true;
        int nextNode = graph[node];
        return dfs(nextNode, st);
    }

    static void init(){
        for(int i=1; i<=N; i++){
            visited[i]=false;
        }
    }

    static void copyVisited(){
        for(int i=1; i<=N; i++) {
            if (visited[i]&&!res[i]){
                res[i]=true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(bf.readLine());
        //배열 선언
        graph = new int[N+1];
        visited = new boolean[N+1];
        res= new boolean[N+1];
        for(int i=1; i<=N; i++){
            graph[i]= Integer.parseInt(bf.readLine());
        }
        for(int i=1; i<=N; i++){
            if(dfs(i,i)) copyVisited();
            init();
        }
        int cnt=0;
        for(int i=1; i<=N; i++){
            if(res[i]) cnt++;
        }
        System.out.println(cnt);
        for(int i=1; i<=N; i++){
            if(res[i]) {
                System.out.println(i);
            }
        }
    }

}
