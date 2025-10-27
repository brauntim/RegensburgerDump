#include <iostream>

int ggT(int x, int y) {
    while (x != y) {
        if (x > y) {
            x = x - y;          
        } else {
            y = y - x;          
        }
    }

    return x;
}

int ggTrec(int a, int b) {
    if (a == b) 
        return a;
    else if (a < b) 
        return ggTrec(a, b-a);
    else
        return ggTrec(a-b, b);
}

int kgV(int a, int b) {
    int res = a;
    while (res % b != 0) {
        res += a;
    }

    return res;
}

int main() {
    for (int i = 30; i <= 40; i++) {
        for (int j = i; j <= 40; j++) {
            int resggT = ggT(i,j);
            float reskgV = kgV(i,j);
            std::cout << "ggT(" << i << "," << j << ") = " << ggT(i,j) << std::endl;
            std::cout << "kgV(" << i << "," << j << ") = " << kgV(i,j) << std::endl;
            std::cout << i << " * " << j << " = " << i*j << std::endl;
            std::cout << "----------------------------------------" << std::endl;
        }
    }
}

// -> a*b = kgV(a,b) * ggT(a,b)
