using namespace std;
#include <bits/stdc++.h>
#define ll long long
#define pii pair<int, int>
#define pll pair<long long, long long>
#define vi vector<int>
#define vll vector<long long>
#define vc vector<char>
#define vs vector<string>
#define mii map<int, int>
#define si set<int>
#define sll set<long long>
#define sc set<char>
#define ss set<string>
#define pii pair<int, int>
#define pll pair<long long, long long>
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
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("Frankenstein.in", "r", stdin); 
#define fastio ios::sync_with_stdio(0); cin.tie(0);
#define read(x) cin >> x
#define print(x) cout << x << "\n"
#define debug(x) cerr << #x << " = " << x << "\n"
int gcd(int a,int b) { if (b==0) return a; return gcd(b, a%b); }
int lcm(int a,int b) { return a/gcd(a,b)*b; }
ll gcd_ll(ll a,ll b) { if (b==0) return a; return gcd(b, a%b); }
ll lcm_ll(ll a,ll b) { return a/gcd_ll(a,b)*b; }
bool prime(int a) { if (a==1) return 0; for (int i=2;i<=round(sqrt(a));++i) if (a%i==0) return 0; return 1; }
bool prime_ll(ll a) { if (a==1) return 0; for (int i=2;i<=round(sqrt(a));++i) if (a%i==0) return 0; return 1; }
#define MOD 1000000007
#define inf 1e9  // Use for int (e.g., distance)
#define inf_ll 1e18  // Use for long long
#define eps 1e-9  // Precision for floating-point comparisons
class DisjointSets {
  public:
    vector<int> parents;
	vector<int> sizes;
    vector<int> coolness;
    vector<int> rep_girl;
	DisjointSets(int size, const vector<int> &coolness, const vector<int> rep_girl) : parents(size), sizes(size, 1) {
		for (int i = 0; i < size; i++) { parents[i] = i; }
        this->coolness = coolness;
        this->rep_girl = rep_girl;
	}

	/** @return the "representative" node in x's component */
	int find(int x) { return parents[x] == x ? x : (parents[x] = find(parents[x])); }

    int find_rep_girl(int x) {return rep_girl[x] == x ? x : (rep_girl[x] = find_rep_girl(rep_girl[x]));}
	/** @return whether the merge changed connectivity */
	bool unite(int x, int y) {
		int x_root = find(x);
		int y_root = find(y);

        int x_rep_girl = find_rep_girl(x);
        int y_rep_girl = find_rep_girl(y);

        if (x_rep_girl != 0) rep_girl[y] = rep_girl[x_rep_girl];
        else if (y_rep_girl != 0) rep_girl[x] = rep_girl[y_rep_girl];
		if (x_root == y_root) { return false; }

		if (sizes[x_root] < sizes[y_root]) { swap(x_root, y_root); }
		sizes[x_root] += sizes[y_root];
        coolness[x_root] += coolness[y_root];
		parents[y_root] = x_root;
		return true;
	}

	/** @return whether x and y are in the same connected component */
	bool connected(int x, int y) { return find(x) == find(y); }
};

int main()
{
    afastio
    int N, U, K, H;
    cin >> N >> U >> K >> H;
    vector<int> c(N + 1);
    vector<int> gender(N + 1);
    for (int i = 1; i <= N; i++)
    {
        cin >> c[i];
        gender[i] = c[i] > 0 ? 0 : i;
    }
    DisjointSets ds(N + 1, c, gender);
    vector<pair<int, int> > conn;
    for (int i = 0; i < U; i++)
    {
        int x, y;
        cin >> x >> y;
        conn.pb(mp(x, y));
    }
    for (int i = 0; i < U - H; i++)
    {
        ds.unite(conn[i].first, conn[i].second);
    }
    vector<int> ans;
    for (int t = U - H; t < U; t++)
    {
        ds.unite(conn[t].first, conn[t].second);
        vector<int> u_girls = ds.rep_girl;
        sort(u_girls.begin(), u_girls.end()); 
        auto last = unique(u_girls.begin(), u_girls.end());
        u_girls.erase(last, u_girls.end());


        vi cost;
        vi t_coolness;
        for (int girl : u_girls)
        {
            if (girl > 0)
            {
                cost.push_back(ds.sizes[ds.find(girl)]);
                t_coolness.push_back(ds.coolness[ds.find(girl)]);
            }
        }
        vector<int> dp(K + 1);

        for (int i = 1; i <= cost.size(); i++)
        {
            for (int j = K; j >= cost[i - 1]; j--)
            {
                dp[j] = max(dp[j], dp[j - cost[i - 1]] + t_coolness[i - 1]);
            }
        }
        ans.pb(dp[K] + ds.coolness[ds.find(1)]);
    }
    reverse(ans.begin(), ans.end());
    for (int i = 0; i < ans.size(); i++)
    {
        cout << ans[i] << "\n";
    }
}