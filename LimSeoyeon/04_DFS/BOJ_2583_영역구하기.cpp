#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

bool arr[101][101];
bool visited[101][101];
int dy[4] = { 0,0,1,-1 };
int dx[4] = { 1,-1,0,0 };
vector<int>v;
int N, M, K;

int weight;

void DFS(int y, int x) {
	visited[y][x] = 1;
	weight++;
	for (int i = 0; i < 4; i++) {
		int nextY = y + dy[i];
		int nextX = x + dx[i];
		if (nextY < 0 || nextX < 0 || nextY >= M || nextX >= N) continue;
		if (!arr[nextY][nextX] && !visited[nextY][nextX]) {
			DFS(nextY, nextX);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> M >> N >> K;


	for (int i = 0; i < K; i++) {
		int x1, y1, x2, y2; // 왼쪽 아래, 오른쪽 위 좌표.
		cin >> x1 >> y1 >> x2 >> y2;
		for (int i = y1; i < y2; i++) {
			for (int j = x1; j < x2; j++) {
				arr[i][j] = 1;
			}
		}
	}

	int cnt = 0;
	for (int i = 0; i < M; i++) {
		for (int j = 0; j < N; j++) {
			if (!visited[i][j] && !arr[i][j]) {
				weight = 0;
				DFS(i, j);
				v.push_back(weight);
				cnt++;

			}
		}
	}

	cout << cnt<<'\n';

	sort(v.begin(), v.end());
	for (int i = 0; i < cnt; i++) {
		cout << v[i] << ' '; 
	}
}
