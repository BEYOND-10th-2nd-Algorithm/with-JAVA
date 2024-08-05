#include <iostream>
#include <queue>
using namespace std;

int arr[300001];
// 300,000 x 299999 / 2 => 백퍼센트 시간초과.
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N, M;
	cin >> N >> M;
	queue<int> q[21];
	long long res = 0;
	for (int i = 0; i < N; i++) {
		string s;
		cin >> s;
		arr[i] = s.length();
	}
	
	for (int i = 0; i < N; i++) {
		int curQ = arr[i];
		while (!q[curQ].empty()&& i-q[curQ].front()>M) {
			q[curQ].pop();
		}
		res += q[curQ].size();
		q[curQ].push(i);
	}

	cout << res;

}
