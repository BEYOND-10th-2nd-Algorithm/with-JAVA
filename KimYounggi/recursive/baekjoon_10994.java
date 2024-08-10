import java.util.Scanner;

public class baekjoon_10994 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();
        n = 4 * (n - 1) + 1;

        char[][] arr = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }

        recursive(n, 0, arr);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void recursive(int size, int start, char[][] arr) {
        if (size <= 0) {
            return;
        }

        for (int i = start; i < size; i++) {
            arr[start][i] = '*';
            arr[i][start] = '*';
            arr[i][size - 1] = '*';
            arr[size - 1][i] = '*';
        }

        recursive(size -2, start + 2, arr);
    }
}
