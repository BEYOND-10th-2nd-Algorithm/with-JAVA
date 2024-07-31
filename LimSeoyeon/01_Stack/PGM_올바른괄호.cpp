#include<string>
#include <iostream>
#include <stack>

using namespace std;

bool solution(string s)
{
    bool answer = true;

    cin >> s;

    stack <int> st;
    for (int i = 0; i < s.size(); i++) {
        if (s[i] == '(') {
            st.push(1);
        }
        else {
            if (st.empty()) {
                answer = false;
                break;
            }
            else {
                st.pop();
            }
        }
    }

    if (!st.empty()) {
        answer = false;
    }
    return answer;
}