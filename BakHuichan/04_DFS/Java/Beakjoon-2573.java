import java.util.Scanner;

public class Main {
    static byte[][] beforeMap;
    static byte[][] afterMap;
    static byte[] dX = {1, -1, 0, 0};
    static byte[] dY = {0, 0, 1, -1};
    static int sizeX;
    static int sizeY;
    static int island = 0;
    static int depth = 0;
    static int year = 0;
    static boolean noIce = false;

    public static void warming() {
        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                if (beforeMap[x][y] > 0) {
                    int hot = 0;
                    for (int i = 0; i < 4; i++) {
                        int newX = x + dX[i];
                        int newY = y + dY[i];

                        if (newX < 0 | newX >= sizeX | newY < 0 | newY >= sizeY)
                            continue;
                        if (beforeMap[newX][newY] == 0)
                            hot++;
                    }
                    afterMap[x][y] -= hot;
                    if (afterMap[x][y] < 0) afterMap[x][y] = 0;
                }
            }
        }
        for (int i = 0; i < sizeX; i++) {
            beforeMap[i] = afterMap[i].clone();
        }
    }

    public static void iceAge(int x, int y) {
        if (afterMap[x][y] > 0) {
            if (depth == 0) island += 1;
            afterMap[x][y] = -1;

            for (int i = 0; i < 4; i++) {
                int newX = x + dX[i];
                int newY = y + dY[i];
                if (newX < 0 | newX >= sizeX | newY < 0 | newY >= sizeY)
                    continue;
                if (afterMap[newX][newY] > 0) {
                    depth += 1;
                    iceAge(newX, newY);
                    depth -= 1;
                }
            }
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mapSize = sc.nextLine().split(" ");
        sizeX = Integer.parseInt(mapSize[0]);
        sizeY = Integer.parseInt(mapSize[1]);

        beforeMap = new byte[sizeX][sizeY];
        afterMap = new byte[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {
            String[] tmp = sc.nextLine().split(" ");
            for (int j = 0; j < tmp.length; j++) {
                beforeMap[i][j] = (byte) Integer.parseInt(tmp[j]);
            }
        }

        for (int i = 0; i < sizeX; i++) {
            afterMap[i] = beforeMap[i].clone();
        }
        
        while(!noIce) {
            year += 1;
            warming();
            for (int i = 0; i < sizeX; i++) {
                for (int j = 0; j < sizeY; j++) {
                    iceAge(i, j);
                }
            }

            for (int i = 0; i < sizeX; i++) {
                afterMap[i] = beforeMap[i].clone();
            }
            if (island == 0) noIce = true;
            else if (island > 1) break;
            island = 0;
        }

        System.out.println(noIce ? 0 : year);
    }
}
