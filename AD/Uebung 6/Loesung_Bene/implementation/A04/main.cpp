#include "sort.cpp"
#include <iostream>

int main() {
    int a[8] = {3,2,2,34,12,5,0,9};
    int b[8] = {3,2,2,34,12,5,0,9};

    for (int i = 0; i < 8; i++) 
        std::cout << a[i] << " ";
    std::cout << std::endl;

    countSort(a, 8, 34);

    for (int i = 0; i < 8; i++) 
        std::cout << a[i] << " ";
    std::cout << std::endl;

    for (int i = 0; i < 8; i++) 
        std::cout << b[i] << " ";
    std::cout << std::endl;

    countSortFaster(b, 8, 34);

    for (int i = 0; i < 8; i++) 
        std::cout << b[i] << " ";
    std::cout << std::endl;
}
