#include <iostream>
#include <random>
#include "./sorting.hpp"

int main() {
//-----------------1.1--------------------------//
    int a[4] = {4,3,6,1};
    int b[4] = {4,3,6,1};
    InsertionSortAscending(a, 4);
    for (int i = 0; i<4; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;
    InsertionSortDescending(b, 4);

//-----------------1.2--------------------------//
    int c[4] = {4,3,6,1};
    int d[4] = {4,3,6,1};
    BubbleSort(c, 4);
    for (int i = 0; i<4; i++)
        std::cout << c[i] << " ";
    std::cout << std::endl;
    BubbleSortMaxToBack(d, 4);
//-----------------1.3--------------------------//
    int e[4] = {4,3,6,1};
    int f[4] = {4,3,6,1};
    SelectionSort(e, 4);
    SelectionSortMaxIndex(f, 4);
//-----------------1.4--------------------------//
    int g[4] = {4,3,6,1};
    std::cout << "///QuickSort" << std::endl;
    QuickSort(g, 0, 3);
    for (int i = 0; i < 4; i++) 
        std::cout << g[i] << " ";
    std::cout << std::endl;
}
