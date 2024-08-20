#include <iostream>
#include <queue>
using namespace std;
bool arr[1001][1001];
int dist[1001][1001][2];
int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

int N, M;

int BFS() {
	queue<pair<pair<int, int>,bool>> q;
	q.push({ {0,0},0 });

	while (!q.empty()) {
		int curY = q.front().first.first;
		int curX = q.front().first.second;
		bool curBroken = q.front().second;
		q.pop();
		if (curY == N - 1 && curX == M - 1) {
			return dist[curY][curX][curBroken]+1;
		}

		for (int i = 0; i < 4; i++) {
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];
			if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
			if (dist[nextY][nextX][curBroken] != 0) continue;

			if (arr[nextY][nextX] == 0) { //벽 안부셔도 될 때
				dist[nextY][nextX][curBroken] = dist[curY][curX][curBroken] + 1;
				q.push({ {nextY,nextX},curBroken });
			}
			else { // 벽 부셔야 할 때
				if (!curBroken) { //지금까지 안부셨으면
					dist[nextY][nextX][1] = dist[curY][curX][curBroken] + 1;
					q.push({{ nextY,nextX }, 1});
				}
			}
		}
	}

	return -1;
	
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		for (int j = 0; j < s.size(); j++) {
			if (s[j] == '0') arr[i][j] = 0;
			else arr[i][j] = 1;
		}
	}

	cout << BFS();



}
