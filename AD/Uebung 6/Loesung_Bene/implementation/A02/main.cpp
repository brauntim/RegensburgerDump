#include "linked_list.cpp"
#include <iostream>

int main() {
    linked_list<int> a;

    int b[10] = {2,1,3,45,5,-5,-1,10,-10,6};

    for (int i = 0; i < 10; i++) {
        a.enqueue(b[i]);     
    }

    a.print();
    a.Quicksort();
    a.print();
}
