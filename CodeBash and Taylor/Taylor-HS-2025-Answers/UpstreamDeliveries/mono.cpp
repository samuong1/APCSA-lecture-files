#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define pll pair<long long, long long>
#define vll vector<long long>
#define pb push_back
#define fi first
#define se second

const ll MX = (ll)1e6 + 10;
vll adj[MX];
bool visited[MX];

// --- Iterative DFS replacement ---
void dfs_iterative(ll root, vll &cost) {
    stack<ll> st;
    st.push(root);
    visited[root] = true;

    while (!st.empty()) {
        ll node = st.top();
        st.pop();

        for (size_t i = 0; i < adj[node].size(); i++) {
            ll neighbor = adj[node][i];
            if (!visited[neighbor]) {
                cost[neighbor] += cost[node];
                visited[neighbor] = true;
                st.push(neighbor);
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    freopen("UpstreamDeliveries.in", "r", stdin);

    ll N;
    cin >> N;

    vector<ll> a(N), w(N), res(N), parent(N);
    vector<pll> mono;

    for (ll i = 0; i < N; i++) cin >> a[i];
    for (ll i = 0; i < N; i++) cin >> w[i];

    // --- Build monotonic stack result ---
    for (ll i = N - 1; i >= 0; i--) {
        while (!mono.empty() && a[i] > mono.back().first)
            mono.pop_back();
        if (!mono.empty()) res[i] = mono.back().second - i;
        else res[i] = 0;
        mono.push_back(make_pair(a[i], i));
    }

    vll cost(N);
    for (ll i = 0; i < N; i++) {
        parent[i] = i + res[i];
        cost[i] = res[i] * w[i];
    }

    // --- Build tree structure ---
    vector<ll> roots;
    for (ll i = 0; i < N; i++) {
        if (parent[i] == i)
            roots.push_back(i);
        else
            adj[parent[i]].push_back(i);
    }

    // --- Run iterative DFS from each root ---
    for (size_t i = 0; i < roots.size(); i++) {
        dfs_iterative(roots[i], cost);
    }

    // --- Output results ---
    for (ll i = 0; i < N; i++)
        cout << cost[i] << "\n";

    return 0;
}
