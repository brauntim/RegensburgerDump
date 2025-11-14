#pragma once
#include <iostream>

//Note that this countsort only works on positive Values (no negatives allowed because no negative index is possible)
void countSort(int* a, int n, int k) {
    int count[k+1] = { 0 };

    for (int i = 0; i < n; i++)     //Theta(n)
        count[a[i]]++;

    int currentIndex = 0;
    for (int i = 0; i <= k; i++) {  //Theta(k)
        while (count[i] != 0) {    //Theta(3n)
            a[currentIndex] = i;
            currentIndex++;
            count[i]--;
        }

    }
}

void countSortFaster(int* a, int n, int k) { //Theta(2k + 3n)
    int count[k+1] = { 0 };                  //Theta(k+1) = Theta(k)
    int res[n];              

    for (int i = 0; i < n; i++)              //Theta(n)
        count[a[i]]++;

    int idx = 0;
    for (int val = 0; val <= k; val++) {     // Theta(k)
        while(count[val]--)                  // Theta(n)
            a[idx++] = val;                  // Theta(n)
    }
}
