#include <iostream>
using namespace std;

bool arr[501][501];

void recursive(int y, int x, int N) {
	if (N == 1) {
		arr[y][x] = 1;
	}
	else {
		int length = N * 4 - 3; // 5 9 13 17 ...
		for (int i = 0; i < length; i++) {
			arr[y+i][x] = 1;
			arr[y+i][x+ length-1] = 1;
		}
		for (int i = 0; i < length; i++) {
			arr[y][x+i] = 1;
			arr[y+ length - 1][x+i] = 1;
		}

		recursive(y + 2, x + 2, N - 1); // 2 2 5
	}

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;
	recursive(0, 0, N);
	for (int i = 0; i < N*4-3; i++) {
		for (int j = 0; j < N*4-3; j++) {
			if (arr[i][j]) cout << '*';
			else cout << ' ';
		}
		cout << '\n';
	}


}
