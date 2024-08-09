import java.util.Scanner;

public class Main {
    static int idx = 0;
    static int N;
    static boolean flag = false;

    public static void recursion(int n) {
        if (n == 0) {
            if (idx == N) {
                System.out.println('m');
                flag = true;
                return;
            } else if (idx + 1 == N || idx + 2 == N) {
                System.out.println('o');
                flag = true;
                return;
            } else {
                idx += 3;
            }
            return;
        }
        recursion(n - 1);
        if (flag) return;

        if (idx == N) {
            System.out.println('m');
            flag = true;
            return;
        } else if (idx + 1 <= N && idx + n + 3 > N) {
            System.out.println('o');
            flag = true;
            return;
        } else {
            idx += n + 3;
        }
        recursion(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        N = N - 1;
        int cnt = 3;
        int i = 0;
        while (cnt <= N) {
            cnt = cnt * 2 + (i + 3);
            i++;
        }
        recursion(i);
    }
}
