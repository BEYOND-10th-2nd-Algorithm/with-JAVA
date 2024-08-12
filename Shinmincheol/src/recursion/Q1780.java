package recursion;

import java.util.Scanner;

public class Q1780 {

    static int[] cnt = new int[3];
    static boolean[][] visited;
    static int[][] arr;


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 각 종이를 순회하면서 같은 수로 되어 있다면 재귀탐색x
        // 같은 수가 아니라면 재귀적으로 쪼개고 탐색
        // 처음 배열은 하나 만들고 탐색만 재귀적으로
        // 이미 탐색을 했을 경우 다시 탐색할 필요가 없음. boolean 배열 사용

        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1]; // 탐색 여부를 확인할 배열

        // 배열에 값 넣기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                System.out.print(arr[i][j] + " ");
            }
        }


    }

    // 매 재귀마다 n/3, n/3 씩 쪼개야 함
    public static void recursiveSearch(int n){

            for(int i =0; i <3; i++){
                for(int j = 0; j < 3; j++){
                  //  recursiveSearch(i * (n / 3), j * (n / 3));
                }
            }

    }

}
