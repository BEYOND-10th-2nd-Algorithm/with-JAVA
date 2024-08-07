#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue<int> q1; // 다리 대기 queue
    queue<int> q2; // 다리 위의 queue
    
    for(int i=0; i<truck_weights.size(); i++){
        q1.push(truck_weights[i]);
    }    
    
    int next=q1.front();
    q1.pop();
    int curWeight=0;
    
    while(!q1.empty()){
        q2.push(next);
        curWeight += next;
        answer++;
        if(q2.size()==bridge_length){
            curWeight-=q2.front();
            q2.pop();
        }
        if(q1.front()+curWeight<=weight){
            next = q1.front();
            q1.pop();
        }
        else{
            next=0;
        }
    } // 마지막 트럭이 다리 위에 올라갈 때 while문 break.
    
    answer+=bridge_length+1;
    return answer;
    
    
}
