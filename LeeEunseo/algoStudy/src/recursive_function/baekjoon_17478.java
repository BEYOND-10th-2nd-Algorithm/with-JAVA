package recursive_function;

import java.util.Scanner;

public class baekjoon_17478 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        recursive(input, "");
    }

    public static void recursive(int n, String underbar) {
        System.out.println(underbar + "\"재귀함수가 뭔가요?\"");

        if (n == 0) {
            System.out.println(underbar + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        } else {
            System.out.println(underbar + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(underbar + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(underbar + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            recursive(n - 1, underbar + "____");
        }
        System.out.println(underbar + "라고 답변하였지.");
    }
}

/* 문제 이해

* '어느 날 한 컴퓨터 공학과 학생이~' 는 1번만 출력됨
* '재귀함수가 뭔가요?', '잘 들어보게~', '마을 사람들은~', '그의 답은 대부분~' 은 함께 출력됨
* '재귀함수가 뭔가요?', '재귀함수는 자기 자신을~'은 함께 종료 시 출력됨
* 재귀 함수를 호출한 후 '~라고 답변하였지'를 출력함
* 재귀 함수 호출할 때마다 언더바가 4개씩 추가됨 -> repeat로 추가하려고 했으나 재귀할 때마다 언더바 상태를 기록 못 함
* */
