import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Pair{
        int first,second;
        Pair(int first, int second){
            this.first=first;
            this.second=second;
        }
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(stk.nextToken());

        int [][] arr = new int[N+5][N+5]; //보드판 배열
        int []dy = {0,-1,0,1}; //y축 방향 배열
        int []dx = {1,0,-1,0}; //x축 방향 배열

        for(int i=0; i<M; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            arr[a][b]=1; //사과 위치 1로 표시
        }
        stk = new StringTokenizer(br.readLine());
        int orderNum = Integer.parseInt(stk.nextToken());
        Queue<Pair> order = new LinkedList<>();
        Queue<Pair> q = new LinkedList<>();

        for(int i=0; i<orderNum; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            char b = stk.nextToken().charAt(0);
            if(b=='L'){
                order.add(new Pair(a,1));
            }
            else{
                order.add(new Pair(a,-1));
            }
        }

        int curY = 1, curX = 1;
        int res = 0; //시간 초
        int dirNum = 0;
        
        q.add(new Pair(1,1));

        while(true){
            //1. 다음에 움직일 방향 설정
            if(!order.isEmpty()&& order.peek().first==res){
                dirNum +=order.peek().second;
                if(dirNum<0) dirNum=3;
                if(dirNum>3) dirNum=0;
                order.poll();
            }

            curY+=dy[dirNum];
            curX+=dx[dirNum];

            if(curY<1|| curX<1 || curY >N || curX > N|| arr[curY][curX]==2){
                res+=1; //다음 초에 게임 종료됨. 지금은 움직이기 전이기 때문.
                break;
            }

            if(arr[curY][curX]==0) { //사과 없을 때 - 꼬리 없애기
                int delY = q.peek().first;
                int delX = q.peek().second;
                arr[delY][delX]=0;
                q.poll();
            }
            q.add(new Pair(curY,curX));
            arr[curY][curX]=2;

            res++;
        }

        System.out.println(res);
    }

}
