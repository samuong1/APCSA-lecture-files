#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const ll INF = (ll)4e18;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int N, M, C;
    ll R;
    int K;
    cin >> N >> M >> R >> K; cin >> C;

    // Build adjacency list
    vector<vector<pair<int, ll> > > adj(N + 1);
    for (int i = 0; i < M; i++) {
        int u, v;
        ll l;
        cin >> u >> v >> l;
        adj[u].push_back(make_pair(v, l));
        adj[v].push_back(make_pair(u, l));
    }

    vector<int> cntDest(N + 1, 0);
    vector<bool> wellConnected(N + 1, false);

    const int THRESH = 10000; // switch between strategies

    if (C <= THRESH) {
        // Strategy A: run from each charging station
        for (int s = 1; s <= C; s++) {
            vector<ll> dist(N + 1, INF);
            dist[s] = 0;

            priority_queue<pair<ll, int>, vector<pair<ll, int> >, greater<pair<ll, int> > > pq;
            pq.push(make_pair(0, s));

            while (!pq.empty()) {
                pair<ll, int> top = pq.top();
                pq.pop();
                ll d = top.first;
                int u = top.second;
                if (d != dist[u]) continue;
                if (d > R) continue; // cutoff beyond R miles

                if (u > C) cntDest[u]++;

                for (size_t i = 0; i < adj[u].size(); i++) {
                    int v = adj[u][i].first;
                    ll w = adj[u][i].second;
                    if (dist[v] > d + w) {
                        ll nd = d + w;
                        if (nd <= R) {
                            dist[v] = nd;
                            pq.push(make_pair(nd, v));
                        }
                    }
                }
            }
        }

        vector<int> result;
        for (int v = C + 1; v <= N; v++) {
            if (cntDest[v] >= K)
                result.push_back(v);
        }

        sort(result.begin(), result.end());
        cout << result.size() << "\n";
        for (size_t i = 0; i < result.size(); i++)
            cout << result[i] << "\n";
    } 
    else {
        // Strategy B: run from each destination until K stations found
        for (int dnode = C + 1; dnode <= N; dnode++) {
            vector<ll> dist(N + 1, INF);
            vector<bool> visited(N + 1, false);
            dist[dnode] = 0;

            priority_queue<pair<ll, int>, vector<pair<ll, int> >, greater<pair<ll, int> > > pq;
            pq.push(make_pair(0, dnode));

            int foundStations = 0;

            while (!pq.empty()) {
                pair<ll, int> top = pq.top();
                pq.pop();
                ll d = top.first;
                int u = top.second;

                if (visited[u]) continue;
                visited[u] = true;

                if (d > R) break;

                if (u <= C) {
                    foundStations++;
                    if (foundStations == K) {
                        wellConnected[dnode] = true;
                        break;
                    }
                }

                for (size_t i = 0; i < adj[u].size(); i++) {
                    int v = adj[u][i].first;
                    ll w = adj[u][i].second;
                    if (!visited[v] && dist[v] > d + w) {
                        ll nd = d + w;
                        if (nd <= R) {
                            dist[v] = nd;
                            pq.push(make_pair(nd, v));
                        }
                    }
                }
            }
        }

        vector<int> result;
        for (int v = C + 1; v <= N; v++) {
            if (wellConnected[v])
                result.push_back(v);
        }

        sort(result.begin(), result.end());
        cout << result.size() << "\n";
        for (size_t i = 0; i < result.size(); i++)
            cout << result[i] << "\n";
    }

    return 0;
}
