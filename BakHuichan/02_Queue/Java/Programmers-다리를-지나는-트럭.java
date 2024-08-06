import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridgeQ = new LinkedList<>();
        int[] result = new int[truck_weights.length];
        int bridgeWeight = 0;
        int time = 0;
        int index = 0;
        int tIndex = 0;

        for (int i = 0; i < bridge_length; i++)
            bridgeQ.offer(-1);

        while (true) {
            time++;

            if (bridgeQ.peek() == -1)
                bridgeQ.poll();
            else {
                bridgeWeight -= bridgeQ.peek();
                result[tIndex] = bridgeQ.poll();
                tIndex++;
            }

            if (index == truck_weights.length) {}
            else if (bridgeWeight + truck_weights[index] <= weight) {
                bridgeQ.offer(truck_weights[index]);
                bridgeWeight += truck_weights[index];
                index++;
            } else
                bridgeQ.offer(-1);
            
            if (tIndex == truck_weights.length)
                break;
        }

        return time;
    }
}
