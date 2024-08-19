#include <iostream>
#include <vector>
#include <queue>
using namespace std;

int N, M;
bool visited[9][9];
int arr[9][9];
int copyArr[9][9];
vector<pair<int, int>> blank;
vector<pair<int, int>> virus;

int dy[4] = { 0,0,-1,1 };
int dx[4] = { -1,1,0,0 };

void setWall(int y1, int x1, int y2, int x2, int y3, int x3) {
	arr[y1][x1] = 1;
	arr[y2][x2] = 1;
	arr[y3][x3] = 1;
}

void init(int y1, int x1, int y2, int x2, int y3, int x3) {
	
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			arr[i][j] = copyArr[i][j];
			visited[i][j] = 0;
		}
	}
}
void BFS(int y, int x) {
	queue<pair<int, int>> q;
	q.push({ y,x });
	visited[y][x] = 1;
	while (!q.empty()) {
		int curY = q.front().first;
		int curX = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nextY = curY + dy[i];
			int nextX = curX + dx[i];
			
			if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M) continue;
			if (visited[nextY][nextX]) continue;
			if (arr[nextY][nextX] == 0) {
				arr[nextY][nextX] = 2;
				visited[nextY][nextX] = 1;
				q.push({ nextY, nextX });
			}
		}
	}

}

int cntSafe() {
	int safe = 0;
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] == 0) safe++;
		}
	}

	return safe;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;


	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
			copyArr[i][j] = arr[i][j];
			if (!arr[i][j]) {
				blank.push_back({ i,j });
			}
			if (arr[i][j] == 2) {
				virus.push_back({ i,j });
			}
		}
	}
	int res = 0;
	for (int i = 0; i < blank.size(); i++) { // 최대 62
		for (int j = i+1; j < blank.size(); j++) {
			if (i == j) continue;
			for (int k = j+1; k < blank.size(); k++) {
				if (i == k || j == k) continue;
				int y1 = blank[i].first;
				int x1 = blank[i].second;
				int y2 = blank[j].first;
				int x2 = blank[j].second;
				int y3 = blank[k].first;
				int x3 = blank[k].second;
				setWall(y1,x1,y2,x2,y3,x3);
				
				for (int l = 0; l < virus.size(); l++) { 
					BFS(virus[l].first, virus[l].second);
				}
			
				res = max(res,cntSafe());
				init(y1, x1, y2, x2, y3, x3);
				
				
			}
		}
	}

	cout << res;


}
