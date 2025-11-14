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

void countSortFaster(int* a, int n, int k) {
    int count[k+1] = { 0 };          //Theta(k+1) = Theta(k)
    int res[n];

    for (int i = 0; i < n; i++)      //Theta(n)
        count[a[i]]++;

    for (int i = 1; i <= k; i++)     //Theta(k+1) = Theta(k)
        count[i] += count[i-1];

    for (int i = n-1; i >= 0; i--) { // Theta(2n)
        count[a[i]]--;
        res[count[in]] = a[i];
    }

    for (int i = 0; i < n; i++) 
        a[i] = res[i];
}
