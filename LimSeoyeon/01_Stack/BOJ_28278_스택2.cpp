#include <iostream>
#include <stack>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	stack<int> st;

	for (int i = 0; i < N; i++) {
		int a;
		cin >> a;
		if (a == 1) {
			int b; 
			cin >> b;
			st.push(b);
		}
		else if (a == 2) {
			if (!st.empty()) {
				cout << st.top()<<'\n';
				st.pop();
			}
			else {
				cout << -1<<'\n';
			}
		}
		else if (a == 3) {
			cout << st.size() << '\n';
		}
		else if (a == 4) {
			cout << st.empty()<< '\n';
		}
		else {
			if (!st.empty()) {
				cout << st.top() << '\n';
			}
			else {
				cout << -1 << '\n';
			}
		}
	}

}