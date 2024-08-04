#include <iostream>
#include <queue>
using namespace std;

queue<int>q;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		q.push(i);
	}

	if (q.size() == 1) {
		cout << 1;
		return 0;
	}

	while (!(q.size() == 2)) {
		q.pop();
		int a = q.front();
		q.pop();
		q.push(a);
	}

	q.pop();

	cout << q.front();
}
