#include <iostream>
using namespace std;

int idx = 0;
char res;
bool flag = 0;
int N;

void recursion(int n) {
	if (flag) return;
	if (n == 0) {
		if (idx == N) {
			res = 'm';
			flag = 1;
		}
		else if (idx + 1 == N || idx + 2 == N) {
			res = 'o';
			flag = 1;
		}
		else {
			idx += 3;
		}
		return;
	}
	recursion(n - 1);
	if (idx == N) {
		res = 'm';
		flag = 1;
	}
	else if (idx+1 <= N && idx +n+3 > N) {
		res = 'o';
		flag = 1;
	}
	else {
		idx += n + 3;
	}
	recursion(n - 1);

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;
	N = N - 1;
	int cnt = 3;
	int i = 0;
	while (cnt<=N) {
		cnt = cnt * 2 + (i+3);
		i++;
	}
	recursion(i);
	
	cout << res;
}
