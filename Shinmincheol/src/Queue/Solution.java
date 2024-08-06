package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        int n = sc.nextInt();
        int[] truck_weights = new int[n];

        for(int i=0;i<n; i++){
            truck_weights[i] = sc.nextInt();
        }

        System.out.println(solution(bridge_length, weight, truck_weights));

    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        //다리의 무게를 계속 체크해야함
        //대기 -> 다리 1초
        //다리 -> 2초
        Queue<Integer> queue = new LinkedList<Integer>();




        return answer;
    }
}