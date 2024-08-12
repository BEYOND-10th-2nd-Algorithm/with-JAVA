import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dX = {1, -1, 0, 0};
    static int[] dY = {0, 0, 1, -1};
    
    public static void bugGeneration(int[] point) {
        int searchX = point[0];
        int searchY = point[1];
        if (map[searchX][searchY] == 1)
            map[searchX][searchY] = 2;
        
        for (int i = 0; i < 4; i++) {
            int[] tmp = {point[0] + dX[i], point[1] + dY[i]};

            if (tmp[0] < 0 || tmp[0] >= map.length || tmp[1] < 0 || tmp[1] >= map[0].length)
                continue;
            else if (map[tmp[0]][tmp[1]] == 1)
                bugGeneration(tmp);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < testCase; i++) {
            String[] tmp = sc.nextLine().split(" ");
            int mapX = Integer.parseInt(tmp[0]);
            int mapY = Integer.parseInt(tmp[1]);
            int count = 0;
            map = new int[mapX][mapY];

            for (int j = 0; j < Integer.parseInt(tmp[2]); j++) {
                String[] bechu = sc.nextLine().split(" ");
                map[Integer.parseInt(bechu[0])][Integer.parseInt(bechu[1])] = 1;
            }
            
            for (int j = 0; j < map.length; j++) {
                for (int k = 0; k < map[0].length; k++) {
                    int[] point = {j, k};
                    if (map[j][k] == 1) {
                        count++;
                        bugGeneration(point);
                    }
                }
            }
            
            System.out.println(count);   
        }
    }
}
