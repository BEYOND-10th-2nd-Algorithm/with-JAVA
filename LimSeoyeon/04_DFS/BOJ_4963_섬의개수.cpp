#include <iostream>
using namespace std;

bool arr[51][51];
bool visited[51][51];

int dy[8] = { 0,0,1,1,1,-1,-1,-1 };
int dx[8] = { 1,-1,-1,0,1,-1,0,1};

int w, h;

void init() {
	for (int i = 0; i < 51; i++) {
		for (int j = 0; j < 51; j++) {
			visited[i][j] = 0;
		}
	}
}

void DFS(int y, int x) {
	visited[y][x] = true;
	for (int i = 0; i < 8; i++) {
		int nextY = y + dy[i];
		int nextX = x + dx[i];
		if (nextY < 0 || nextX < 0 || nextY >= h || nextX >= w) continue;
		if (arr[nextY][nextX] && !visited[nextY][nextX]) {
			DFS(nextY, nextX);
		}
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	while (true) {
		cin >> w >> h; // h가 y, w가 x
		if (w == h && w == 0) break;

		for (int i = 0; i < h; i++) { //거꾸로.
			for (int j = 0; j < w; j++) {
				cin>>arr[i][j];
			}
		}
		init();
		int cnt = 0;
		for (int i = 0; i < h; i++) { 
			for (int j = 0; j < w; j++) {
				if (!visited[i][j] && arr[i][j]) {
					DFS(i, j);
					cnt++;
				}
			}
		}
		
		cout << cnt<<'\n';
	}
}
