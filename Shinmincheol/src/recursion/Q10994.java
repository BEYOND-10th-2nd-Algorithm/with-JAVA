package recursion;

import java.util.Scanner;

public class Q10994 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        recursive(n, sb);
        System.out.println(sb);




    }
    //4n+1
    //재귀함수
    public static void recursive(int n, StringBuilder sb) {

        if(n == 1) {sb.append("*");}
        else{

            sb.append("****");
            sb.append("\n");
            //if()
            sb.append("*");
            sb.append("    ");
            sb.append("*");



        }
    }
}
