import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> cardQ = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        boolean drop = true;

        for (int i = 1; i <= num; i++) {
            cardQ.offer(i);
        }

        while (cardQ.size() > 1) {
            int tmp = 0;
            if (drop) {
                cardQ.poll();
                drop = false;
            } else {
                tmp = cardQ.poll();
                cardQ.offer(tmp);
                drop = true;
            }
        }

        System.out.println(cardQ.poll());
    }
}
