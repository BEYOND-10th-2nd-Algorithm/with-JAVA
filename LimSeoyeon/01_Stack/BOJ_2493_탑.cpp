#include <iostream>
#include <stack>

using namespace std;
int arr[500001];
int res[500001];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 1; i <= N; i++) {
		cin >> arr[i]; // i번째 arr에는 i번째 탑의 높이가 저장됨.
	}  
	stack<pair<int,int>> st;

	st.push({ N,arr[N] }); //맨 마지막 탑은 신호를 받을 수 없으므로 바로 stack에 넣어놓음.

	for(int i=N-1; i>=1; i--) {
		while(!st.empty() && st.top().second<arr[i] ){// i번쨰 탑이 stack의 top에있는 탑의 신호를 받아줄 수 있는 상태.
			res[st.top().first] = i;
			st.pop();
		}
		st.push({ i,arr[i] });
	}
	for (int i = 1; i <= N; i++) {
		cout << res[i]<<' ';
	}

}
