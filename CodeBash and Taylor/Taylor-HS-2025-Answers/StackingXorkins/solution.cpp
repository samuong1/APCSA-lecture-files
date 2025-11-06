#include <iostream>
#include <vector>

using namespace std;
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("03.in", "r", stdin); freopen("03.ans", "w", stdout);

int main() {
	afastio	
	int n;
	cin >> n;
	vector<int> pref(n + 1);
	for (int i = 2; i <= n; i++) {
		int num = i;
		while (num % 2 == 0) {
			pref[i]++;
			num /= 2;
		}
		pref[i] += pref[i - 1];
	}

	int ans = 0;
	for (int i = 0; i < n; i++) {
		int num;
		cin >> num;
		if (pref[n - 1] - pref[i] - pref[n - i - 1] == 0) { ans ^= num; }
	}

	cout << ans << endl;
}