#include <iostream>
using namespace std;

int arr[301][301];
int howMuchMelt[301][301];
bool visited[301][301];
int N, M;

int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

void init() {
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			visited[i][j] = 0;
			howMuchMelt[i][j] = 0;
		}
	}
}


void DFS(int y, int x, bool melt) {
	visited[y][x] = 1;
	if (melt) {
		for (int i = 0; i < 4; i++) {
			int nextY = dy[i] + y;
			int nextX = dx[i] + x;
			if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
			if (arr[nextY][nextX] == 0) {
				howMuchMelt[y][x] += 1;
			}
		}
	}

	for (int i = 0; i < 4; i++) {
		int nextY = dy[i] + y;
		int nextX = dx[i] + x;
		if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
		if (arr[nextY][nextX] > 0 && !visited[nextY][nextX]) {
			DFS(nextY, nextX,melt);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}
	int i = 0;
	while(true){
		i++;
		bool allMelted = 1;
		init();

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (arr[j][k] > 0 && !visited[j][k]) {
					DFS(j, k,1);
					break;
				}
			}
		}

		for (int k = 0; k < N; k++) {
			for (int j = 0; j < M; j++) {
				arr[k][j] -= howMuchMelt[k][j];
				if (arr[k][j] < 0) {
					arr[k][j] = 0;
				}
			}
		}

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (arr[j][k]>0) {
					allMelted = 0;
					break;
				}
			}
			if (!allMelted) break;
		}

		if (allMelted) {
			cout << 0;
			return 0;
		}
		init();
		bool check = false;
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (arr[j][k]!=0) {
					DFS(j, k,0);
					check = true;
					break;
				}
			}
			if (check)break;
		}

		for (int j = 0; j < N; j++) {
			for (int k = 0; k < M; k++) {
				if (arr[j][k]> 0 &&!visited[j][k]) {
					cout << i;
					return 0;
				}

			}
		}
	}

}
