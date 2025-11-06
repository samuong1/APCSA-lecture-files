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
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("05.in", "r", stdin); freopen("05.ans", "w", stdout);
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



const int MAX = (int) 1e6 + 1;

int dp[MAX];
bool visited[MAX];
void dfs(int node, const vector<vector<pii> > &adj, const vi &candy)
{
    visited[node] = 1;
    dp[node] = candy[node];
    for (pii neighbor : adj[node])
    {
        if (!visited[neighbor.first])
        {
            dfs(neighbor.first, adj, candy);
            dp[node] = max(candy[node] + dp[neighbor.first], dp[node]);
        }
    }
}
int main()
{
    afastio
    int N;
    cin >> N;
    vector<vector<pii> > adj(N + 1);
    vector<int> candy(N + 1);
    for (int i = 1; i <= N; i++)
    {
        cin >> candy[i];
    }

    for (int i = 0 ; i < N - 1; i++)
    {
        int a, b, d;
        cin >> a >> b >> d;
        adj[a].push_back(make_pair(b, d)); adj[b].push_back(make_pair(a, d));
    }

    ///distance first
    //first is the value of
    //second is dist
    queue<int> nodes;
    nodes.push(1);
    vector<int> distances(N + 1);
    vector<bool> fvisited(N + 1);
    while (!nodes.empty())
    {
        fvisited[nodes.front()] = 1;
        for (pii neighbor : adj[nodes.front()])
        {
            if (!fvisited[neighbor.first])
            {
                distances[neighbor.first] = neighbor.second + distances[nodes.front()];
                nodes.push(neighbor.first); 
            }
        }
        nodes.pop();
    }
    for (int i = 2; i <= N; i++) cout << distances[i] << "\n";
    // how to find max candy (dp) 

    dfs(1, adj, candy);
    cout << dp[1] << "\n";
}