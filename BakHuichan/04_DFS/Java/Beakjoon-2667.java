import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    static int depth = 0;
    static int count = 0;
    static int[] countList = new int[625];

    public static void aptGroup (int x, int y) {
        if (map[x][y] == -1) {
            if (depth == 0)
                count += 1;
            
            countList[count] += 1;
            map[x][y] = count;

            for (int i = 0; i < 4; i++) {
                int nextX = x + dX[i];
                int nextY = y + dY[i];
                if (nextX < 0 | nextX >= map.length | nextY < 0 | nextY >= map.length)
                    continue;
                else {
                    depth += 1;
                    aptGroup(nextX, nextY);
                    depth -= 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mapSize = Integer.parseInt(sc.nextLine());
        map = new int[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < mapSize; j++) {
                if (tmp.charAt(j) == '0') map[i][j] = 0;
                else map[i][j] = -1;
            }
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                aptGroup(i, j);
            }
        }

        int[] result  = new int[count];

        for (int i = 1; i <= count; i++) {
            result[i - 1] = countList[i];
        }

        Arrays.sort(result);
        System.out.println(result.length);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
