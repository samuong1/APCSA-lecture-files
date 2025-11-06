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
#define fastioa ios::sync_with_stdio(0); cin.tie(0); freopen("09.in", "r", stdin); freopen("09.ans", "w+", stdout);
#define fastio ios::sync_with_stdio(0); cin.tie(0);
#define MOD 1000000007  //1e9 + 7
#define inf 1e9  // Use for int (e.g., distance)
#define inf_ll 1e18  // Use for long long
#define eps 1e-9  // Precision for floating-point comparisons

int inv(ll a) {
    return a <= 1 ? a : MOD - (long long)(MOD/a) * inv(MOD % a) % MOD;
}

int getprod(vll &product_sum, int l, int r)
{
    ll bottom = 1;
    if (l > 0) bottom = product_sum[l - 1];
    return (product_sum[r] % MOD * inv(bottom) % MOD) % MOD;
}
int main()
{
    fastioa
    string nums;
    getline(cin, nums); 
    istringstream iss(nums);
    vll product_sum; ll num; ll running_prod = 1;
    while (iss >> num)
    {
        running_prod *= num; running_prod %= MOD;
        product_sum.push_back(running_prod);
    }
    
    ll l, r;
    while (cin >> l >> r)
    {
        cout << getprod(product_sum, l, r) << "\n";
    } 
}