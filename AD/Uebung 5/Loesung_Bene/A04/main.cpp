#include "matrix.hpp"
#include <chrono>
#include <iostream>
#include <climits>

int main() {
    for (int i = 2; i < INT_MAX; i = i * 2) {
        std::cout << i << std::endl;
        Matrix M(i,i);
        Matrix N(i,i);

        M.randomFill();
        N.randomFill();

        auto tempRecStart = std::chrono::system_clock::now();
        Matrix res1 = M.mult(N);
        auto durationRec = std::chrono::system_clock::now() - tempRecStart;

        auto tempNormStart = std::chrono::system_clock::now();
        Matrix res2 = M*N;
        auto durationNorm = std::chrono::system_clock::now() - tempNormStart;

        if (durationRec <= durationNorm) {
            std::cout << "break even: " << i << std::endl;
            break;
        }
    }

}
