package Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Process {

    public static void main(String[] args){


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] priorities = new int[n];
        for(int i=0; i<n; i++){
            priorities[i] = sc.nextInt();
        }
        int location = sc.nextInt();
        System.out.println(solution(priorities, location));

    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        // 큐에서 순서대로 꺼내되, 우선순위를 비교해야 함
        // 우선순위 max만 체크할 것
        int max = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i=0; i<priorities.length; i++){
            queue.add(priorities[i]);
        }
        Arrays.sort(priorities);



        //location 위치를 어떻게 확인할 것인가? 체크가 필요함
        //answer 변수 사용, 위치 변수 선언 location <- 이미 되어있다
        //max값 갱신이 필요!
        int size = priorities.length;
        max = priorities[size-1];
        while(true){

            int priority = queue.poll();
            if(location != 0 && priority < max) {
                queue.add(priority);
                location--;
            }else if(location != 0 && priority == max){
                answer++;
                //max--; // 다음 max값을 뭘로 잡을 것인가..? 무한루프 발생
                // 다시 다음 max값을 찾기에는 비효율적
                location--;
                size--;
                max = priorities[size-1];
            }else if(location == 0 && priority < max){
                queue.add(priority);
                location = size - 1;
            }else{
                answer++;
                break;
            }
        }

        return answer;
    }
}
