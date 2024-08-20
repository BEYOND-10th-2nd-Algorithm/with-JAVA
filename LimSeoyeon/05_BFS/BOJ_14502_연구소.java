import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import static java.lang.Math.*;

public class Main {

    static int N, M;
    static boolean [][]visited;
    static int [][]arr;
    static int [][]copyArr;
    static ArrayList<Pair> blank = new ArrayList<>();
    static ArrayList<Pair> virus = new ArrayList<>();

    static int []dy = { 0,0,-1,1 };
    static int []dx = { -1,1,0,0 };

    public static class Pair{
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void setWall(int y1, int x1, int y2, int x2, int y3, int x3) {
        arr[y1][x1] = 1;
        arr[y2][x2] = 1;
        arr[y3][x3] = 1;
    }

    public static void init() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = copyArr[i][j];
                visited[i][j] = false;
            }
        }
    }


    public static void BFS(int y, int x) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(y,x));
        visited[y][x] = true;
        while (!q.isEmpty()) {
            int curY = q.peek().first;
            int curX = q.peek().second;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
                if (visited[nextY][nextX]) continue;
                if (arr[nextY][nextX] == 0) {
                    arr[nextY][nextX] = 2;
                    visited[nextY][nextX] = true;
                    q.offer(new Pair(nextY,nextX));
                }
            }
        }
    }

    public static int cntSafe() {
        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) safe++;
            }
        }

        return safe;
    }

        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M =scanner.nextInt();

        arr = new int[N+1][M+1];
        copyArr= new int[N+1][M+1];
        visited=new boolean[N+1][M+1];

        //1. 입력받은 그래프 정보 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = scanner.nextInt() ;
                copyArr[i][j] = arr[i][j];
                if (arr[i][j]==0) {
                    blank.add(new Pair(i,j));
                }
                if (arr[i][j] == 2) {
                    virus.add(new Pair(i,j));
                }
            }
        }

        int res = 0;

        for (int i = 0; i < blank.size(); i++) { // 최대 62
            for (int j = i+1; j < blank.size(); j++) {
                if (i == j) continue;
                for (int k = j+1; k < blank.size(); k++) {
                    if (i == k || j == k) continue;
                    int y1 = blank.get(i).first;
                    int x1 = blank.get(i).second;
                    int y2 = blank.get(j).first;
                    int x2 = blank.get(j).second;
                    int y3 = blank.get(k).first;
                    int x3 = blank.get(k).second;

                    setWall(y1,x1,y2,x2,y3,x3);

                    for (int l = 0; l < virus.size(); l++) {
                        BFS(virus.get(l).first, virus.get(l).second);
                    }

                    res = max(res,cntSafe());

                    init();

                }
            }
        }
        System.out.println(res);

    }
}
