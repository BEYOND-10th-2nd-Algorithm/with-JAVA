package recursion_function;

import java.util.Scanner;

public class Silver4_Q10994 {

    static String[][] stars;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
//        if (N == 1) System.out.println("*");
// 요놈을 써놓고 깜빡함..

        int length = 1;
        length += (N-1) * 4;

        stars = new String[length][length];

        for (int i = 0; i < length; i++){

            for (int j = 0; j < length; j++){
                stars[i][j] = " ";
            }
        }

//        stars[length / 2 + 1][length / 2 + 1] = "*";

        print(0, length);

        for (int i = 0; i < length; i++){

            for (int j = 0; j < length; j++){
                System.out.print(stars[i][j]);
            }
            System.out.println();
        }
    }


    static void print(int N, int length){

        for (int i = N; i < length; i++){
            stars[N][i] = "*";  // 첫번째 가로줄
            stars[i][N] = "*";  // 첫번째 세로줄

            stars[length-1][i] = "*";   // 마지막 가로줄
            stars[i][length-1] = "*";   // 마지막 세로줄
        }

        if (length == 1) return;

        print(N+2, length-2);

    }
}
