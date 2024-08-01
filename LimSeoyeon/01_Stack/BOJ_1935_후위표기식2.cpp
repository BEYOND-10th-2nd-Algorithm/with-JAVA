#include <iostream>
#include <stack>
using namespace std;

int N;
string s;
stack<double>st;
int arr[30];
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> s;
	for (int i = 0; i < N; i++) {
		cin >> arr[i]; //문자별 숫자 정보 저장.
	}

	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 65 && s[i] <= 90) {
			st.push(arr[s[i]-65]);
		} // 대문자인 경우 해당 문자가 가르키는 숫자를 저장.
		else {
			double num2 = st.top();
			st.pop();
			double num1 = st.top();
			st.pop();
			switch (s[i]) {
			case '+':
				num1 += num2; break;
			case '-':
				num1 -= num2; break;
			case '*':
				num1 *= num2; break;
			case '/':
				num1 /= num2; break;
			}
			st.push(num1);
			//계산된 값 stack에 다시 저장.
		}
	}
	cout.precision(2);
	cout << fixed;
	cout << st.top();

}
