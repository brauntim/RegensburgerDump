#include <iostream>
#include <random>
//-----------------1.1--------------------------//
template<typename T=int*> void InsertionSortAscending(T a, unsigned int n) {
    int key;

    for (int j = 1; j<n; j++) {
        key = a[j];
        int i = j-1;
        while (i >= 0 && a[i] > key) { 
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = key;
    }
}

template<typename T=int*> void InsertionSortDescending(T a, unsigned int n) {
    int key;

    for (int j = 1; j<n; j++) {
        key = a[j];
        int i = j-1;
        while (i >= 0 && a[i] < key) { //less than
            a[i+1] = a[i];
            i--;
        }
        a[i+1] = key;
    }
}

//-----------------1.2--------------------------//
template<typename T=int*> void BubbleSort(T a, int n) {
    for (int i = 0; i<n; i++) {
        for (int j = n-2; j>=i; j--) {
            if (a[j] > a[j+1]) {
                int tmp = a[j];
                a[j]    = a[j+1];
                a[j+1]  = tmp;
            }
        }
    }
}

template<typename T=int*> void BubbleSortMaxToBack(T a, int n) {
    std::cout << "///BubbleSortMaxToBack" << std::endl;
    for (int i = n-1; i>=0; i--) {
        for (int j = 1; j<=i; j++) {
            if (a[j] < a[j-1]) {
                int tmp = a[j];
                a[j]    = a[j-1];
                a[j-1]  = tmp;
            }
        }
        for (int k=0; k<n; k++) 
            std::cout << a[k] << " ";
        std::cout << std::endl;
    }
}

//-----------------1.3--------------------------//
template<typename T=int*> void SelectionSort(T a, int n) {
    std::cout << "///SelectionSort" << std::endl;
    int minIndex;
    for (int i = 0; i<n; i++) {
        minIndex = i;
        for (int j=i; j<n; j++) {
            minIndex = (a[j] < a[minIndex]) ? j : minIndex;
        }

        int tmp = a[i];
        a[i]    = a[minIndex];
        a[minIndex]  = tmp;
        for (int k= 0; k<n; k++)
            std::cout << a[k] << " ";
        std::cout << std::endl;
    }
}
template<typename T=int*> void SelectionSortMaxIndex(T a, int n) {
    std::cout << "///SelectionSortMaxIndex" << std::endl;
    int maxIndex;
    for (int i = n-1; i>=0; i--) {
        maxIndex = i;
        for (int j=i; j>=0; j--) {
            maxIndex = (a[j] > a[maxIndex]) ? j : maxIndex;
        }

        int tmp = a[i];
        a[i]    = a[maxIndex];
        a[maxIndex]  = tmp;
        for (int k= 0; k<n; k++)
            std::cout << a[k] << " ";
        std::cout << std::endl;
    }
}

//-----------------1.4--------------------------//
void swap(int &a, int &b) {
    int tmp = a;
    a       = b;
    b       = tmp;
}
template<typename T=int*> void PreparePartition(T a, unsigned int first, unsigned int last, int &pos){
    swap(a[first], a[pos]);
    int pivot = a[first];
    pos = first;

    for (int i = first; i<=last; i++) {
        if (a[i] < pivot) {
            pos++; 
            swap(a[i], a[pos]);
        }
    }
    swap(a[first], a[pos]);
}
template<typename T=int*> void QuickSort(T a, int first, int last) {
    static std::random_device rd;
    static std::mt19937 gen(rd());
    std::uniform_int_distribution<unsigned int> dist(first, last);
    int pos = dist(gen);

    if (first<last) {
        PreparePartition(a,first, last, pos);
        if (first < pos-1)
            QuickSort<T>(a, first, pos-1);
        if (last > pos+1)
            QuickSort<T>(a, pos+1, last);
    }
}

template<typename T=int*> void Merge(T a, int first, int last, int middle) {
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
template<typename T=int*> void MergeSort(T a, int first, int last) {
    if (first < last) {
        int middle = (first+last+1) / 2;
        MergeSort<T>(a, first, middle-1);
        MergeSort<T>(a, middle, last);
        Merge<T>(a, first, last, middle);
    }
}
