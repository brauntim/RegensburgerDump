#include <chrono> 
#include <iostream>
#include <climits>
#include "matrix.hpp"

#define MAXTIME 10

using std::chrono::system_clock;
using std::chrono::duration_cast;
using std::chrono::minutes;

long int naivMethod(void (*calc)(const Matrix&, const Matrix&));
long int binSearch (void (*calc)(const Matrix&, const Matrix&));

int main() {
    int binSearchMulTime = binSearch([](const Matrix& A, const Matrix& B) {A*B;});
    int binSearchAddTime = binSearch([](const Matrix& A, const Matrix& B) {A+B;});
    int naivMulTime      = naivMethod([](const Matrix& A, const Matrix& B) {A*B;});
    int naivAddTime      = naivMethod([](const Matrix& A, const Matrix& B) {A+B;});
    return 0;
}

long int naivMethod(void (*calc)(const Matrix&, const Matrix&)) {
    minutes before;
    for (long int i = 1;; i++) {
        Matrix A(i,i);
        Matrix B(i,i);
        auto t1 = system_clock::now();
        calc(A,B);
        auto t2 = system_clock::now();

        auto tMin = duration_cast<minutes>(t2-t1);

        if (tMin.count() > MAXTIME) {
            std::cout << "-------\n" << "iteration: " << i - 1 << "needed this time: " << before.count() << "min" << "\n----------------"<< std::endl;
            return i-1;
        }
        before = tMin;
    }
}

long int binSearch (void (*calc)(const Matrix&, const Matrix&)) {
    long int lowerBound = 1, upperBound = -1;
    do {
        int dim;
        if (upperBound > 0)
            dim = (lowerBound + upperBound) / 2;
        else
            dim = lowerBound * 2;

        Matrix A(dim, dim);
        Matrix B(dim, dim);
        auto t1 = system_clock::now();
        calc(A,B);
        auto t2 = system_clock::now();
        auto tMin = duration_cast<minutes>(t2-t1);

        if (tMin.count() < MAXTIME) 
            lowerBound *= 2;
        else 
            upperBound = dim;

    } while (lowerBound != upperBound);
    return lowerBound;
}
