#include <iostream>
using namespace std;

int N;
int arr[101][101];
int dy[4] = { 0,0,-1,1 };
int dx[4] = { 1,-1,0,0 };

bool visited[101][101];

void DFS(int y, int x, int h) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int nextY = dy[i] + y;
		int nextX = dx[i] + x;
		if (nextY < 0 || nextX < 0 || nextX >= N || nextY >= N) continue;
		if (arr[nextY][nextX] > h && !visited[nextY][nextX]) {
			DFS(nextY, nextX, h);
		}
	}
}

void init() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			visited[i][j] = 0;
		}
	}
}

int main() {
	cin >> N;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> arr[i][j];
		}
	}

	int res = 0;
	for (int k = 0; k <= 100; k++) {
		int cnt = 0;
		init();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]&& arr[i][j]>k) {
					DFS(i, j,k);
					cnt++;
				}
			}
		}
		res = max(res, cnt);
	}

	cout << res;
}
