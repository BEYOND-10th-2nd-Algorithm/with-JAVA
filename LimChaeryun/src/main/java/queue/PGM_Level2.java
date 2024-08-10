package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PGM_Level2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;


        for(int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while(true) {

                if(queue.isEmpty()) {
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                } else if(queue.size() == bridge_length) {
                    sum -= queue.poll();
                } else  {

                    if(sum + truck <= weight) {
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else {

                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}

/**
 * solution 함수의 매개변수로 다리에 올라갈 수 있는 트럭 수 bridge_length,
 * 다리가 견딜 수 있는 무게 weight, 트럭 별 무게 truck_weights가 주어집니다.
 * 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.
 */