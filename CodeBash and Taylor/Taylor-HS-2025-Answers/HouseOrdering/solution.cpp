using namespace std;
#include <bits/stdc++.h>
#define ll long long
#define vi vector<int>
#define vll vector<long long>
#define vb vector<bool>
#define vc vector<char>
#define vs vector<string>
#define si set<int>
#define sll set<long long>
#define sc set<char>
#define ss set<string>
#define usi unordered_set<int>
#define qi queue<int>
#define pqi priority_queue<int>
#define pqll priority_queue<ll>
#define mii map<int, int>
#define umii unordered_map<int, int>
#define pii pair<int, int>
#define pllll pair<long long, long long>
#define f(i,s,e) for(int i = s; i < e; i++)
#define cf(i,s,e) for(int i = s; i <= e; i++)
#define rf(i,e,s) for(int i = e-1; i >= s; i--)
#define all(x) x.begin(), x.end()
#define rall(x) x.rbegin(), x.rend()
#define pb push_back
#define eb embrace_back
#define mp make_pair
#define fi first
#define se second
#define ub upper_bound
#define lb lower_bound
#define sz(x) (int)(x).size()
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("05.in", "r", stdin); freopen("05.ans", "w", stdout);
#define fastio ios::sync_with_stdio(0); cin.tie(0);
#define mod 1000000007  //1e9 + 7
#define inf 1e9  // Use for int (e.g., distance)
#define inf_ll 1e18  // Use for long long
#define eps 1e-9  // Precision for floating-point comparisons

int main() {
	afastio
	int n, m; cin >> n >> m;
	vector<si> e_out(n);
	vi deg_in(n);
	f(i, 0, m) {
		int u, v; cin >> u >> v;
		u--; v--; 
		e_out[u].insert(v);
		deg_in[v]++;
	}
	vi p(n); f(i, 0, n) {cin >> p[i]; p[i]--;}

	// 1. find a order x <= p;
	vector<si> eo = e_out;
	vi di = deg_in;
	si s;
	vector<pii> px;
	vi x;
	bool no_result = false;
	f(i, 0, n) if (di[i] == 0) s.insert(i);
	f(i, 0, n) {
		if (s.empty()) {break; }
		int eq, lg;
		auto it = s.find(p[i]);
		if (it != s.end()) eq = *it; else eq = -1;
		it = s.ub(p[i]);
		if (it != s.end()) lg = *it; else lg = -1;
		px.pb(mp(eq, lg));
		if (eq != -1) {
			s.erase(eq); 
			for(auto a: eo[eq]) {
				di[a] -- ;
				if ((di[a]) == 0) s.insert(a);
			}

		} else break;
	}

	if (sz(px) == 1) {
		if (px[0].se != -1) x.pb(px[0].se); 
	} else {
		bool find = false;
		rf(j, sz(px)-1, 0) {
			if (find) x.pb(px[j].fi);
			else if (px[j].se != -1) {x.pb(px[j].se); find = true;}
		}
	}
	if (x.empty()) {cout << -1 << endl; return 0;}

	eo = e_out;
	di = deg_in;
	s.clear();
	vi ans;
	f(i, 0, n) if (di[i] == 0) s.insert(i);
	while (!s.empty()) {
		int a;
		if (!x.empty()) {
			a = x.back();
			x.pop_back();
			s.erase(a);
		} else {
			a = *s.begin();
			s.erase(s.begin());
		}
		ans.pb(a);
		for (auto b: eo[a]) {
			di[b]--;
			if (di[b] == 0) s.insert(b);
		}
	}

	f(i, 0, sz(ans)) cout << ans[i] + 1 << " ";
		
}