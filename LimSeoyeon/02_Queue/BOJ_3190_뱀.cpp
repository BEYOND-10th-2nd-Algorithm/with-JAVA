#include <iostream>
#include <queue>
using namespace std;

int arr[105][105];
int dy[4] = { 0,-1,0,1 };
int dx[4] = { 1,0,-1,0};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N,M;
	cin >> N>>M;
	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		arr[a][b] = 1;
	}
	int orderNum;
	cin >> orderNum;

	queue<pair<int, int>> order;
	queue<pair<int, int>> q;

	for (int i = 0; i < orderNum; i++) {
		int a; 
		char b;
		cin >> a >> b;
		//오른쪽 회전 -> -, 왼쪽 회전-> +
		if (b == 'L') {
			order.push({ a, 1});
		}
		else {
			order.push({ a, -1 });
		}
	}
	int curY =1 ,curX = 1;
	int res = 0;
	int dirNum = 0;

	q.push({ 1,1 });

	while (true) {
		//1. 다음에 움직일 방향 설정
		if (!order.empty() && order.front().first == res) {
			dirNum += order.front().second;
			if (dirNum < 0) dirNum = 3;
			if (dirNum > 3) dirNum = 0;
			order.pop();
		}
		//2. 설정된 방향으로 다음에 움직일 위치 정하기
		curX += dx[dirNum];
		curY += dy[dirNum];

		//종료 조건 = 다음에 갈 위치가 벽이거나 자기자신의 몸이면 게임 종료.
		if (curY<1 || curX<1 || curY>N || curX>N || arr[curY][curX] == 2) {
			res += 1;
			break;
		}

		//3. 시간 흐르기
		res++;

		//4. 움직이기
		if (arr[curY][curX] == 0) { // 사과 없을 때 - 꼬리 없애기.
			int delY = q.front().first;
			int delX = q.front().second;
			arr[delY][delX] = 0;
			q.pop();
		}
		q.push({ curY,curX }); 
		arr[curY][curX] = 2;
	}

	cout << res;

}
