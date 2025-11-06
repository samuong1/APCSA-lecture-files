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
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("06.in", "r", stdin); freopen("06.ans", "w", stdout);
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



int compute_pre(vi &pre, int end)
{
    return pre[end];
}
bool check(vi &pre, int num, int M)
{
    return compute_pre(pre, num) - M * num > 0;
}
int main()
{
    afastio
    int N, M;
    cin >> N >> M;
    vi clusters;
    int sum = 0;
    for (int i = 0 ; i < N; i++)
    {
        int ai; cin >> ai;
        if (ai > 0) sum += ai;
        else 
        {
            if (sum > 0)
                clusters.push_back(sum); sum = 0;
        }
    }
    if (sum > 0)
    {
        clusters.push_back(sum);
    }

    sort(clusters.rbegin(), clusters.rend());
    vi pre(clusters.size() + 1);
    for (int i = 0 ; i < clusters.size(); i++)
    {
        pre[i + 1] = pre[i] + clusters[i];
    }
    
    int low = 1;
    int high = clusters.size();
    while (high >= low)
    {
        int mid = low + (high - low) / 2;
        if (check(pre, mid, M))
        {
            low = mid + 1;
        }
        else high = mid - 1;
    }
    cout << high << "\n";

}