#include <iostream>
#include <vector>
#include <queue>
#define INF 987654321
#define pii pair<int,int>
using namespace std;

int N, D, C; // 노드, 간선, 시작정점
vector<pii> graph[10005]; // 노드1, 노드2, 잇는 간선의 가중치 저장.
bool visited[10005];
int maxi, cnt;
int dist[10005];

void Dijkstra(int st) {
	priority_queue<pii, vector<pii>, greater<pii> > pq;
	pq.push({ 0,st });
	dist[st] = 0;
	while (!pq.empty()) {
		int curWeight = pq.top().first;
		int curNode = pq.top().second;
		pq.pop();
		if (visited[curNode]) continue;
		visited[curNode] = 1;
		for (int i = 0; i < graph[curNode].size(); i++) {
			int nextNode = graph[curNode][i].first;
			int nextWeight = curWeight + graph[curNode][i].second;
			if (nextWeight < dist[nextNode]) {
				dist[nextNode] = nextWeight;
				pq.push({ nextWeight, nextNode });
			}
		}
	}
	maxi = 0;
	cnt = 0;
	for (int i = 1; i <= N; i++) {
		if (dist[i] != INF) {
			cnt++;
			maxi = max(maxi, dist[i]);
		}
	}

}

void init() {
	for (int i = 1; i <= N; i++) {
		dist[i] = INF;
		graph[i].clear();
		visited[i] = 0;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int T;
	cin >> T;
	while (T--) {
		cin >> N >> D >> C;
		init();
		for (int i = 0; i < D; i++) {
			int n1, n2, w;
			cin >> n1 >> n2 >> w;
		//	graph[n1].push_back({ n2,w });
			graph[n2].push_back({ n1,w });
		}

		Dijkstra(C);
		cout << cnt << ' ' << maxi << '\n';

	}

}
