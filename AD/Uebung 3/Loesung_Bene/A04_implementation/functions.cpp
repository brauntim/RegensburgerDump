#include "functions.hpp"
#include <stack>

using stack = std::stack<unsigned int>;  

unsigned int f_recursive(unsigned int n, unsigned int m) {
    if (n == 0)
        return m+1;
    if (m==0 && n >=1)
        return f_recursive(n-1, 1);
    return f_recursive(n-1, f_recursive(n, m-1));
}

unsigned int f_iterative(unsigned int n, unsigned int m) {
    stack values;
    values.push(n);

    while (!(values.empty())) {
        n = values.top();
        values.pop();
        if (n == 0)
            m++;
        else if(m == 0) {
            m = 1;
            n--;
            values.push(n);
        } else {
            values.push(n-1);
            values.push(n);
            m--;
        }
    }
    return m;
}
