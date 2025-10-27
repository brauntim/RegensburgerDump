#include "matrix.hpp"
#include <iostream>

int main() {
    Matrix A(3,3);
    Matrix B(3,3);
    std::cout << "A" << std::endl;
    A.print();
    std::cout << "B" << std::endl;
    B.print();
    A.randomFill();
    std::cout << "A random(from -100 to 100)" << std::endl;
    A.print();
    B.randomFill();
    std::cout << "B random(from -100 to 100)" << std::endl;
    B.print();
    std::cout << "A+B" << std::endl;
    Matrix C = A+B;
    C.print();
    std::cout << "A*B" << std::endl;
    Matrix D = A*B;
    D.print();
    return 0;
}
