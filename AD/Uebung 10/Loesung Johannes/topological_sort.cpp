#include <iostream>
#include <vector>

using namespace std;

void topologialSort_(vector<vector<int>>& adjlist, int idx, vector<bool>& visited, vector<int>& result, int& resultIdx) {
    visited[idx] = true;

    for (int j = 0; j < adjlist[idx].size(); j++) {
        if (!visited[adjlist[idx][j]]) {
            topologialSort_(adjlist, adjlist[idx][j], visited, result, resultIdx);
        }
    }

    result[resultIdx] = idx;
    resultIdx--;
}

vector<int> topologialSort(vector<vector<int>>& adjlist) {
    vector<bool> visited(adjlist.size(), false);
    vector<int> result(adjlist.size(), -1);
    int resultIdx = adjlist.size() - 1;

    for (int i = 0; i < adjlist.size(); i++) {
        if (!visited[i]) {
            topologialSort_(adjlist, i, visited, result, resultIdx);
        }
    }

    return result;
}

int main() {
    // Test
    vector<vector<int>> adjlist = {
        {4},
        {0, 6, 8},
        {1},
        {},
        {3},
        {4},
        {7},
        {3},
        {}
    };

    vector<int> result = topologialSort(adjlist);

    for (int i = 0; i < result.size(); i++) {
        cout << result[i] << " ";
    }
}