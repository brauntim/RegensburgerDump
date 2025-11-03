#include <iostream>
template<typename T> void insertionSortRecursive(T a, unsigned int pos, unsigned int n) {
    if (pos == n)
        return;

    int key = a[pos];
    int i = pos-1;
    while (i >= 0 && a[i] > key) {
        a[i+1] = a[i];
        i--;
    }
    a[i+1] = key;
    insertionSortRecursive(a, ++pos, n);
}

template<typename T> void insertionSort(T a, unsigned int n) {
    insertionSortRecursive<T>(a, 1, n);     

    for(int i = 0; i < n; i++) 
        std::cout << a[i] << " ";
    std::cout << std::endl;
}

template<typename T> void Merge(T a, int first, int last, int middle) {
    int amountCells = last - first + 1; 
    int half1First  = first,      half1End = middle - 1;
    int half2First  = middle,     half2End = last;
    int *result     = new int[amountCells];

    for (int i = 0; i < amountCells; i++) {
        if (half1First <= half1End) {
            if (half2First <= half2End) {
                if (a[half1First] <= a[half2First])
                    result[i] = a[half1First++];
                else 
                    result[i] = a[half2First++];
            } else {
                result[i] = a[half1First++];
            }
        } else {
            result[i] = a[half2First++];
        }
    }

    for (int i = 0; i<amountCells; i++) a[first+i] = result[i];

    delete[] result;
}

//bottom up: sort subarrays of length len then sort double the len until len > length
template<typename T> void MergeSortIterative(T a, int length) {
    for (int len = 1; len < length; len *= 2) {
        for (int first = 0; first < length-len; first += 2*len) {
            int mid = first+len;
            int last = (first + 2*len < length-1) ? first + 2*len : length-1;

            Merge<T> (a, first, last, mid);
        }
    }

    for(int i = 0; i < length; i++) 
        std::cout << a[i] << " ";
    std::cout << std::endl;
}

int main() {
    int a[6] = {2,1,6,3,8,3};
    insertionSort<int*>(a, 6);
    int b[6] = {2,1,6,3,8,3};
    MergeSortIterative<int*>(b, 6);
}
