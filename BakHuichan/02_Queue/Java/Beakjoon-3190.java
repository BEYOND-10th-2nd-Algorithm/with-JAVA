import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mapSize = sc.nextInt();
        int[][] map = new int[mapSize + 2][mapSize + 2];
        Queue<Point> snake = new LinkedList<Point>();
        snake.offer(new Point(1, 1));
        int time = -1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (i == 0 || j == 0 || i == mapSize + 1 || j == mapSize + 1) {
                    map[i][j] = -1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        int apple = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < apple; i++) {
            String[] tmp = sc.nextLine().split(" ");
            map[Integer.parseInt(tmp[0])][Integer.parseInt(tmp[1])] = 2;
        }

        Queue<String[]> turn = new LinkedList<>();

        int[] goX = {0, -1, 0, 1};
        int[] goY = {1, 0, -1, 0};
        int head = 0;
        int nextX = 0;
        int nextY = 0;
        Point headFront = new Point(1, 1);
        int turnCount = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < turnCount; i++) {
            turn.offer(sc.nextLine().split(" "));
        }
        map[headFront.x][headFront.y] = 1;

        while(true) {
            time++;

            if (turn.isEmpty()) {}
            else if (Integer.parseInt(turn.peek()[0]) == time) {
                if (turn.peek()[1].equals("D")) {
                    head = head - 1;
                    if (head < 0) head += 4;
                } else {
                    head = head + 1;
                    if (head > 3) head -= 4;
                }
                turn.poll();
            }

            nextX = headFront.x + goX[head];
            nextY = headFront.y + goY[head];

            snake.offer(new Point(nextX, nextY));
            headFront = new Point(nextX, nextY);

            if (map[nextX][nextY] == 2) {
            } else if (map[nextX][nextY] == -1) {
                time++;
                break;
            } else if (map[nextX][nextY] == 1) {
                time++;
                break;
            } else {
                Point tmp = snake.poll();
                map[tmp.x][tmp.y] = 0;
            }

            map[nextX][nextY] = 1;
        }

        System.out.println(time);
    }
}
