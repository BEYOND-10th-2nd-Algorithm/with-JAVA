#include <iostream>
#include <queue>
using namespace std;


int N;
bool visited[301][301];
int stY, stX;
int finY, finX;

int dy[8] = { -1,-1,1,1,-2,-2,2,2 };
int dx[8] = { 2,-2,2,-2,1,-1,1,-1 };

void init() {
	for (int i = 0; i < 301; i++) {
		for (int j = 0; j < 301; j++) {
			visited[i][j] = 0;
		}
	}
}

int BFS() {
	queue<pair<pair<int, int>, int>>q;
	q.push({{ stY, stX },0});
	int cnt = 0;
	while (!q.empty()) {
		int curY = q.front().first.first;
		int curX = q.front().first.second;
		int curCnt = q.front().second;
		q.pop();
		if (curY == finY && curX == finX) {
			return curCnt;
		}
		for (int i = 0; i < 8; i++) {
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= N) continue;
			if (visited[nextY][nextX]) continue;
			q.push({ { nextY,nextX },curCnt + 1 });
			visited[nextY][nextX] = 1;
		}
	}
	return -1;

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int T;
	cin >> T;
	while (T--) {
		cin >> N;
		cin >> stY >> stX >> finY >> finX;
		init();
		cout << BFS()<<'\n';
	}
}
