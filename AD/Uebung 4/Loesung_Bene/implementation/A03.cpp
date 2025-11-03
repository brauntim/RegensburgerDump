#include "sorting.hpp"
#include <iostream>

bool findS(int a[], int n, int s) {
    MergeSort(a, 0, n-1);

    for (int i = 0; i < n; i++)
        std::cout << a[i] << " ";
    std::cout << std::endl;

    int posA = 0;
    int posB = 1;
    bool moveB = true; //if false move A

    while (posA < n && posB < n) {
        int test = a[posA]+a[posB];
        if (test == s) {
            return true;
        } else if (test>s){
            posB--;
            if (posB == posA) 
                return false;
            moveB = false;
        } else {
            if (posB < n-1 && moveB) 
                posB++;
            else if (posA < n-1) {
                posA++;
                moveB = true;
            } else 
                return false;
        }
    }
    return false;
}

int main(int argc, char** argv) {
    int a[6] = {2, 4, 2, 1, 9, 1};
    int s = atoi(argv[1]);
    if (findS(a, 6, s))
        std::cout << "yeyyy" << std::endl;
    else 
        std::cout << "neyyy" << std::endl;
}
