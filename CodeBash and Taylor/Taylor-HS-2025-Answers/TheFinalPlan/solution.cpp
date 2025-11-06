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
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("Final.in", "r", stdin); 
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
#define eps 1e-9


const int INF = 1e9;
vector< pair<int, int> > nodes;
//unordered_map<int, unordered_map<int, int>> dp;
int dist(int x1, int y1, int x2, int y2)
{
    return abs(x2 - x1) + abs(y2 - y1);
}
void solve()
{
    nodes.clear();
    int x_max; int y_max;
    cin >> x_max >> y_max;
    int x_origin; int y_origin;
    cin >> x_origin >> y_origin;
    int N; cin >> N;
    for (int i = 0 ; i < N; i++)
    {
        int u,v; cin >> u >> v;
        nodes.pb(mp(u, v));
    }
    int maxMask = 1 << N;
    vector< vector<int> > dp(maxMask, vector<int>(N, INF));
    for (int k = 0; k < N; k++)
    {
        int num = 1 << k;
        dp[num][k] = dist(x_origin, y_origin, nodes[k].first, nodes[k].second);
    }

    for (int j = 0; j < (1 << N); j++)
    {
        for (int c = 0; c < N; c++)
        {
            if (j & (1 << c))
            {
                int prev_mask = j ^ (1 << c); // remove c
                if (prev_mask == 0) continue;
                for (int m = 0; m < N; m++)
                {
                    if (prev_mask & (1 << m))
                    {
                        dp[j][c] = min(dp[j][c], dp[prev_mask][m] + dist(nodes[m].first, nodes[m].second, nodes[c].first, nodes[c].second));
                    }
                }
            }
        }
    }
    int ans = inf;
    int full_mask = (1 << N) - 1;
    for (int k = 0; k < N; k++)
    {
        ans = min(ans, dp[full_mask][k] + dist(nodes[k].first,nodes[k].second, x_origin, y_origin));
    }
    cout << "The shortest path has length " << ans << "\n";


}   
int main()
{
    afastio
    int T; cin >>T;
    while (T--) solve();
}