#include "functions.hpp"
#include <iostream>

int main(int argc, char** argv) {
    int m = atoi(argv[1]);
    int n = atoi(argv[2]);
    std::cout << f_recursive(n, m) << std::endl;
    std::cout << f_iterative(n, m) << std::endl;
}
