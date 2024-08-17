#include <iostream>
using namespace std;

int arr[501][501];
int DP[501][501];

int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

int N, M;

int DFS(int y, int x) { //return값 경로 개수.
	if (DP[y][x] != -1) {
		return DP[y][x];
	}
	if (y == N - 1 && x == M - 1) {
		return 1;
	}
	DP[y][x] = 0;
	for (int i = 0; i < 4; i++) {
		int nextY = y + dy[i];
		int nextX = x + dx[i];
		if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
		if (arr[nextY][nextX] < arr[y][x]) {
			DP[y][x] += DFS(nextY, nextX);
		}
	}

	return DP[y][x];
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			DP[i][j] = -1;
		}
	}
	cout << DFS(0, 0);

	//DP[i][j] = i,j에서 DP[N][M]까지 갈 수 있는 경로의 수 .
	//DFS만 돌리면 시간초과.

}
