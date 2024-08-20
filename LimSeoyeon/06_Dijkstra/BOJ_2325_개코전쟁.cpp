#include <iostream>
#include <vector>
#include <queue>

#define INF 987654321
#define pii pair<int,int>
using namespace std;

int N, M;

int path[1001];
int dist[1001];
vector<pii>graph[1001];
bool visited[1001];
vector<int> minPath;

void init() {
	for (int i = 1; i <= N; i++) {
		dist[i] = INF;
		visited[i] = 0;
	}
	
}

void Dijkstra() {
	priority_queue<pii, vector<pii>, greater<pii>> pq;
	pq.push({ 0,1 }); // 가중치, 노드 
	dist[1] = 0;
	while (!pq.empty()) {
		int curWeight = pq.top().first;
		int curNode = pq.top().second;
		pq.pop();

		if (visited[curNode]) continue;
		visited[curNode] = 1;
		for (int i = 0; i < graph[curNode].size(); i++) {
			int nextNode = graph[curNode][i].first;
			int nextWeight = graph[curNode][i].second + curWeight;
			if (dist[nextNode] >= nextWeight) {
				dist[nextNode] = nextWeight;
				pq.push({ nextWeight,nextNode });
				path[nextNode] = curNode;
			}
		}


	}

}

void findMinPath() {
	int curNode = N;
	minPath.push_back(N);
	while (curNode != 1) {
		int backNode = path[curNode];
		minPath.push_back(backNode);
		curNode = backNode;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int n1, n2, w;
		cin >> n1 >> n2 >> w;
		graph[n1].push_back({ n2,w });
		graph[n2].push_back({ n1,w });
	}
	init();
	Dijkstra();
	
	findMinPath(); // 최단거리 경로 찾음.

	vector<pii> breakRode;

	int maxRes = 0;
	for (int i = 0; i < minPath.size() - 1; i++) {
		int n1 = minPath[i];
		int n2 = minPath[i + 1];
		int w = 0;
		for (int j = 0; j < graph[n1].size(); j++) {
			if (graph[n1][j].first == n2) {
				w = graph[n1][j].second;
				graph[n1].erase(graph[n1].begin() + j);
			}
		}
		for (int j = 0; j < graph[n2].size(); j++) {
			if (graph[n2][j].first == n1) {
				graph[n2].erase(graph[n2].begin() + j);
			}
		}
		// cout << n1 << ' ' << n2 << ' ' << w;
		init();
		Dijkstra();
		/*for (int i = 1; i <= N; i++) {
			cout << dist[i] << ' ';
		}
		cout << '\n';*/
		maxRes = max(dist[N], maxRes);
		
		graph[n1].push_back({ n2,w });
		graph[n2].push_back({ n1,w });
	}

	cout << maxRes;
	
	
}
