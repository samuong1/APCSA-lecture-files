#include <iostream>
#include <vector>
using namespace std;
#define afastio ios::sync_with_stdio(0); cin.tie(0); freopen("06.in", "r", stdin); freopen("06.ans", "w", stdout);

void findPath(vector< vector< vector<int> > >& path, int startCountry, int endCountry, int step) {
    if (path[step][startCountry][endCountry] != -1) {
        findPath(path, startCountry, path[step][startCountry][endCountry], step - 1);
        cout << " " << path[step][startCountry][endCountry] + 1;
    }
}

int main() {
    afastio
    int countryNum;

    while (cin >> countryNum) {
         vector< vector< vector<double> > > bestRateEachStep(countryNum, vector< vector<double> >(countryNum,
                      vector<double>(countryNum, 0)));
         vector< vector< vector<int> > > path(countryNum, vector< vector<int> >(countryNum,
                      vector<int>(countryNum, -1)));
         int startCountry = -1;
         int lastStep = -1;

        for (int i=0; i<countryNum; i++) {
            for (int j=0; j<countryNum; j++) {
                if (i == j)
                    bestRateEachStep[0][i][j] = 1;
                else
                    cin >> bestRateEachStep[0][i][j];
            }
        }
        for (int step=1; step<countryNum; step++) {
            for (int k=0; k<countryNum; k++) {
                for (int i=0; i<countryNum; i++) {
                    for (int j=0; j<countryNum; j++) {
                        if (bestRateEachStep[step - 1][i][k] * bestRateEachStep[0][k][j] > bestRateEachStep[step][i][j]) {
                            bestRateEachStep[step][i][j] = bestRateEachStep[step - 1][i][k] * bestRateEachStep[0][k][j];
                            path[step][i][j] = k;
                        }
                    }
                }
            }
            for (int i=0; i<countryNum; i++) {
                if (bestRateEachStep[step][i][i] > 1.01) {
                    startCountry = i;
                    lastStep = step;
                    break;
                }
            }
            if (startCountry != -1)
                break;
        }
        if (startCountry == -1)
            cout << "no arbitrage sequence exists\n";
        else {
            cout << startCountry + 1;
            findPath(path, startCountry, startCountry, lastStep);
            cout << " " << startCountry + 1 << endl;
        }
    }

    return 0;
}