package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int bridge_length = sc.nextInt();
        int weight = sc.nextInt();
        int n = sc.nextInt();
        int[] truck_weights = new int[n];
        for (int i = 0; i < n; i++) {
            truck_weights[i] = sc.nextInt();
        }

        System.out.println(solution(bridge_length, weight, truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<Integer>();


        int i = 0; // 순번
        int cnt = 0; // 현재 다리 트럭 개수

        int possibleWeight = weight;

        while (true) {

            //다리에 트럭 진입 가능
            if (truck_weights[i] <= possibleWeight && cnt < bridge_length) {

                queue.add(truck_weights[i]);
                possibleWeight -= truck_weights[i];
                answer += 1; // 시간 수정
                i++;
                cnt++;
                //맨 마지막 트럭이 들어갈 경우
                if (i == truck_weights.length) {
                    answer += bridge_length;
                    break;
                }

            }
            //대기해야 할 경우
            //얼마나 대기해야 할지
            //들어가고 나올때까지 얼마나 많은 시간적 지연이 발생하는가
            else if (truck_weights[i] > possibleWeight || cnt == bridge_length) {



                answer += 1;
                possibleWeight += queue.poll();
                cnt--;


                // 맨 앞에 있는 차량이 나올때까지 시간 추가
                // pair class 만들어서 해결해볼 것
            }


        }
        return answer;
    }
}

