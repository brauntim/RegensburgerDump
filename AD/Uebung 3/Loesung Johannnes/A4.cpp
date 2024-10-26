#include <iostream>
#include <stack>
#include <unordered_map>

using namespace std;

int f_rek(int n, int m) {
    if (n == 0)
        return m + 1;
    if (m == 0)
        return f_rek(n - 1, 1);
    return f_rek(n-1, f_rek(n, m-1));
}

int f_it(int n, int m) {
    stack<tuple<int, int, bool>> vals;
    vals.push(make_tuple(n, m, false));

    int cur_val = 0;
    bool executed_inner = false;

    while (!vals.empty()) {
        tie(n, m, executed_inner) = vals.top();
        vals.pop();

        if (n == 0) {
            cur_val = m + 1;
        }
        else if (m == 0) {
            vals.push(make_tuple(n - 1, 1, false));
        }
        else if (executed_inner) {
            vals.push(make_tuple(n - 1, cur_val, false));
        }
        else {
            vals.push(make_tuple(n, m, true));
            vals.push(make_tuple(n, m - 1, false));
        }
    }

    return cur_val;
}

struct PairHash {
    template <class T1, class T2>
    std::size_t operator() (const std::pair<T1, T2>& p) const {
        auto a = std::hash<T1>{}(p.first);
        auto b = std::hash<T2>{}(p.second);
        return (a + b) * (a + b + 1) / 2 + a;
    }
};

struct PairEqual {
    template <class T1, class T2>
    bool operator() (const std::pair<T1, T2>& lhs, const std::pair<T1, T2>& rhs) const {
        return lhs.first == rhs.first && lhs.second == rhs.second;
    }
};

int _f_rek_memo(int n, int m, unordered_map<pair<int, int>, int, PairHash, PairEqual>& memo) {
    if (n == 0)
        return m + 1;

    if (memo.find(make_pair(n,m)) != memo.end())
        return memo[make_pair(n, m)];

    int val;
    if (m == 0)
        val = _f_rek_memo(n - 1, 1, memo);
    else
        val = _f_rek_memo(n-1, _f_rek_memo(n, m-1, memo), memo);

    memo[make_pair(n,m)] = val;
    return val;
}

int f_rek_memo(int n, int m) {
    unordered_map<pair<int, int>, int, PairHash, PairEqual> memo;
    return _f_rek_memo(n, m, memo);
}

int main() {

    unordered_map<pair<int, int>, int, PairHash, PairEqual> memo;

    for (int i = 0; i <= 3; i++) {
        for (int j = 0; j <= 3; j++) {
            if (i == 4 && j == 1) {
                ;
            }
            cout << f_rek(i, j) << '\t' << flush;
        }
        cout << '\n';
    }

    return 0;
}

// 1       2       3       4       5       6       7
// 2       3       4       5       6       7       8
// 3       5       7       9       11      13      15
// 5       13      29      61      125     253     509