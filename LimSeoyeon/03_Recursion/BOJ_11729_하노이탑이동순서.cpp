#include <iostream>
using namespace std;

void recursion(int st, int ext, int dest, int n) {

	if (n == 1) {
		cout << st << ' ' << dest << '\n';
		return;
	}
	recursion(st, dest, ext, n - 1);
	cout << st << ' ' << dest << '\n';
	recursion(ext, st, dest, n - 1);
}


int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	// 1 3 7 15 31 
	int cnt = 1;
	for (int i = 1; i < N; i++) {
		cnt = cnt * 2 + 1;
	}
	cout << cnt << '\n';
	recursion(1, 2, 3, N);


}
