#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

vector<int> v[100001];
bool visited[100001];
int order[100001];
int cnt = 1;
void DFS(int node) {
	visited[node] = 1;
	order[node] = cnt;
	cnt++;
	for (int i = 0; i < v[node].size(); i++) {
		int nextNode = v[node][i];
		if (!visited[nextNode]) {
			DFS(nextNode);
		}
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, M, R;
	cin >> N >> M >> R;

	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	for (int i = 1; i <= N; i++) {
		sort(v[i].begin(), v[i].end(), greater<>());
	}
	DFS(R);
	for (int i = 1; i <= N; i++) {
		cout << order[i] << '\n';
	}
}
