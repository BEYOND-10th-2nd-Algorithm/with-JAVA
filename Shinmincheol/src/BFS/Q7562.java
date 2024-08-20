package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {

    static boolean[][] visited;
    static int[][] map;
    static Queue<Point> q;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {1, -1, 2, -2, 2, -2, 1, -1};
    static int l;
    static StringBuilder sb = new StringBuilder();

    private static class Point{
        int xPos;
        int yPos;
        public Point(int xPos, int yPos) {
            this.xPos = xPos;
            this.yPos = yPos;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){

            l = Integer.parseInt(br.readLine());//체스판의 한변의 길이
            visited = new boolean[l+1][l+1];
            map = new int[l+1][l+1];
            q = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            int srcXPos = Integer.parseInt(st.nextToken());
            int srcYPos = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int destXPos = Integer.parseInt(st.nextToken());
            int destYPos = Integer.parseInt(st.nextToken());


            BFS(srcXPos, srcYPos, destXPos, destYPos);




        }

        System.out.println(sb.toString().trim());



    }

    static void BFS(int srcXPos, int srcYPos, int destXPos, int destYPos){

        q.offer(new Point(srcXPos, srcYPos)); //시작위치
        visited[srcYPos][srcXPos] = true; //시작 정점을 방문처리

        while(!q.isEmpty()){
            Point cur = q.poll();
            int xpos = cur.xPos;
            int ypos = cur.yPos;

            if(xpos == destXPos && ypos == destYPos){
                sb.append(map[destYPos][destXPos]).append("\n"); //최단길이 출력하기
                break;
            }


            for(int i=0; i<8; i++){ //탐색 8방위
                int newXPos = xpos + dx[i];
                int newYPos = ypos + dy[i];
                if(newXPos>=0 && newYPos>=0 && newXPos<l && newYPos<l){
                    if(!visited[newYPos][newXPos]){
                        q.offer(new Point(newXPos, newYPos));
                        map[newYPos][newXPos] = map[ypos][xpos] + 1;
                        visited[newYPos][newXPos] = true; // 큐에 집어넣고 방문처리한다.

                    }
                }
            }
        }

    }

}
