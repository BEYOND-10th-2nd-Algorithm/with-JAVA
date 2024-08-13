#include <iostream>
#include <vector>
using namespace std;
int N;
bool res[101];
bool visited[101];
int graph[101];

void init() {
	for (int i = 1; i <= N; i++) {
		visited[i] = 0;
	}
}

void copyVisit() {
	for (int i = 1; i <= N; i++) {
		if (!res[i] && visited[i]) {
			res[i] = 1;
		}
	}
}

bool DFS(int node, int st) {
	visited[node] = 1;
	int nextNode = graph[node];

	if (res[nextNode]) return false;

	if (visited[nextNode]) {
		if (nextNode == st) {
			return true;
		}
		else return false;
	}
	return DFS(nextNode, st);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> N;

	for (int i = 1; i <= N; i++) {
		int a;
		cin >> a;
		graph[i] = a;
	}
	for (int i = 1; i <= N; i++) {
		if (DFS(i, i)) copyVisit();
		init();
	}
	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		cnt += res[i];
	}
	cout << cnt << '\n';

	for (int i = 1; i <= N; i++) {
		if (res[i]) {
			cout << i << '\n';
		}
	}

}
