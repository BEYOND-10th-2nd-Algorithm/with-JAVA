#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int N;
string s;
stack<char> st;
int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		if (s[i] >= 'A' && s[i] <= 'Z') {
			cout << s[i];
		}
		else if (s[i] == '(') {
			st.push('(');
		}
		else if (s[i] == ')') {
			while (!st.empty()&&st.top()!='(') {
				cout<< st.top();
				st.pop();
			}
			st.pop();
		}
		else { 
			// s[i] 연산자가 우선순위 높은 경우 => pop하지 않고 스택 쌓기
			// 1. st.top이 -,+이고 s[i]가 *,/일때
			// 2. st.top이 (일 때.
			// 3. st가 empty일때

			//s[i] 연산자가 우선순위 낮을 경우 
			// => s[i]가 최고의 우선순위가 될 때까지 pop
			if (st.empty() || st.top() == '(') {
				st.push(s[i]);
			}
			else if (s[i] == '*' || s[i] == '/') {
				while (!st.empty() && st.top()!='(') {
					if (st.top() == '*' || st.top() == '/') {
						cout << st.top();
						st.pop();
					}
					else break;
				}
				st.push(s[i]);
			}
			else if (s[i] == '+' || s[i] == '-') {
				while (!st.empty() && st.top() != '(') {
					cout << st.top();
					st.pop();
				}
				st.push(s[i]);
			}
		}
		
	}
	//다 돌고 나서도 스택에 연산자 남아있을 수 있으므로 LIFO 방식으로 출력.
	while(!st.empty()) {
		cout << st.top();
		st.pop();
	}

}
