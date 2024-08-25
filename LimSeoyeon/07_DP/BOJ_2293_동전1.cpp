#include <iostream>
using namespace std;

int DP[10001] = { 0, }; //K를 만드는 경우의 수

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	int N, K;
	cin >> N >> K;

	int arr[101];
	
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	
	DP[0] = 1;


	for (int i = 0; i < N; i++) {
		for (int j = arr[i]; j <= K; j++) {
			DP[j] += DP[j - arr[i]];
		}
	}

	cout << DP[K];
}
